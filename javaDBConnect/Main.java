import java.sql.*;
import java.util.Objects;
public class Main {
	  public static final String dbName = "jdbc:mysql://128.2.177.192:3306/TJ_raw";
	  public static final String username = "root";
	  public static final String password = "autonroot";


	public static void main(String[] args) {
        DBConnect connect = null;
        int last_id;
        // Get connection.
        try {
                connect = new DBConnect(dbName, username, password);
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        String insert = "INSERT INTO raw_ads (DateText, AdTitle, AdText, LocationText, PosterID, City, State, URL, RawHTML, Timestamp) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
                Class.forName("com.mysql.jdbc.Driver");
                //getting PreparedStatment to execute query
                //            connect.st = connect.conn.prepareStatement(insert);
                connect.prep_st = connect.conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
                connect.prep_st.setString(1, "21041212121212");
                connect.prep_st.setString(2, "TEST");
                connect.prep_st.setString(3, "TEST");
                connect.prep_st.setString(4, "TEST");
                connect.prep_st.setString(5, "TEST");
                connect.prep_st.setString(6, "TEST");
                connect.prep_st.setString(7, "TEST");
                connect.prep_st.setString(8, "TEST");
                connect.prep_st.setString(9, "TEST");
                connect.prep_st.setString(10, "20111212121212");
                //Resultset returned by query
                connect.prep_st.executeUpdate();
                ResultSet rs = connect.prep_st.getGeneratedKeys();
                if (rs != null && rs.next()) {
                    long key = rs.getLong(1);
                    System.out.println(key );
                }
        } catch(Exception ex) {
            System.out.println("Error: " + ex);
    } finally {
            try {
                    connect.conn.close();
                    connect.prep_st.close();
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
    }
        long a = 11111L;
        System.out.println(Objects.toString(a, null));
	}
}
