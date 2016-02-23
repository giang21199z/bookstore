/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.payment;

import dao.connection.ConnectionDB;
import entity.orders.Payment;
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
public class PaymentDAO {

    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";

    public PaymentDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public PaymentDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }
public void addPayment(Payment payment) {
        String sqlPerson = "INSERT INTO payment(idpayment, idbank, idcart, type) VALUES(?,?,?,?)";
        PreparedStatement ps;
        try {
            ps = con.prepareCall(sqlPerson);
            ps.setInt(1, payment.getId());
            ps.setInt(2, payment.getBank().getIdbank());
            ps.setInt(3, payment.getCart().getId());
            ps.setInt(4, payment.getType());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
