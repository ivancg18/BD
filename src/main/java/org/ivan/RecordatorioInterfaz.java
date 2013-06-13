/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ivan;

import java.util.ArrayList;

/**
 *
 * @author ivan
 */
interface RecordatorioInterfaz {
    
  void insertar(String fecha, String Asunto, String Hora);
  
  ArrayList<String> getCitasDelDia(String momento);
  
  String getAsunto(String Fecha, String Hora);
  
  void borrarCita(String Fecha, String Hora);
  
    
}
