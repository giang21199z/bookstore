/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.orders;

import dao.connection.ConnectionDB;
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
public class CartDAO {

    private Connection con = null;
    private String dbUsername = "root";
    private String dbPassword = "";

    public CartDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public CartDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public void createCart(Cart cart) {
        String sqlPerson = "INSERT INTO cart (idcart) VALUES (?);";
        try {
            PreparedStatement ps = con.prepareStatement(sqlPerson);
            ps.setInt(1, cart.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
