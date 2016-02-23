package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.book.BookSetDAO;
import entity.book.BookSet;
import dao.book.CategoryDAO;
import java.util.ArrayList;
import entity.book.Category;
import entity.orders.Cart;
import entity.person.CustomerMember;

public final class order_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(3);
    _jspx_dependants.add("/menu.jsp");
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link href=\"templatemo_style.css\" rel=\"stylesheet\" type=\"text/css\" />\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--  Free CSS Templates from www.templatemo.com -->\n");
      out.write("        <div id=\"templatemo_container\">\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"templatemo_menu\">\n");
      out.write("    <ul>\n");
      out.write("        <li><a href=\"index.jsp\" class=\"current\">Trang chủ</a></li>\n");
      out.write("        <li><a href=\"cart.jsp\">Giỏ hàng \n");
      out.write("                <b style=\"color: red\">\n");
      out.write("                    ");
 Cart cart = (Cart) session.getAttribute("CART");
                        if (cart != null) {
                            out.print(cart.getArr().size());
                        }
                    
      out.write("\n");
      out.write("                </b>\n");
      out.write("            </a>\n");
      out.write("        </li>\n");
      out.write("        ");
CustomerMember customer = (CustomerMember) session.getAttribute("USER");
            if (customer != null) {
                String username = customer.getUsername();
        
      out.write("\n");
      out.write("        <li><a href=\"#\">Xin chào ");
      out.print(username);
      out.write("</a></li>\n");
      out.write("        <li><a href=\"Logout\">Đăng xuất</a></li>\n");
      out.write("            ");
} else {
      out.write("\n");
      out.write("        <li><a href=\"login.jsp\">Đăng nhập</a></li>\n");
      out.write("        <li><a href=\"register.jsp\">Đăng ký</a></li>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("    </ul>\n");
      out.write("</div> <!-- end of menu -->");
      out.write("\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"templatemo_header\">\n");
      out.write("    <div id=\"templatemo_special_offers\">\n");
      out.write("        <p>\n");
      out.write("            <span>25%</span> được giảm cho đơn hàng quá 500VNĐ\n");
      out.write("        </p>\n");
      out.write("        <a href=\"#\" style=\"margin-left: 50px;\">Tìm hiểu thêm...</a>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("    <div id=\"templatemo_new_books\">\n");
      out.write("        <ul>\n");
      out.write("            <li>Ngôn tình</li>\n");
      out.write("            <li>Hoa vàng trên cỏ xanh</li>\n");
      out.write("            <li>Người ấy</li>\n");
      out.write("        </ul>\n");
      out.write("        <a href=\"#\" style=\"margin-left: 50px;\">Xem thêm...</a>\n");
      out.write("    </div>\n");
      out.write("</div>");
      out.write(" <!-- end of header -->\n");
      out.write("\n");
      out.write("            <div id=\"templatemo_content\">\n");
      out.write("\n");
      out.write("                <div id=\"templatemo_content_left\">\n");
      out.write("                    <div class=\"templatemo_content_left_section\">\n");
      out.write("                        <h1>Categories</h1>\n");
      out.write("                        <ul>\n");
      out.write("                            ");

                                ArrayList<Category> listCategory = null;
                                CategoryDAO categoryDAO = new CategoryDAO();
                                listCategory = categoryDAO.getCategoryHomepage();
                                for (int i = 0; i < listCategory.size(); i++) {
      out.write("  \n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">");
      out.print(listCategory.get(i).getDescription());
      out.write("</a>\n");
      out.write("                            </li>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"templatemo_content_left_section\">\n");
      out.write("                        <h1>BookSet</h1>\n");
      out.write("                        <ul>\n");
      out.write("                            ");

                                ArrayList<BookSet> listBookSet = null;
                                BookSetDAO bookSetDAO = new BookSetDAO();
                                listBookSet = bookSetDAO.getBookSetHompage();
                                for (int i = 0; i < listBookSet.size(); i++) {
      out.write("  \n");
      out.write("                            <li>\n");
      out.write("                                <a href=\"#\">");
      out.print(listBookSet.get(i).getDescription());
      out.write("</a>\n");
      out.write("                            </li>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"templatemo_content_left_section\">                \n");
      out.write("                        <a href=\"#\"><img style=\"border:0;width:88px;height:31px\" src=\"images/facebook.png\" alt=\"Valid XHTML 1.0 Transitional\" width=\"88\" height=\"31\" vspace=\"8\" border=\"0\" /></a>\n");
      out.write("                        <a href=\"#\"><img style=\"border:0;width:88px;height:31px\" src=\"images/glus.png\" alt=\"Valid XHTML 1.0 Transitional\" width=\"88\" height=\"31\" vspace=\"8\" border=\"0\" /></a>\n");
      out.write("                    </div>\n");
      out.write("                </div> <!-- end of content left -->\n");
      out.write("\n");
      out.write("                <div id=\"templatemo_content_right\">\n");
      out.write("                    <h2>Thông tin giao hàng</h2>\n");
      out.write("                            <form name=\"register\" action=\"Register\" method=\"post\">          \n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <label class=\"contact\"><strong>Fullname</strong></label>\n");
      out.write("                                    <input type=\"text\" class=\"contact_input\"  name=\"fullname\"/>\n");
      out.write("                                </div> \n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <label class=\"contact\"><strong>Num</strong></label>\n");
      out.write("                                    <input type=\"text\" class=\"contact_input\"  name=\"num\"/>\n");
      out.write("                                </div> \n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <label class=\"contact\"><strong>Ward</strong></label>\n");
      out.write("                                    <input type=\"text\" class=\"contact_input\"  name=\"ward\"/>\n");
      out.write("                                </div> \n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <label class=\"contact\"><strong>Dictric</strong></label>\n");
      out.write("                                    <input type=\"text\" class=\"contact_input\"  name=\"dictric\"/>\n");
      out.write("                                </div> \n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <label class=\"contact\"><strong>City</strong></label>\n");
      out.write("                                    <input type=\"text\" class=\"contact_input\"  name=\"city\"/>\n");
      out.write("                                </div> \n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <label class=\"contact\"><strong>Phone</strong></label>\n");
      out.write("                                    <input type=\"text\" class=\"contact_input\"  name=\"phone\"/>\n");
      out.write("                                </div> \n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <label class=\"contact\"><strong>Email</strong></label>\n");
      out.write("                                    <input type=\"email\" class=\"contact_input\"  name=\"email\"/>\n");
      out.write("                                </div> \n");
      out.write("\n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <div class=\"terms\">\n");
      out.write("                                        <input type=\"checkbox\" name=\"terms\" />\n");
      out.write("                                        Tôi xác nhận thông tin giao hàng</div>\n");
      out.write("                                </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("                                <div class=\"form_row\">\n");
      out.write("                                    <input type=\"submit\" class=\"register\" value=\"Xác nhận đặt hàng\" />\n");
      out.write("                                </div>   \n");
      out.write("                            </form>     \n");
      out.write("                </div><!-- end of content right -->\n");
      out.write("\n");
      out.write("                <div class=\"cleaner_with_height\">&nbsp;</div>\n");
      out.write("            </div> <!-- end of content -->\n");
      out.write("\n");
      out.write("            ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"templatemo_footer\">\n");
      out.write("\n");
      out.write("    <a href=\"subpage.html\">Home</a> | <a href=\"subpage.html\">Search</a> | <a href=\"subpage.html\">Books</a> | <a href=\"#\">New Releases</a> | <a href=\"#\">FAQs</a> | <a href=\"#\">Contact Us</a><br />\n");
      out.write("    Copyright © 2016 <a href=\"#\"><strong>giangnd.ptit@gmail.com</strong></a> | <a href=\"#\" target=\"_parent\" title=\"free css templates\">D12CNPM6</a>\t</div> ");
      out.write("\n");
      out.write("            <!-- end of footer -->\n");
      out.write("            <!--  Free CSS Template www.templatemo.com -->\n");
      out.write("        </div> <!-- end of container -->\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
