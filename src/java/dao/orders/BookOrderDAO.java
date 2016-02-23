/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.orders;

import dao.connection.ConnectionDB;
import entity.orders.BookOrder;
import entity.orders.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class BookOrderDAO {

    private Connection con = null;
    private String dbUsername = "root";
    private String dbPassword = "";

    public BookOrderDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public BookOrderDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public void addBookOrder(BookOrder bookOrder) {
        String sql = "INSERT INTO book_order (idbook_order,quantity,idbook,idcart) VALUES (?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, bookOrder.getIdbook_order());
            ps.setInt(2, bookOrder.getQuantity());
            ps.setInt(3, bookOrder.getBook().getId());
            ps.setInt(4, bookOrder.getCart().getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(BookOrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
