/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.orders;

import java.util.ArrayList;

/**
 *
 * @author GIANGND-SVMC
 */
public class Cart {

    private int id;
    private ArrayList<BookOrder> arr = new ArrayList<>();
    private float totalPrice = 0;

    public Cart() {
    }

    public Cart(int id, ArrayList<BookOrder> arr, float totalPrice) {
        this.id = id;
        this.arr = arr;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<BookOrder> getArr() {
        return arr;
    }

    public void setArr(ArrayList<BookOrder> arr) {
        this.arr = arr;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

}
