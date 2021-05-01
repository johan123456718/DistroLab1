/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Johan Challita
 * 
 * Class used to connect to database
 */
public class DBManager {

    private static DBManager instance = null;
    private Connection con = null;

    private static DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        try {
            String database = "itemdb";
            String user = "fruituser"; // user name
            String pwd = "fruit123"; // password 
            String server
                    = "jdbc:mysql://localhost:3306/" + database
                    + "?UseClientEnc=UTF8" + "?useTimezone=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(server, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Provides the connection to the database
     * 
     * @return a Connection
     */
    public static Connection getConnection() {
        return getInstance().con;
    }
}