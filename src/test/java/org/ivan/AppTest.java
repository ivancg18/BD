package org.ivan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws ClassNotFoundException, SQLException
    {
        assertTrue( true );
        
        RecordatorioBD dummy =new RecordatorioBD();
        
        dummy.abrirconexion("Agenda.db");
        
        //dummy.insertar("'2013-04-06'","'14:00'", "'Escrito desde el test'");//Las comas simples las incluyo aki, habra que ponerlas en la ordena inicial
        
        ArrayList Citas= new ArrayList();
        
        Citas=dummy.getCitasDelDia("'2013-04-10'");
        
        Iterator it = Citas.iterator();
        while ( it.hasNext() ) {
        Object objeto = it.next();
        System.out.println(objeto);
        }//while 
        
        //for(int i=0;i<Citas.size();i++){
        //System.out.println(Citas[i]);
        //}
        
        String Motivo=dummy.getAsunto("'2013-04-06'", "'11:00'");
        
        System.out.println(Motivo);
        
        dummy.borrarCita("'2013-04-06'", "'12:00'");
        
        
        
        
    }
}
