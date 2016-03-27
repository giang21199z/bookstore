/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.person;

import dao.connection.ConnectionDB;
import entity.person.Address;
import entity.person.Fullname;
import entity.person.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class PersonDAO {

    private Connection con = null;
    private String dbUsername = "root";
    private String dbPassword = "";

    public PersonDAO() {
    }

    public PersonDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public void addPerson(Person p) {
        String sqlPerson = "INSERT INTO person(idperson, idfullname, idaddress, part) VALUES(?,?,?,?)";
        Fullname fname = p.getFullname();
        Address address = p.getAddress();
        FullnameDAO fullnameDAO = new FullnameDAO(dbUsername, dbPassword);
        fullnameDAO.addFullname(fname);
        AddressDAO addressDAO = new AddressDAO(dbUsername, dbPassword);
        addressDAO.addAddress(address);
        PreparedStatement ps;
        try {
            ps = con.prepareCall(sqlPerson);
            ps.setInt(1, p.getIdperson());
            ps.setInt(2, fname.getId());
            ps.setInt(3, address.getIdaddress());
            ps.setString(4, p.getPart());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PersonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
