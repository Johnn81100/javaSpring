package com.carnetAdresse.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnexion {

        //Attribut paramètre BDD
        static final String DB_URL =
                "jdbc:mysql://109.106.246.101/u444410201_java2?serverTimezone=UTC";
        static final String USERNAME = "u444410201_java2";
        static final String PASSWORD = "RD1&KsLp4xE1";
        //Connexion à la BDD
        private static Connection connexion;
        static {
            try {
                connexion = DriverManager.getConnection(DB_URL, USERNAME,
                        PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        static Connection getConnexion(){
            return connexion;
        }

}
