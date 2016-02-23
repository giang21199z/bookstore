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
public class Person implements Serializable {

    private int idperson;
    private Fullname fullname;
    private Address address;
    private String part;

    public Person(int idperson, Fullname fullname, Address address, String part) {
        this.idperson = idperson;
        this.fullname = fullname;
        this.address = address;
        this.part = part;
    }

    public Person() {
    }

    public int getIdperson() {
        return idperson;
    }

    public void setIdperson(int idperson) {
        this.idperson = idperson;
    }

    public Fullname getFullname() {
        return fullname;
    }

    public void setFullname(Fullname fullname) {
        this.fullname = fullname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }

}
