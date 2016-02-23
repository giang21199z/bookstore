/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.shipping;

import entity.person.Address;
import entity.person.Customer;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author GIANGND-SVMC
 */
public class ShippingInfor {

    private int id;
    private Customer customer;
    private Address addressShipping;

    public ShippingInfor() {
    }

    public ShippingInfor(int id, Customer customer, Address addressShipping) {
        this.id = id;
        this.customer = customer;
        this.addressShipping = addressShipping;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Address getAddressShipping() {
        return addressShipping;
    }

    public void setAddress(Address addressShipping) {
        this.addressShipping = addressShipping;
    }

}
