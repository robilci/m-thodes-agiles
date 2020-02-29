/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion.finance.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author e1503742
 */
public class Database {

    private static Connection connexion = null;

    private static String host = "localhost";
    private static String port = "3307";
    private static String db_name = "gestion_finances";
    private static String user = "root";
    private static String password = "";

    public Database(String host, String port, String db_name, String user, String password) {
        this.host = host;
        this.port = port;
        this.db_name = db_name;
        this.user = user;
        this.password = password;
    }

    public static Connection getConnection() {
        if (connexion == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connexion = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + db_name, user,
                        password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return connexion;
    }
}
