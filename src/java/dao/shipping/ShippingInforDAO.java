/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.shipping;

import dao.person.*;
import dao.connection.ConnectionDB;
import entity.person.Customer;
import entity.person.Person;
import entity.shipping.ShippingInfor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class ShippingInforDAO {

    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";

    public ShippingInforDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public ShippingInforDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public void addShippingInfor(ShippingInfor shippingInfor) {
        String sql = "INSERT INTO shipping_infor VALUES(?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, shippingInfor.getId());
            ps.setInt(2, shippingInfor.getAddressShipping().getIdaddress());
            ps.setInt(3, shippingInfor.getCustomer().getIdperson());
            System.out.println("Truy van Shipping add"+ps.toString());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ShippingInforDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
