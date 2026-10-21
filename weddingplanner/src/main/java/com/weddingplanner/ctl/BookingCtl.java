package com.weddingplanner.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import com.weddingplanner.dto.BookingDTO;
import com.weddingplanner.dto.PackageDTO;
import com.weddingplanner.dto.UserDTO;
import com.weddingplanner.exception.RecordNotFoundException;
import com.weddingplanner.form.BookingForm;
import com.weddingplanner.form.PackageForm;
import com.weddingplanner.service.BookingService;
import com.weddingplanner.service.PackageService;
import com.weddingplanner.service.UserService;

@Controller
public class BookingCtl {

	@Autowired
	public BookingService service;

	@Autowired
	public PackageService packageService;
	
	@Autowired
	public UserService userService;
	
	@GetMapping("/booking")
	public String BookingPage(@ModelAttribute("form")BookingForm form, @RequestParam("id") long id, Model model, HttpSession session) {
		
		UserDTO user = (UserDTO)session.getAttribute("user");
        PackageDTO packagew = packageService.findPackageById(id);
        System.out.println("packagew: "+packagew);
        model.addAttribute("user", user);
        model.addAttribute("packagew", packagew);
		
		return "booking";
	}
	
	@PostMapping("/addBooking")
	public String Add(@Valid @ModelAttribute("form")BookingForm form,  BindingResult bindingResult, Model model, HttpSession session) {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "booking";
		}else {
			UserDTO user = (UserDTO)session.getAttribute("user");
			BookingDTO bean = form.getDTO();
			System.out.println("From Date: "+bean);
			bean.setId(0);
			bean.setUserId(user.getId());
			bean.setStatus("Cancel");
			service.Add(bean);
			model.addAttribute("totalPrice", bean.getPrice());
			model.addAttribute("success", "Booking Aded successfully");

			return "redirect:/payment";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "booking";
		}
	}
	
	@GetMapping("/bookingList")
	public String list(@ModelAttribute("form")BookingForm form, Model model, HttpSession session){
		List<BookingDTO> list = null;
	UserDTO user = (UserDTO)session.getAttribute("user");
	if(user.getUserRole().equals("User")) {
		list = service.list(user.getEmail());
	}else {
		list = service.list();
	}
	
	model.addAttribute("list", list);
	
	return "bookinglist";
		
	}
	
	@GetMapping("/bookingEdit")	
	public String update(@ModelAttribute("form")BookingForm form, Model model, @RequestParam("id") long id ){
		BookingDTO bean = service.findBookingById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "booking";
	}
	
	@GetMapping("/bookingDelete")	
	public String delete(@ModelAttribute("form")BookingForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);			
		List<BookingDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Train Deleted successfully");
		return "bookinglist";
	}
	
	
	@GetMapping("/cancel")	
	public String cancel(@ModelAttribute("form")BookingForm form, Model model, @RequestParam("id") long id ) throws Exception{
		BookingDTO dto = service.findBookingById(id);
		dto.setStatus("Canceled");
		service.update(dto);
		
		return "redirect:/bookingList";
	}



}
