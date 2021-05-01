/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.cart;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import ui.CartItemInfo;

/**
 * @author Jesper Larsson
 * @author Johan Challita
 * 
 * Class that handles calls from UI layer to BO layer, related to cart items 
 */
public class CartItemHandler {
    
    /**
     * gives a information about user's cart items
     * @param user
     * @return Collection of CartItemInfo
     */
    public static Collection<CartItemInfo> getCartItemsForUser(String user) {
        Collection c = CartItem.getCartItemsForUser(user);
        ArrayList<CartItemInfo> items = new ArrayList<>();

        for (Iterator it = c.iterator(); it.hasNext();) {
            CartItem item = (CartItem) it.next();
            items.add(new CartItemInfo(item.getItemName(), item.getQuantity()));
        }
        
        return items;
    }
     
    /**
     *
     * Tells lower layer to add given item to cart for given user
     * 
     * @param itemName
     * @param userName
     * @return true if success, false if it failed
     */
    public static boolean addItemToCart(String itemName, String userName){
        return CartItem.addItemToCart(itemName,  userName);
    }
    
    /**
     *
     * Tells lower layer to remove given item to cart for given user
     * 
     * @param itemName
     * @param userName
     * @return true if success, false if it failed
     */
    public static boolean removeItemFromCart(String itemName, String userName){
        return CartItem.removeFromCart(itemName,  userName);
    }
}