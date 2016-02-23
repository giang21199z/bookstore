/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.person;

import dao.connection.ConnectionDB;
import entity.person.Address;
import entity.person.Fullname;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class AddressDAO {

    Connection con = null;

    public AddressDAO() {
    }

    public AddressDAO(String dbusername, String dbpassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbusername, dbpassword);
    }

    public void addAddress(Address address) {
        String sqlAddress = "INSERT INTO address(idaddress,num,ward,dictric,city) VALUES (?,?,?,?,?)";
        try {
            PreparedStatement ps = con.prepareStatement(sqlAddress);
            ps.setInt(1, address.getIdaddress());
            ps.setString(2, address.getNum());
            ps.setString(3, address.getWard());
            ps.setString(4, address.getDictric());
            ps.setString(5, address.getCity());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(FullnameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
