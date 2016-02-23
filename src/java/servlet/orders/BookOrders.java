/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.orders;

import dao.book.BookDAO;
import dao.orders.BookOrderDAO;
import dao.orders.CartDAO;
import dao.person.GetId;
import entity.book.Book;
import entity.orders.BookOrder;
import entity.orders.Cart;
import java.io.IOException;
import java.io.PrintWriter;
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
public class BookOrders extends HttpServlet {

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
            out.println("<title>Servlet Orders</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Orders at " + request.getContextPath() + "</h1>");
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
        String id = request.getParameter("id");
        String quantity = request.getParameter("quantity");
        HttpSession session = request.getSession(true);
        Cart cart = (Cart) session.getAttribute("CART");
        GetId getId = new GetId();
        if (cart == null) {
            //create cart
            //tao session luu trang thai gio hang
            int idCart = getId.getValueId();
            cart = new Cart();
            cart.setId(idCart);
            //add cart
            CartDAO cartDAO = new CartDAO();
            cartDAO.createCart(cart);
        }
        int idBookOrder = getId.getValueId();
        Book book = new Book();
        BookDAO bookDAO = new BookDAO();
        book = bookDAO.getBookById(Integer.parseInt(id));
        float totalPrice = Integer.parseInt(quantity) * book.getSalePrice();
        BookOrder bookOrder = new BookOrder(idBookOrder, Integer.parseInt(quantity), totalPrice, book, cart);
        BookOrderDAO bookOrderDAO = new BookOrderDAO();
        bookOrderDAO.addBookOrder(bookOrder);
        //
        cart.getArr().add(bookOrder);
        cart.setTotalPrice(cart.getTotalPrice() + totalPrice);
        cart.setTotalPrice(totalPrice);
        //end set session
        session.setAttribute("CART", cart);
        request.setAttribute("book", book);
        request.setAttribute("add_book_to_cart", book);
        request.setAttribute("quantity", quantity);
        RequestDispatcher dis = getServletContext().getRequestDispatcher("/detail.jsp");
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
