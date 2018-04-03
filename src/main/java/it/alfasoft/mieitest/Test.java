package it.alfasoft.mieitest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {

	public Test() {
		// TODO Auto-generated constructor stub
	}

    public static void main(String[] args) {
        System.out.println("---JDBC ORACLE---");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Impossibile trovare il driver JDBC?");
            return;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:XE", "DARIO_DB", "dario");
        } catch (SQLException e) {
            System.out.println("Connessione fallita!");
            return;
        }
        if (connection != null) {
            System.out.println("Connessione avvenuta con successo!");
        } else {
            System.out.println("Connessione fallita!");
        }
    }

}
