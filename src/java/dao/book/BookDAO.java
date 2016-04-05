/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.book;

import dao.connection.ConnectionDB;
import entity.book.Book;
import entity.book.BookDirector;
import entity.book.BookSet;
import entity.book.Category;
import entity.book.USBookBuilder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class BookDAO {

    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";

    public BookDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public BookDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public ArrayList<Book> getBookHomepage() {
        ArrayList<Book> arr = new ArrayList<>();
        String sql = "SELECT b.*,c.type,c.area,c.description as cdescription,bs.description as bsdescription "
                + "FROM book as b "
                + "JOIN category as c ON b.idcategory = c.idcategory "
                + "JOIN book_set as bs ON b.idbookset = bs.idbook_set ";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("idbook");
                String image = rs.getString("image");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String publishYear = rs.getDate("publisherYear").toString();
                String description = rs.getString("description");
                float originalPrice = rs.getFloat("originalPrice");
                float salePrice = rs.getFloat("salePrice");
                int quantity = rs.getInt("quantity");
                int idcategory = rs.getInt("idcategory");
                int idbookSet = rs.getInt("idbookset");
                int type = rs.getInt("type");
                String area = rs.getString("area");
                String cdescription = rs.getString("cdescription");
                String bsdescription = rs.getString("bsdescription");
                Category category = new Category(idcategory, type, area, cdescription);
                BookSet bookset = new BookSet(idbookSet, bsdescription);
                BookDirector bd = new BookDirector();
                USBookBuilder ussb = new USBookBuilder();
                bd.contructor(ussb, id, image, title, author, publisher, publishYear, description, originalPrice, salePrice, quantity, category, bookset);
                Book book = ussb.getBook();
                arr.add(book);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public Book getBookById(int id) {
        Book book = new Book();
        String sql = "SELECT b.*,c.type,c.area,c.description as cdescription,bs.description as bsdescription "
                + "FROM book as b "
                + "JOIN category as c ON b.idcategory = c.idcategory "
                + "JOIN book_set as bs ON b.idbookset = bs.idbook_set "
                + " WHERE b.idbook = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String image = rs.getString("image");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String publishYear = rs.getDate("publisherYear").toString();
                String description = rs.getString("description");
                float originalPrice = rs.getFloat("originalPrice");
                float salePrice = rs.getFloat("salePrice");
                int quantity = rs.getInt("quantity");
                int idcategory = rs.getInt("idcategory");
                int idbookSet = rs.getInt("idbookset");
                int type = rs.getInt("type");
                String area = rs.getString("area");
                String cdescription = rs.getString("cdescription");
                String bsdescription = rs.getString("bsdescription");
                Category category = new Category(idcategory, type, area, cdescription);
                BookSet bookset = new BookSet(idbookSet, bsdescription);
                book = new Book(id, image, title, author, publisher, publishYear, description, originalPrice, salePrice, quantity, category, bookset);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }
}
