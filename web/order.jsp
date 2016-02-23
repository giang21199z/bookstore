<%-- 
    Document   : order
    Created on : Feb 22, 2016, 4:40:43 PM
    Author     : GIANGND-SVMC
--%>

<%@page import="entity.person.Customer"%>
<%@page import="dao.book.BookSetDAO"%>
<%@page import="entity.book.BookSet"%>
<%@page import="dao.book.CategoryDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entity.book.Category"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="templatemo_style.css" rel="stylesheet" type="text/css" />
        <title>JSP Page</title>
    </head>
    <body>
        <!--  Free CSS Templates from www.templatemo.com -->
        <div id="templatemo_container">
            <%@include file="menu.jsp" %>

            <%@include file="header.jsp" %> <!-- end of header -->

            <div id="templatemo_content">

                <div id="templatemo_content_left">
                    <div class="templatemo_content_left_section">
                        <h1>Categories</h1>
                        <ul>
                            <%
                                ArrayList<Category> listCategory = null;
                                CategoryDAO categoryDAO = new CategoryDAO();
                                listCategory = categoryDAO.getCategoryHomepage();
                                for (int i = 0; i < listCategory.size(); i++) {%>  
                            <li>
                                <a href="#"><%=listCategory.get(i).getDescription()%></a>
                            </li>
                            <%}%>
                        </ul>
                    </div>
                    <div class="templatemo_content_left_section">
                        <h1>BookSet</h1>
                        <ul>
                            <%
                                ArrayList<BookSet> listBookSet = null;
                                BookSetDAO bookSetDAO = new BookSetDAO();
                                listBookSet = bookSetDAO.getBookSetHompage();
                                for (int i = 0; i < listBookSet.size(); i++) {%>  
                            <li>
                                <a href="#"><%=listBookSet.get(i).getDescription()%></a>
                            </li>
                            <%}%>
                        </ul>
                    </div>

                    <div class="templatemo_content_left_section">                
                        <a href="#"><img style="border:0;width:88px;height:31px" src="images/facebook.png" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
                        <a href="#"><img style="border:0;width:88px;height:31px" src="images/glus.png" alt="Valid XHTML 1.0 Transitional" width="88" height="31" vspace="8" border="0" /></a>
                    </div>
                </div> <!-- end of content left -->

                <div id="templatemo_content_right">
                    <h2>Thông tin giao hàng</h2>
                    <% CustomerMember customerMember = (CustomerMember) request.getAttribute("CUSTOMER_MEMBER");
                        if (customerMember != null) {%>
                    <form name="register" action="Order" method="post">          
                        <div class="form_row">
                            <label class="contact"><strong>Fullname</strong></label>
                            <input type="text" class="contact_input"  name="fullname"
                                   value="<%=customerMember.getFullname().getFullname()%>"
                                   />
                        </div> 
                        <div class="form_row">
                            <input type="hidden" value="<%=customerMember.getAddress().getIdaddress()%>" name="idaddress">
                            <label class="contact"><strong>Num</strong></label>
                            <input type="text" class="contact_input"  name="num"
                                   value="<%=customerMember.getAddress().getNum()%>"
                                   />
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Ward</strong></label>
                            <input type="text" class="contact_input"  name="ward"
                                   value="<%=customerMember.getAddress().getWard()%>"
                                   />
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Dictric</strong></label>
                            <input type="text" class="contact_input"  name="dictric"
                                   value="<%=customerMember.getAddress().getDictric()%>"
                                   />
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>City</strong></label>
                            <input type="text" class="contact_input"  name="city"
                                   value="<%=customerMember.getAddress().getCity()%>"
                                   />
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Phone</strong></label>
                            <input type="text" class="contact_input"  name="phone"
                                   value="<%=customerMember.getPhone()%>"
                                   />
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Email</strong></label>
                            <input type="email" class="contact_input"  name="email"
                                   value="<%=customerMember.getEmail()%>"
                                   />
                        </div> 

                        <div class="form_row">
                            <div class="terms">
                                <input type="checkbox" name="terms" />
                                Tôi xác nhận thông tin giao hàng</div>
                        </div> 


                        <div class="form_row">
                            <input type="submit" class="register" value="Xác nhận" />
                        </div>   
                    </form>     
                    <%} else {%>
                    <form name="register" action="Order" method="post">          
                        <div class="form_row">
                            <label class="contact"><strong>Fullname</strong></label>
                            <input type="text" class="contact_input"  name="fullname"/>
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Num</strong></label>
                            <input type="text" class="contact_input"  name="num"/>
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Ward</strong></label>
                            <input type="text" class="contact_input"  name="ward"/>
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Dictric</strong></label>
                            <input type="text" class="contact_input"  name="dictric"/>
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>City</strong></label>
                            <input type="text" class="contact_input"  name="city"/>
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Phone</strong></label>
                            <input type="text" class="contact_input"  name="phone"/>
                        </div> 
                        <div class="form_row">
                            <label class="contact"><strong>Email</strong></label>
                            <input type="email" class="contact_input"  name="email"/>
                        </div> 

                        <div class="form_row">
                            <div class="terms">
                                <input type="checkbox" name="terms" />
                                Tôi xác nhận thông tin giao hàng</div>
                        </div> 


                        <div class="form_row">
                            <input type="submit" class="register" value="Xác nhận" />
                        </div>   
                    </form>     
                    <%}%>
                </div><!-- end of content right -->

                <div class="cleaner_with_height">&nbsp;</div>
            </div> <!-- end of content -->

            <%@include file="footer.jsp" %>
            <!-- end of footer -->
            <!--  Free CSS Template www.templatemo.com -->
        </div> <!-- end of container -->
    </body>
</html>
