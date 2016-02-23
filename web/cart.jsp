<%-- 
    Document   : cart
    Created on : Feb 17, 2016, 10:11:59 AM
    Author     : GIANGND-SVMC
--%>

<%@page import="entity.book.Book"%>
<%@page import="entity.orders.BookOrder"%>
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
                    <% Cart cart2 = (Cart) session.getAttribute("CART");
                        if (cart2 != null) {
                            ArrayList<BookOrder> arrBookOrder = cart2.getArr();
                            for (int i = 0; i < arrBookOrder.size(); i++) {
                    %>
                    <div class="image_panel"><img src="images/<%=arrBookOrder.get(i).getBook().getImage()%>" alt="CSS Template" width="100" height="150" /></div>
                    <h2>Tác giả: <span><%=arrBookOrder.get(i).getBook().getAuthor()%></span></h2>
                    <ul>
                        <li>Nhà xuất bản: <a href="#"><%=arrBookOrder.get(i).getBook().getPublisher()%></a></li>
                        <li>Năm xuất bản:<%=arrBookOrder.get(i).getBook().getPublishYear()%></li>
                        <li>Thể loại: <%=arrBookOrder.get(i).getBook().getCategory().getDescription()%></li>
                        <li>Bookset: <%=arrBookOrder.get(i).getBook().getBookSet().getDescription()%></li>
                        <li><b>Giá gốc: <%=arrBookOrder.get(i).getBook().getOriginalPrice()%>00 VNĐ</b></li>
                        <li><b>Giá bán: <%=arrBookOrder.get(i).getBook().getSalePrice()%>00 VNĐ</b></li>
                    </ul>
                    <%}}%>
                    <form action="Payment" method="get">
                                <div class="buy_now_button">
                                    <button style="clear: both;
                                            text-align: center;
                                            display: block;
                                            width: 100px;
                                            padding: 4px 0 5px 0;
                                            margin-bottom: 10px; 
                                            background: url(images/templatemo_btn_02.jpg) no-repeat;
                                            color: #FFFFFF;
                                            border: 0px;
                                            font-weight: bold;
                                            margin-top: 20px;
                                            margin-left: 100px;
                                            text-decoration: none;"
                                            type="submit">
                                        Thanh toán</button>
                                </div>
                            </form>
                </div><!-- end of content right -->

                <div class="cleaner_with_height">&nbsp;</div>
            </div> <!-- end of content -->

            <%@include file="footer.jsp" %>
            <!-- end of footer -->
            <!--  Free CSS Template www.templatemo.com -->
        </div> <!-- end of container -->
    </body>
</html>
