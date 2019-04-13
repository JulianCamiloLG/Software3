/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras.ControladoraEstudiante;

import Modelos.CRUDEntidades.CRUDAsesoria;
import Modelos.Entidades.Asesoria;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author JulianCamilo
 */
@Controller
public class controladoraSolicitarAsesoria {
    
    private CRUDAsesoria asesorias;

    public controladoraSolicitarAsesoria() {
        this.asesorias=new CRUDAsesoria();
    }
    
    @RequestMapping(value = "getAsesoriaJSP.htm", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request){
        System.out.println("Puerto remoto:"+request.getRemotePort());
        System.out.println("Puerto del servidor:"+request.getLocalPort());
        int codigoEstudiante=Integer.parseInt(request.getParameter("codigoEstudiante"));
        String asignatura=request.getParameter("asignatura");
        String tema=request.getParameter("tema");
        int respuesta = asesorias.IngresarAsesoria(codigoEstudiante, asignatura, tema);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("respuestaAgregarAsesoria");
        mav.addObject("respuestas",respuesta);
        return mav;
    }
    
    @RequestMapping(value = "getAsesoria.htm", method = RequestMethod.GET)
    public ModelAndView getRespuesta(HttpServletRequest request){
        int idAsesoria=Integer.parseInt(request.getParameter("idAsesoria"));
        Asesoria respuesta = asesorias.consultaruna(idAsesoria);
        ModelAndView def= new ModelAndView();
        def.setViewName("respuestaAsesoria");
        def.addObject("respuesta",respuesta);
        return def;
    }
    
    @RequestMapping(value = "getAsesoriaEstudiante.htm", method = RequestMethod.GET)
    public ModelAndView getAsesoriasEstudiante(HttpServletRequest request){
        int codigoEstudiante=Integer.parseInt(request.getParameter("codigoEstudiante"));
        List respuesta = asesorias.consultarunaEstudiante(codigoEstudiante);
        ModelAndView def= new ModelAndView();
        def.addObject("respuesta",respuesta);
        def.setViewName("respuesta");
        return def;
    }
    
    @RequestMapping(value = "getTodasAsesorias.htm", method = RequestMethod.GET,headers="Accept=application/json")
    public ModelAndView getTodas(){
        List respuest=asesorias.consultarTodas();
        System.out.println(respuest.toString());
        ModelAndView mav = new ModelAndView();
        mav.setViewName("respuesta");
        return mav;
    }
    
    @RequestMapping(value = "agregarAsesoria.htm", method = RequestMethod.GET,headers="Accept=application/json")
    public int agregarAsesoria(HttpServletRequest request){
        int codigoEstudiante=Integer.parseInt(request.getParameter("codigoEstudiante"));
        String asignatura=request.getParameter("asignatura");
        String tema=request.getParameter("tema");
        int respuesta = asesorias.IngresarAsesoria(codigoEstudiante, asignatura, tema);
        return respuesta;
    }
    
}
