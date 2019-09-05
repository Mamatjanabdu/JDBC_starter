import utils.ConfigurationReader;

import java.sql.*;

public class JDBC_PreparedStatment {

    String connection_str = ConfigurationReader.getProperty("oracledb.url");
    String db_user = ConfigurationReader.getProperty("oracledb.user");
    String db_password = ConfigurationReader.getProperty("oracledb.password");
​
        ​
        try {
​
        Connection conn = DriverManager.getConnection(connection_str, db_user, db_password);
        //Statement stmt = conn.createStatement();
//            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE
//                    , ResultSet.CONCUR_UPDATABLE);
​
        String sql = "SELECT * FROM COUNTRIES WHERE COUNTRY_ID = ? " ;
        PreparedStatement stmt = conn.prepareStatement(sql , ResultSet.TYPE_SCROLL_INSENSITIVE
                , ResultSet.CONCUR_UPDATABLE);
        stmt.setString(1,"US");
​

        ResultSet rs = stmt.executeQuery();
​
        rs.next();
        System.out.println(rs.getObject("COUNTRY_ID")
                + " "+ rs.getObject("COUNTRY_Name")
                + " "+ rs.getObject("REGION_ID") );
        rs.close();
        stmt.close();
        conn.close();
​
​
    }catch (Exception e){
        System.out.println("error occured");
    }
​
        ​
        ​
}
​
        }