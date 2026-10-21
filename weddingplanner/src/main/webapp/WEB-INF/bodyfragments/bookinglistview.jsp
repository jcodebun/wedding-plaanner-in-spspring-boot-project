<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking List</title>
</head>
<body>

<div class="container">

<h2 style="padding: 30px">Booking History</h2>
<%@include file="businessMessage.jsp" %>

<table class="table bg-light text-dark">
  <thead>
    <tr>
      
      <th scope="col">Package Title</th>
      <th scope="col">Date</th>
      <th scope="col">FirstName</th>
      <th scope="col">LastName</th>
      <th scope="col">Email</th>
      <th scope="col">Contact</th> 
      <th scope="col">Total Price</th>     
      <th scope="col">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list}" var="li" varStatus="u">
    <tr>     
      <td>${li.title}</td>
      <td>${li.date}</td>
      <td>${li.firstName}</td>
      <td>${li.lastName}</td>
       <td>${li.email}</td>
        <td>${li.phoneNumber}</td>
         <td>${li.price}</td>
      <td>     
      <c:choose>
      <c:when test="${sessionScope.user.userRole == 'Admin'}">
      <a class="btn btn-primary" href="${pageContext.request.contextPath}/cancel?id=${li.id}">${li.status}</a>
     
      
      </c:when>
      <c:otherwise>
       <a class="btn btn-primary" href="${pageContext.request.contextPath}/cancel?id=${li.id}">${li.status}</a>
      </c:otherwise>
      
      
      </c:choose> 
          
      </td>
    </tr>
   </c:forEach>
  </tbody>
</table>

</div>

</body>
</html>