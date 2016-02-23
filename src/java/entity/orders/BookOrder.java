/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.orders;

import entity.book.Book;

/**
 *
 * @author GIANGND-SVMC
 */
public class BookOrder {

    private int idbook_order;
    private int quantity;
    private float totalPrice;
    private Book book;
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public BookOrder(int idbook_order, int quantity, float totalPrice, Book book, Cart cart) {
        this.idbook_order = idbook_order;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.book = book;
        this.cart = cart;
    }

    public BookOrder(int idbook_order, int quantity, int totalPrice, Book book) {
        this.idbook_order = idbook_order;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.book = book;
    }

    public BookOrder() {
    }

    public int getIdbook_order() {
        return idbook_order;
    }

    public void setIdbook_order(int idbook_order) {
        this.idbook_order = idbook_order;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

}
