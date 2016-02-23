<%-- 
    Document   : menu
    Created on : Feb 16, 2016, 6:30:32 PM
    Author     : GIANGND-SVMC
--%>

<%@page import="entity.orders.Cart"%>
<%@page import="entity.person.CustomerMember"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="templatemo_menu">
    <ul>
        <li><a href="index.jsp" class="current">Trang chủ</a></li>
        <li><a href="cart.jsp">Giỏ hàng 
                <b style="color: red">
                    <% Cart cart = (Cart) session.getAttribute("CART");
                        if (cart != null) {
                            out.print(cart.getArr().size());
                        }
                    %>
                </b>
            </a>
        </li>
        <%CustomerMember customer = (CustomerMember) session.getAttribute("USER");
            if (customer != null) {
                String username = customer.getUsername();
        %>
        <li><a href="#">Xin chào <%=username%></a></li>
        <li><a href="Logout">Đăng xuất</a></li>
            <%} else {%>
        <li><a href="login.jsp">Đăng nhập</a></li>
        <li><a href="register.jsp">Đăng ký</a></li>
            <%}%>
    </ul>
</div> <!-- end of menu -->