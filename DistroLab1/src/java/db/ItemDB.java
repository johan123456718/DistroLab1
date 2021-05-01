/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

/**
 *
 * @author Johan C
 * @author Jesper Larsson
 * 
 * Class used to access items in database
 */
public class ItemDB extends bo.Item {

    /**
     *
     * Gets all items from database
     * 
     * @return a collection of ItemDB's
     */
    public static Collection getItems() {
        Vector v = new Vector();
        try {
            
            Connection con = DBManager.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from fruit_table");
            
            while(rs.next()){
                int i = rs.getInt("fruit_id");
                String name = rs.getString("name");
                String desc = rs.getString("description");
                v.addElement(new ItemDB(i, name, desc));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return v;
    }

    private ItemDB(int id, String name, String desc){
        super(id, name ,desc);
    }

}