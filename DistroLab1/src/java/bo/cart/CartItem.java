/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.cart;

import db.CartDB;
import java.util.Collection;

/**
 *
 * @author Johan Challita
 * @author Jesper Larsson
 * 
 * Class that represents a CartItem
 * 
 */
public class CartItem {
    private String itemName;
    private int quantity;
    
    /**
     * 
     * Tells DB layer to get cart items for given user 
     * 
     * @param user
     * @return Collection of cart items
     */
    public static Collection getCartItemsForUser(String user){
        return CartDB.getCartItemsForUser(user);
    }
    
    /**
     *
     * Tells DB layer to add given item to cart for given user
     * 
     * @param itemName
     * @param userName
     * @return true if success, false if it failed
     */
    public static boolean addItemToCart(String itemName, String userName){
        return CartDB.addToCart(itemName,  userName);
    }
    
    /**
     * Tells DB layer to remove given item from cart for given user
     * 
     * @param itemName
     * @param userName
     * @return true if success, false if it failed
     */
    public static boolean removeFromCart(String itemName, String userName){
        return CartDB.removeFromCart(itemName, userName);
    }
    
    /**
     *
     * @param itemName
     * @param quantity
     */
    public CartItem(String itemName, int quantity){
        this.itemName = itemName;
        this.quantity = quantity;
    }

    /**
     * @return the itemName
     */
    public String getItemName() {
        return itemName;
    }


    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

}