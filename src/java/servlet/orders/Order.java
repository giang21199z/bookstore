/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.orders;

import dao.orders.Context;
import dao.orders.OrdersDAO;
import dao.orders.UnconfimredOrder;
import dao.person.CustomerDAO;
import dao.person.CustomerMemberDAO;
import dao.person.GetId;
import dao.shipping.ShippingInforDAO;
import entity.orders.Payment;
import entity.person.Address;
import entity.person.Customer;
import entity.person.CustomerMember;
import entity.person.CustomerNotMember;
import entity.person.Fullname;
import entity.person.Person;
import entity.shipping.ShippingInfor;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GIANGND-SVMC
 */
public class Order extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Order</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Order at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        CustomerMember customerMember = (CustomerMember) session.getAttribute("USER");
        if (customerMember != null) {
            CustomerMemberDAO customerMemberDAO = new CustomerMemberDAO();
            customerMember = customerMemberDAO.getCustomerByUsername(customerMember.getUsername());
            request.setAttribute("CUSTOMER_MEMBER", customerMember);
            RequestDispatcher dis = getServletContext().getRequestDispatcher("/order.jsp");
            dis.forward(request, response);
        } else {
            response.sendRedirect("order.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String fullname = request.getParameter("fullname");
        String num = request.getParameter("num");
        String ward = request.getParameter("ward");
        String dictric = request.getParameter("dictric");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String idaddress = request.getParameter("idaddress");
        System.out.println("ID1 address=" + idaddress);
        GetId getId = new GetId();
        int id = getId.getValueId();

        Address addressShipping = new Address();
        if (idaddress != null) {
            addressShipping.setIdaddress(Integer.parseInt(idaddress));
        } else {
            addressShipping.setIdaddress(id);
        }
        addressShipping.setCity(city);
        addressShipping.setDictric(dictric);
        addressShipping.setNum(num);
        addressShipping.setWard(ward);
        ShippingInfor shippingInfor = new ShippingInfor();
        shippingInfor.setId(id);
        shippingInfor.setAddress(addressShipping);
        HttpSession session = request.getSession(true);
        CustomerMember customerMember = (CustomerMember) session.getAttribute("USER");
        if (customerMember != null) {
            //customer da dang nhap
            CustomerMemberDAO customerMemberDAO = new CustomerMemberDAO();
            customerMember = customerMemberDAO.getCustomerByUsername(customerMember.getUsername());
            shippingInfor.setCustomer(customerMember);
        } else {
            //ko phai customer them moi customer
            String fname = null;
            String mname = null;
            String lname = null;

            int i = fullname.indexOf(" ");
            fname = fullname.substring(0, i);
            int k = fullname.lastIndexOf(" ");
            lname = fullname.substring(k + 1);
            mname = fullname.substring(i + 1, k);
            Fullname fn = new Fullname(id, fname, mname, lname);

            CustomerNotMember customerNotMember = new CustomerNotMember(phone, email, id, fn, addressShipping, "CustomerNotMember");
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.addCustomer(customerNotMember);
            shippingInfor.setCustomer(customerNotMember);
        }
        ShippingInforDAO shippingInforDAO = new ShippingInforDAO();
        System.out.println("ID address 2:" + shippingInfor.getAddressShipping().getIdaddress());
        shippingInforDAO.addShippingInfor(shippingInfor);
        entity.orders.Order orders = new entity.orders.Order();
        Payment payment = (Payment) session.getAttribute("PAYMENT");

        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        orders.setDate(sqlDate);
        orders.setId(id);
        orders.setPayment(payment);
        orders.setShippingInfor(shippingInfor);
        OrdersDAO ordersDAO = new OrdersDAO();
        Context context = new Context();
        UnconfimredOrder unconfimredOrder = new UnconfimredOrder();
        unconfimredOrder.doAction(context);
        ordersDAO.addOrder(orders, context);

        //Xoa session
        session.removeAttribute("PAYMENT");
        session.removeAttribute("CART");
        request.setAttribute("ORDERSUCESS", true);
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/index.jsp");
        dis.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
