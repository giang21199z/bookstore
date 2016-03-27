/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.person;

import dao.connection.ConnectionDB;
import entity.person.Customer;
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
public class CustomerDAO {
    
    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";

    public Connection getCon() {
        return con;
    }
    
    public CustomerDAO() {
        
    }
    
    public CustomerDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }
    
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO customer(idperson,phone,email) VALUES (?,?,?)";
        PersonDAO pdao = new PersonDAO(dbUsername, dbPassword);
        Person p = (Person) customer;
        pdao.addPerson(p);
        PreparedStatement ps;
        try {
            ps = con.prepareCall(sql);
            ps.setInt(1, p.getIdperson());
            ps.setString(2, customer.getPhone());
            ps.setString(3, customer.getEmail());
            
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
