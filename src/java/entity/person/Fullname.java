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
public class Fullname {

    private int id;
    private String fname;
    private String mname;
    private String lname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Fullname(int id, String fname, String mname, String lname) {
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
    }

    public String getFullname() {
        return fname + " " + mname + " " + lname;
    }
}
