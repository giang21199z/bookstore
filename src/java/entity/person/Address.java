/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.person;

/**
 *
 * @author GIANGND-SVMC
 */
public class Address {
    
    private int idaddress;
    private String num;
    private String ward;
    private String dictric;
    private String city;

    public Address() {
    }

    public int getIdaddress() {
        return idaddress;
    }

    public void setIdaddress(int idaddress) {
        this.idaddress = idaddress;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getDictric() {
        return dictric;
    }

    public void setDictric(String dictric) {
        this.dictric = dictric;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address(int idaddress, String num, String ward, String dictric, String city) {
        this.idaddress = idaddress;
        this.num = num;
        this.ward = ward;
        this.dictric = dictric;
        this.city = city;
    }
    
    
}
