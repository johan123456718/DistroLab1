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

/**
 *
 * @author Jesper Larsson
 * 
 * Class used to access users in database
 */
public class UserDB extends bo.User{

    /**
     * Checks database to find user with provided information
     * @param userName
     * @param password
     * @return the user as UserDB if found, else null
     */
    public static UserDB getUser(String userName, String password){
        try {
            Connection con = DBManager.getConnection();
            String query = "select * from user_table where name = ? and password = ?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, userName);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                return new UserDB(rs.getString("name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
    
    private UserDB(String userName){
        super(userName);
    }
}
