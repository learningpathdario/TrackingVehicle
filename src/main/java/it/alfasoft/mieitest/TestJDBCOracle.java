package it.alfasoft.mieitest;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

/**
 * Classe di Test connessione JDBC verso un data base Oracle
 * utilizzando il driver JDBC Thin.
 *
 */
public class TestJDBCOracle {
  public static void main(String[] args) throws Exception {
    Connection conn = getORASqlConnection();
    System.out.println("Got Connection.");

    DatabaseMetaData meta = conn.getMetaData();
    try {
      int jdbcMajorVersion = meta.getJDBCMajorVersion();
      System.out.println("jdbcMajorVersion:" + jdbcMajorVersion);
    } catch (Exception e) {
      System.out.println("jdbcMajorVersion unsupported feature");
    }

    try {
      int jdbcMinorVersion = meta.getJDBCMinorVersion();
      System.out.println("jdbcMinorVersion:" + jdbcMinorVersion);
    } catch (Exception e) {
      System.out.println("jdbcMinorVersion unsupported feature");
    }

    String driverName = meta.getDriverName();
    String driverVersion = meta.getDriverVersion();
    String databaseProductVersion = meta.getDatabaseProductVersion();
    System.out.println("driverName=" + driverName);
    System.out.println("driverVersion=" + driverVersion);
    System.out.println("databaseProductName=" + databaseProductVersion);

    conn.close();
  }

  public static Connection getORASqlConnection() throws Exception {
    String driver = "oracle.jdbc.OracleDriver";
    String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
    String username = "DARIO_DB";
    String password = "dario";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    return conn;
  }
}