/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.person;

import dao.person.CustomerMemberDAO;
import dao.person.GetId;
import entity.bank.KcoinBank;
import entity.person.Address;
import entity.person.CustomerMember;
import entity.person.Fullname;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author GIANGND-SVMC
 */
public class Register extends HttpServlet {

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
            out.println("<title>Servlet Register</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet GIANG at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String fullname = request.getParameter("fullname");
        String fname = null;
        String mname = null;
        String lname = null;
        String num = request.getParameter("num");
        String ward = request.getParameter("ward");
        String dictrict = request.getParameter("dictric");
        String city = request.getParameter("city");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        int i = fullname.indexOf(" ");
        fname = fullname.substring(0, i);
        int k = fullname.lastIndexOf(" ");
        lname = fullname.substring(k + 1);
        mname = fullname.substring(i + 1, k);

        GetId getId = new GetId();
        int id = getId.getValueId();
        Fullname fn = new Fullname(id, fname, mname, lname);
        Address address = new Address(id, num, ward, dictrict, city);
        KcoinBank kcoinBank = new KcoinBank();
        kcoinBank.setIdbank(id);
        kcoinBank.setBalance(0);
        kcoinBank.setPart("Kcoin");
        CustomerMember cm = new CustomerMember();
        cm.setIdperson(id);
        cm.setUsername(username);
        cm.setPassword(password);
        cm.setFullname(fn);
        cm.setAddress(address);
        cm.setPhone(phone);
        cm.setEmail(email);
        cm.setCoinBank(kcoinBank);
        cm.setPart("CustomerMember");
        CustomerMemberDAO cmd = new CustomerMemberDAO("root", "");
        cmd.register(cm);
        response.sendRedirect("index.jsp");
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
