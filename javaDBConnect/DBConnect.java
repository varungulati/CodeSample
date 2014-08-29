import java.sql.*;

public class DBConnect {
        public Connection conn;
        public Statement st;
        public int rs;
        public PreparedStatement prep_st;
        
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
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                }
        }
