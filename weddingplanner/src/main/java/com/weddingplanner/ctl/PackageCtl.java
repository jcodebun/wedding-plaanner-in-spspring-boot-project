package com.weddingplanner.ctl;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
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

import com.weddingplanner.dto.PackageDTO;
import com.weddingplanner.dto.UserDTO;
import com.weddingplanner.exception.RecordNotFoundException;
import com.weddingplanner.form.PackageForm;
import com.weddingplanner.form.UserForm;
import com.weddingplanner.service.PackageService;

@Controller
public class PackageCtl {
	
	@Autowired
	private PackageService service;
	
	@GetMapping("/package")
	public String PackagePage(@ModelAttribute("form")PackageForm form) {
		return "package";
	}
	
	@PostMapping("/addPackage")
	public String Add(@RequestParam(value = "image") MultipartFile image, @Valid @ModelAttribute("form")PackageForm form,  BindingResult bindingResult, Model model) throws IOException {

		System.out.println("form: "+form);
		try {
		if (bindingResult.hasErrors()) {
			System.out.println("bindingResult : "+bindingResult);
			return "package";
		}else {
			PackageDTO bean = form.getDTO();
			bean.setImage(image.getBytes());
			if(form.getId()>0) {
				
				service.update(bean);
				model.addAttribute("success", "Package Updated successfully");
			}else {
			
				service.Add(bean);
				model.addAttribute("success", "Package Added successfully");
			}
			
			return "package";
		}}catch (RecordNotFoundException e) {
			// TODO: handle exception
			model.addAttribute("error", e.getMessage());
			e.printStackTrace();
			return "package";
		}
	}
	
	@GetMapping("/packageList")
	public String list(@ModelAttribute("form")PackageForm form, Model model){
	List<PackageDTO> list = service.list();
	model.addAttribute("list", list);
	return "packagelist";
		
	}
	
	@GetMapping("/packageEdit")	
	public String update(@ModelAttribute("form")PackageForm form, Model model, @RequestParam("id") long id ){
		PackageDTO bean = service.findPackageById(id);
		form.populate(bean);
		model.addAttribute("bean",bean);	
		return "package";
	}
	
	@GetMapping("/packageDelete")	
	public String delete(@ModelAttribute("form")PackageForm form, Model model, @RequestParam("id") long id ) throws Exception{
		service.delete(id);	
		
		List<PackageDTO> list =	service.list();
		model.addAttribute("list", list);
		model.addAttribute("success", "Package Deleted successfully");
		return "packagelist";
	}


	@GetMapping("/getPackageImage/{id}")
	public void getNewsImage(HttpServletResponse response, @PathVariable("id") long id) throws Exception {
		response.setContentType("image/jpeg");		
		Blob blb=service.getImageById(id);				
		byte[] bytes = blb.getBytes(1, (int) blb.length());
		InputStream inputStream = new ByteArrayInputStream(bytes);
		IOUtils.copy(inputStream, response.getOutputStream());
	
	}
}
