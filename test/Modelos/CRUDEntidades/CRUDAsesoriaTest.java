/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.CRUDEntidades;

import Modelos.Entidades.Asesoria;
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
public class CRUDAsesoriaTest {
    
    public CRUDAsesoriaTest() {
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
     * Test of IngresarAsesoria method, of class CRUDAsesoria.
     */
    @Test
    public void testIngresarAsesoria() {
        int codigoestudiante = 1701311587;
        String codigoasignatura = "G8F0059";
        String tema = "Repaso parcial";
        CRUDAsesoria testAsesoria = new CRUDAsesoria();
        int expResult = 1;
        int result = testAsesoria.IngresarAsesoria(codigoestudiante, codigoasignatura, tema);
        assertEquals(expResult, result);
    }

    /**
     * Test of IngresarAsesoria method, of class CRUDAsesoria.
     */
    @Test
    public void testIngresarAsesoriaSinTema() {
        int codigoestudiante = 1701311587;
        String codigoasignatura = "G8F0059";
        String tema = null;
        CRUDAsesoria testAsesoria = new CRUDAsesoria();
        int expResult = 0;
        int result = testAsesoria.IngresarAsesoria(codigoestudiante, codigoasignatura, tema);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of IngresarAsesoria method, of class CRUDAsesoria.
     */
    @Test
    public void testIngresarAsesoriaEstudianteNoregistrado() {
        int codigoestudiante = 80999123;
        String codigoasignatura = "G8F0059";
        String tema = "Repaso parcial";
        CRUDAsesoria testAsesoria = new CRUDAsesoria();
        int expResult = 0;
        int result = testAsesoria.IngresarAsesoria(codigoestudiante, codigoasignatura, tema);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of consultaruna method, of class CRUDAsesoria.
     */
    @Test
    public void testConsultaruna() {
        System.out.println("consultaruna");
        int idAsesoria = 0;
        CRUDAsesoria asesoriaTest = new CRUDAsesoria();
        Asesoria expResult = null;
        Asesoria result = asesoriaTest.consultaruna(idAsesoria);
        assertNotEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of consultarPorAsignatura method, of class CRUDAsesoria.
     */
    @Test
    public void testConsultarPorAsignatura() {
        System.out.println("consultarPorAsignatura");
        String asignatura = "G8F0059";
        CRUDAsesoria asesoriaTest = new CRUDAsesoria();
        List expResult = null;
        List result = asesoriaTest.consultarPorAsignatura(asignatura);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of consultarTodas method, of class CRUDAsesoria.
     */
    @Test
    public void testConsultarTodas() {
        CRUDAsesoria testAsesoria = new CRUDAsesoria();
        List expResult = null;
        List result = testAsesoria.consultarTodas();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of consultarunaEstudiante method, of class CRUDAsesoria.
     */
    @Test
    public void testConsultarunaEstudiante() {
        int codigoEstudiante = 1701310061;
        CRUDAsesoria instance = new CRUDAsesoria();
        List expResult = null;
        List result = instance.consultarunaEstudiante(codigoEstudiante);
        assertNotEquals(expResult, result);
    }
    
}
