import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

class DBConnect {
	public Connection conn;
	public Statement st;

	public String dbURL;
	public String username;
	public String password;

	public DBConnect(String dbURL, String username, String password) throws SQLException {
		this.dbURL = dbURL;
		this.username = username;
		this.password = password;
		//getting database connection to MySQL server
		try {
			this.conn = DriverManager.getConnection(dbURL, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class Main {
	public static final String dbName = "DB";
	public static final String username = "USERNAME";
	public static final String password = "PASSWORD";
	public static final String makeTest = "CREATE DATABASE Test;";
	public static final String useTest = "USE Test;";
	// Department ID is foreign key in Person table.
	public static final String createDepartment = "CREATE TABLE Department (ID bigint(11) PRIMARY KEY NOT NULL AUTO_INCREMENT, NAME VARCHAR(200) DEFAULT NULL);";
	public static final String createPerson = "CREATE TABLE Person (ID bigint(11) PRIMARY KEY NOT NULL AUTO_INCREMENT, Name VARCHAR(200) DEFAULT NULL, Address text DEFAULT NULL, DepartmentID bigint(11), FOREIGN KEY (DepartmentID) REFERENCES Department(ID));";
	public static final String insertDepartment = "INSERT INTO Department (Name) values (\"DeptName\");";
	public static final String deleteAllDepartment = "DELETE from Department;";
	
	public static void buildDatabase(DBConnect connect) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect.st.executeUpdate(makeTest);
			connect.st.executeQuery(useTest);
			connect.st.executeUpdate(createDepartment);
			connect.st.executeUpdate(createPerson);
		} catch(Exception ex) {
			System.out.println("Error: " + ex);
		}
	}
	// Closes the connection.
	public static void disconnectMode() throws SQLException {
		DBConnect connect = null;
		// Get connection.
		try {
			connect = new DBConnect(dbName, username, password);
			connect.st = connect.conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		buildDatabase(connect);
		connect.st.executeUpdate(insertDepartment);
		// Close the connection.
		try {
			connect.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// Does not close the connection.
	public static void connectMode(DBConnect connect) {
		buildDatabase(connect);
		try {
			connect.st.executeUpdate(insertDepartment);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		DBConnect connect = null;
		// Get connection.
		try {
			connect = new DBConnect(dbName, username, password);
			connect.st = connect.conn.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connectMode(connect);
		try {
			connect.conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}