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
public class CategoryDAO {

    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";

    public CategoryDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public CategoryDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public ArrayList<Category> getCategoryHomepage() {
        ArrayList<Category> arr = new ArrayList<>();
        String sql = "SELECT * FROM category";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int idcategory = rs.getInt("idcategory");
                int type = rs.getInt("type");
                String area = rs.getString("area");
                String description = rs.getString("description");
                Category category = new Category(idcategory, type, area, description);
                arr.add(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;

    }
}
