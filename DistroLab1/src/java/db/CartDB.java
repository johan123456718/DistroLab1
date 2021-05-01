/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

/**
 * @author Jesper Larsson
 * @author Johan C
 * 
 * Class used to acess and manipulate cart items in database
 */
public class CartDB extends bo.cart.CartItem {
    
    /**
     *
     * gets the items in cart for a given user
     * 
     * @param user
     * @return a Collection of CartDB's
     */
    public static Collection getCartItemsForUser(String user) {
        Vector v = new Vector();
        try {
            String query = "SELECT fruit_table.name, cart_table.quantity "
                        + "FROM fruit_table "
                        + "inner join cart_table on cart_table.item_id = fruit_table.fruit_id "
                        + "where cart_table.username = ?";
            Connection con = DBManager.getConnection();
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, user);
            ResultSet rs = st.executeQuery();
            
            while(rs.next()){
                String name = rs.getString("name");
                int quantity = rs.getInt("quantity");
                v.addElement(new CartDB(name, quantity));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v;
    }
     
    /**
     *
     * adds a given item to the cart of a given user
     * 
     * @param itemName
     * @param userName
     * @return true if success, false if it failed
     */
    public static boolean addToCart(String itemName, String userName){
        Connection con = null;
        try {
            con = DBManager.getConnection();
            try{
                con.setAutoCommit(false);
                String query = "select * from fruit_table where name = ?";
                PreparedStatement st = con.prepareStatement(query);
                st.setString(1, itemName);
                ResultSet rs = st.executeQuery();
                rs.next();
                int itemId = rs.getInt("fruit_id");    
                query = "select * from cart_table where item_id = ? and username = ?";
                st = con.prepareStatement(query);
                st.setInt(1, itemId);
                st.setString(2, userName);
                rs = st.executeQuery();
                if(rs.next()){
                    query = "update cart_table set quantity = quantity + 1 where item_id = ? and username = ?";
                    st = con.prepareStatement(query);
                    st.setInt(1, itemId);
                    st.setString(2, userName);
                    st.executeUpdate();
                }
                else{
                query = "insert into cart_table (item_id, username " +
                        ")values( ?, ?)";
                st = con.prepareStatement(query);
                    st.setInt(1, itemId);
                    st.setString(2, userName);
                    st.executeUpdate();
                }
                con.commit();
                return true;
            }catch(SQLException e){
                con.rollback();
                throw e;
            }finally{
                con.setAutoCommit(true);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }

    }
    
    /**
     *
     * removes a given item from the cart of a given user
     * 
     * @param itemName
     * @param userName
     * @return true if success, false if it failed
     */
    public static boolean removeFromCart(String itemName, String userName){
        Connection con = null;
        try {
            con = DBManager.getConnection();
            try{
                con.setAutoCommit(false);
                String query = "select * from fruit_table where name = \"" + itemName + "\"";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                rs.next();
                int itemId = rs.getInt("fruit_id");  
                query = "select * from cart_table where item_id = " + itemId + " and username = \"" + userName +"\"";
                st = con.createStatement();
                rs = st.executeQuery(query);
                if(rs.next()){
                    int quantity = rs.getInt("quantity");
                    if(quantity > 1){
                        query = "update cart_table set quantity = quantity - 1 where item_id = " + itemId + " and username = \"" + userName +"\"";
                        st.executeUpdate(query);
                    }else{
                        query = "delete from cart_table where item_id = " + itemId + " and username = \"" + userName +"\"";
                        st.executeUpdate(query);
                    }
                }
                else{
                    //nothing to remove
                    return false;
                }
                con.commit();
                return true;
            }catch(SQLException e){
                con.rollback();
                throw e;
            }finally{
                con.setAutoCommit(true);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }

    }

    private CartDB(String name, int quantity){
        super(name,quantity);
    }

}