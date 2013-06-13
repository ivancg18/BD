package org.ivan;

/**
 * Hello world!
 *
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class App 
{
    public static void main() throws ClassNotFoundException, SQLException
    {
       
        Class.forName("org.sqlite.JDBC"); // cargar el driver
        Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/ivan/SQLITE/prueba.db");
        Statement stat = conn.createStatement();
        //stat.executeUpdate("CREATE TABLE telefonos(NOMBRE TEXT, EDAD INT, PRIMARY KEY (NOMBRE));");
	//	stat.executeUpdate("INSERT INTO contactos VALUES('Pepsi', 'Cola', 155);");
        stat.executeUpdate("DELETE FROM contactos WHERE NOMBRE='Antonio';");
        stat.executeUpdate("DELETE FROM contactos WHERE NOMBRE='Pepsi';");
        stat.executeUpdate("DROP TABLE IF EXISTS telefonos;");
                
                Statement consulta = conn.createStatement ();
		ResultSet res = consulta.executeQuery ("SELECT * FROM contactos");


			while (res.next()) {
				System.out.println (res.getString(1) + " " + res.getString(2));
			}
			res.close();
			consulta.close();
        
        
        
    }
}
