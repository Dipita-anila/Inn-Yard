
package inn.yard;

import java.sql.*;


public class connection {
    java.sql.Connection c;
    Statement s;
    
    public connection()
    {
        try {

            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            c = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=inn_yard","sa","123456");
                                  
            s = c.createStatement();
            
         
        
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}
