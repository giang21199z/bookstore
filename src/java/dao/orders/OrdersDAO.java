/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.orders;

import dao.connection.ConnectionDB;
import entity.orders.Cart;
import entity.orders.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class OrdersDAO {

    private Connection con = null;
    private String dbUsername = "root";
    private String dbPassword = "";

    public OrdersDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public OrdersDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public void addOrder(Order orders, Context context) {
        String sqlPerson = "INSERT INTO orders  VALUES (?,?,?,?,?);";
        try {
            PreparedStatement ps = con.prepareStatement(sqlPerson);
            ps.setInt(1, orders.getId());
            ps.setDate(2, orders.getDate());
            ps.setInt(3, orders.getPayment().getId());
            ps.setInt(4, orders.getShippingInfor().getId());
            ps.setString(5, context.getOrderState().toString());
            System.out.println("Truy vấn INSERT ORDER:" + ps.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrdersDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
