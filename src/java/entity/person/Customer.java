/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.person;

import java.io.Serializable;

/**
 *
 * @author GIANGND-SVMC
 */
public class Customer extends Person implements Serializable{

    private String phone;
    private String email;

    public Customer(String phone, String email, int idperson, Fullname fullname, Address address, String part) {
        super(idperson, fullname, address, part);
        this.phone = phone;
        this.email = email;
    }

    public Customer(String phone, String email) {
        this.phone = phone;
        this.email = email;
    }

    public Customer() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
