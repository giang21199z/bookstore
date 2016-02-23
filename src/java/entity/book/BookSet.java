/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.book;

/**
 *
 * @author GIANGND-SVMC
 */
public class BookSet {

    private int id;
    private String description;

    public BookSet(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public BookSet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
