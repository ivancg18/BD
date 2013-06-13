/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ivan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */



public class RecordatorioBD implements RecordatorioInterfaz{

    
    private Statement stat;
    private Connection conn;
    private String Motivo;
    
    public RecordatorioBD() throws ClassNotFoundException{
         Class.forName("org.sqlite.JDBC"); // cargar el driver
    }
    
    
    public void abrirconexion(String nom_fichero){
            
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+nom_fichero);
        } catch (SQLException ex) {
            System.out.println("conn ha lanzado excepcion"+ex);
        }
        try {
            stat = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("stat ha lanzado excepcion"+ex);
        }
        
    }

  
    public void insertar(String momento, String hora, String Asunto){
        try {
            stat.executeUpdate("INSERT INTO Recordatorio VALUES("+momento+","+hora+","+Asunto+")");
        } catch (SQLException ex) {
            System.out.println("Insertar ha lanzado excepcion"+ex);
        }
    }

    public ArrayList<String> getCitasDelDia(String Dia) {
      
        ArrayList Citas = new ArrayList();
        try {
                Statement consulta = conn.createStatement ();
		ResultSet res = consulta.executeQuery ("select * from Recordatorio where Fecha="+Dia+";");
                
                while (res.next()) {
				Citas.add(res.getString(1) + "||" + res.getString(2)+ "||" + res.getString(3));
			}
                
                        res.close();
			consulta.close();
                        
        } catch (SQLException ex) {
            System.out.println("GetCitas ha lanzado excepcion "+ex);
        }
                
        return Citas;
    }

    public String getAsunto(String Fecha, String Hora) {
        try {
            
            
            Statement consulta = conn.createStatement ();
            ResultSet res = consulta.executeQuery ("select * from Recordatorio where Fecha="+Fecha+" and Hora="+Hora+";");
            
            while (res.next()) {
				Motivo=(res.getString(3));
			}
                
                        res.close();
			consulta.close();
            
            
        } catch (SQLException ex) {
            System.out.println("GetAsunto ha cascado, motivo: "+ ex);
        }
    return Motivo;
    }

    public void borrarCita(String Fecha, String Hora) {
        try {
            stat.executeUpdate("delete from Recordatorio where Fecha="+Fecha+"and Hora="+Hora+";");
        } catch (SQLException ex) {
           System.out.println("Borrar cita ha cascado, motivo: "+ ex);
        }
    }
    
}
