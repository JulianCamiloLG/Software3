/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.CRUDEntidades;

import Modelos.Entidades.RespuestaAsesoria;
import java.sql.Time;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JulianCamilo
 */
public class CRUDRespuestaAsesoriaTest {
    
    public CRUDRespuestaAsesoriaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of IngresarRespuestaAsesoria method, of class CRUDRespuestaAsesoria.
     */
    @Test
    public void testIngresarRespuestaAsesoria() {
        System.out.println("IngresarRespuestaAsesoria");
        int idAsesoria = 2;
        int codigoMonitor = 1701310061;
        String fechaRespuesta = "2019-07-12";
        String hora="20:50";
        Time horaF = new Time(Integer.parseInt(hora.substring(0, 2)), Integer.parseInt(hora.substring(3, 5)), 0);
        CRUDRespuestaAsesoria respuestaTest = new CRUDRespuestaAsesoria();
        int expResult = 1;
        int result = respuestaTest.IngresarRespuestaAsesoria(idAsesoria, codigoMonitor, fechaRespuesta, horaF);
        assertEquals(expResult, result);
    }

    /**
     * Test of IngresarRespuestaAsesoria method, of class CRUDRespuestaAsesoria.
     */
    @Test
    public void testIngresarRespuestaAsesoriaSinFecha() {
        System.out.println("IngresarRespuestaAsesoria");
        int idAsesoria = 2;
        int codigoMonitor = 1701310061;
        String fechaRespuesta = "";
        String hora="20:50";
        Time horaF = new Time(Integer.parseInt(hora.substring(0, 2)), Integer.parseInt(hora.substring(3, 5)), 0);
        CRUDRespuestaAsesoria respuestaTest = new CRUDRespuestaAsesoria();
        int expResult = 0;
        int result = respuestaTest.IngresarRespuestaAsesoria(idAsesoria, codigoMonitor, fechaRespuesta, horaF);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testIngresarRespuestaAsesoriaAsesoriaInexistente() {
        System.out.println("IngresarRespuestaAsesoria");
        int idAsesoria = 100;
        int codigoMonitor = 1701310061;
        String fechaRespuesta = "2019-06-15";
        String hora="20:50";
        Time horaF = new Time(Integer.parseInt(hora.substring(0, 2)), Integer.parseInt(hora.substring(3, 5)), 0);
        CRUDRespuestaAsesoria respuestaTest = new CRUDRespuestaAsesoria();
        int expResult = 0;
        int result = respuestaTest.IngresarRespuestaAsesoria(idAsesoria, codigoMonitor, fechaRespuesta, horaF);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of consultaruna method, of class CRUDRespuestaAsesoria.
     */
    @Test
    public void testConsultaruna() {
        int idRespuesta = 1;
        CRUDRespuestaAsesoria instance = new CRUDRespuestaAsesoria();
        RespuestaAsesoria expResult = null;
        RespuestaAsesoria result = instance.consultaruna(idRespuesta);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of consultarUnaPorAsignatura method, of class CRUDRespuestaAsesoria.
     */
    @Test
    public void testConsultarUnaPorAsignatura() {
        String asignatura = "G8F0059";
        CRUDRespuestaAsesoria instance = new CRUDRespuestaAsesoria();
        RespuestaAsesoria expResult = null;
        RespuestaAsesoria result = instance.consultarUnaPorAsignatura(asignatura);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of consultarTodas method, of class CRUDRespuestaAsesoria.
     */
    @Test
    public void testConsultarTodas() {
        CRUDRespuestaAsesoria instance = new CRUDRespuestaAsesoria();
        List expResult = null;
        List result = instance.consultarTodas();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of consultarIdConMonitor method, of class CRUDRespuestaAsesoria.
     */
    @Test
    public void testConsultarIdConMonitor() {
        int idAsesoria = 3;
        CRUDRespuestaAsesoria instance = new CRUDRespuestaAsesoria();
        List expResult = null;
        List result = instance.consultarIdConMonitor(idAsesoria);
        assertEquals(expResult, result);
    }
    
}
