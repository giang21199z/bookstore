/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.person;

import dao.bank.BankDAO;
import dao.bank.KcoinBankDAO;
import dao.connection.ConnectionDB;
import entity.bank.Bank;
import entity.bank.KcoinBank;
import entity.person.Address;
import entity.person.Customer;
import entity.person.CustomerMember;
import entity.person.Fullname;
import entity.person.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author GIANGND-SVMC
 */
public class CustomerMemberDAO {

    private Connection con = null;
    String dbUsername = "root";
    String dbPassword = "";

    public CustomerMemberDAO() {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public CustomerMemberDAO(String dbUsername, String dbPassword) {
        ConnectionDB cdb = new ConnectionDB();
        con = cdb.getConnect(dbUsername, dbPassword);
    }

    public void register(CustomerMember customerMember) {
        String sql = "INSERT INTO customer_member(idperson,username,password,idbank) VALUES (?,?,?,?)";
        CustomerDAO cdao = new CustomerDAO(dbUsername, dbPassword);
        Customer c = (Customer) customerMember;
        cdao.addCustomer(c);
        KcoinBank kb = customerMember.getCoinBank();
        System.out.println(kb.getIdbank() + kb.getBalance() + kb.getPart());
        KcoinBankDAO kbDao = new KcoinBankDAO();
        kbDao.addKcoinBank(kb);
        try {
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, customerMember.getIdperson());
            ps.setString(2, customerMember.getUsername());
            ps.setString(3, customerMember.getPassword());
            ps.setInt(4, kb.getIdbank());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean login(CustomerMember customer) {
        String sql = "SELECT * FROM customer_member WHERE username = ? AND password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customer.getUsername());
            ps.setString(2, customer.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public CustomerMember getCustomerByUsername(String username) {
        CustomerMember cm = new CustomerMember();
        String sql = "SELECT f.idfullname,f.firstname, f.midname, f. lastname, "
                + "a.idaddress, a.num, a.ward, a.dictric, a.city, "
                + "p.idperson, p.part, "
                + "c.phone, c.email, "
                + "cm.username, cm.password, cm.idbank "
                + "FROM customer_member as cm "
                + "JOIN customer as c ON cm.idperson = c.idperson "
                + "JOIN person as p on cm.idperson = p.idperson "
                + "JOIN address as a on p.idaddress = a.idaddress "
                + "JOIN fullname as f on p.idfullname = f.idfullname "
                + "WHERE cm.username = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idaddress = rs.getInt("idaddress");
                String num = rs.getString("num");
                String ward = rs.getString("ward");
                String dictric = rs.getString("dictric");
                String city = rs.getString("city");
                Address address = new Address(idaddress, num + "", ward, dictric, city);
                int idfullname = rs.getInt("idfullname");
                String firstname = rs.getString("firstname");
                String midname = rs.getString("midname");
                String lastname = rs.getString("lastname");
                Fullname fullname = new Fullname(idfullname, firstname, midname, lastname);
                int idperson = rs.getInt("idperson");
                String part = rs.getString("part");
                Person person = new Person(idperson, fullname, address, part);
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                cm.setAddress(address);
                cm.setEmail(email);
                cm.setFullname(fullname);
                cm.setIdperson(idperson);
                cm.setPart(part);
                cm.setPhone(phone);
                return cm;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerMemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cm;
    }
}
