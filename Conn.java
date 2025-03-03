package Bank.Management.system;

import java.sql.*;

public class Conn {

    Connection c;
    static Statement s;
    public Conn(){

        try{

            c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem" ,"root","Rishi1108");
            s = c.createStatement();
        }catch (Exception e){
            System.out.println(e);
        }

    }
}
