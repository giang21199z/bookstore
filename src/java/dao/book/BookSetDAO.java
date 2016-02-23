/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.book;

import dao.connection.ConnectionDB;
import entity.book.Book;
import entity.book.BookSet;
import entity.book.Category;
import java.sql.Connection;
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
public class BookSetDAO {

    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";

    public BookSetDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public BookSetDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public ArrayList<BookSet> getBookSetHompage() {
        ArrayList<BookSet> arr = new ArrayList<>();
        String sql = "SELECT * FROM book_set";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                String description = rs.getString("description");
                int idbookSet = rs.getInt("idbook_set");
                BookSet bookset = new BookSet(idbookSet, description);
                arr.add(bookset);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookSetDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;

    }
}
