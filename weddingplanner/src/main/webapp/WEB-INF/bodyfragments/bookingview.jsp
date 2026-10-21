<%@page import="java.text.DateFormat"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="crt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>

<body >
<%DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd"); %>
<section class="vh-100 gradient-custom ">
  <div class="container py-5 h-100">
    <div class="row justify-content-center align-items-center h-100">
      <div class="col-12 col-lg-9 col-xl-7">
        <div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
          <div class="card-body p-4 p-md-5">
           <%@include file="businessMessage.jsp" %>
            <h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Package Booking</h3>
            
             
            <sf:form method="post" action="${pageContext.request.contextPath}/addBooking" modelAttribute="form">
            <sf:input type="hidden" id="id" class="form-control form-control-lg" path="id" name="id" value="${form.id}"/>
            <sf:input type="hidden" id="packageId" class="form-control form-control-lg" path="packageId" name="packageId" value="${packagew.id}"/>
           


              <div class="row">
          
                <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="firstName">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="text" id="firstName" class="form-control form-control-lg" path="firstName" value="${user.firstName}" readonly="true"/>
                    <label class="form-label" for="firstName">First Name</label>
                  </div>
					</s:bind>
                </div> 
                
                <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="lastName">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="text" id="lastName" class="form-control form-control-lg" path="lastName" value="${user.lastName}" readonly="true"/>
                    <label class="form-label" for="lastName">Last Name</label>
                  </div>
					</s:bind>
                </div>
                
                 <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="email">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="email" id="email" class="form-control form-control-lg" path="email" value="${user.email}" readonly="true"/>
                    <label class="form-label" for="email">email</label>
                  </div>
					</s:bind>
                </div>
                
                    <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="phoneNumber">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="contact" id="phoneNumber" class="form-control form-control-lg" path="phoneNumber" value="${user.phoneNumber}" readonly="true"/>
                    <label class="form-label" for="phoneNumber">contact</label>
                  </div>
					</s:bind>
                </div>
                
                 <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="title">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="text" id="title" class="form-control form-control-lg" path="title"  value="${packagew.title}"/>
                    <label class="form-label" for="numberOfTicket">Package Title</label>
                  </div>
					</s:bind>
                </div>
                
                  <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="date">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="date" id="date" class="form-control form-control-lg" path="date" min="<%= df.format(new java.util.Date())%>" />
                    <label class="form-label" for="date">Booking Date</label>
                  </div>
					</s:bind>
                </div>
                
             <div class="col-md-6 mb-4 pb-2">
                 <s:bind path="price">
                  <div class="form-outline">
                  <font color="red" style="font-size: 15px"><sf:errors path="${status.expression}" /></font>
                    <sf:input type="price" id="price" class="form-control form-control-lg" path="price" value="${packagew.price}"/>
                    <label class="form-label" for="price">Price</label>
                  </div>
					</s:bind>
                </div>
                
              </div>
 

                <c:choose>
  				<c:when test="${form.id>0}">
   				  <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Pay and Book" />
              </div>   
 			</c:when>

  			<c:otherwise>
             <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Pay and Book" />
              </div>
  			</c:otherwise>
			</c:choose> 

           </sf:form>
          
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
</body>