/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras.ControladoraMonitor;

import Modelos.CRUDEntidades.CRUDAsesoria;
import Modelos.CRUDEntidades.CRUDAsignatura;
import Modelos.Entidades.Asignatura;
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
public class controladoraGetAsesorias {
    
    private CRUDAsesoria asesorias;

    public controladoraGetAsesorias() {
        this.asesorias= new CRUDAsesoria();
    }
    
    
    @RequestMapping(value = "getAsesoriaAsignatura.htm", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request){
        String asignatura=request.getParameter("asignatura");
        List respuesta = asesorias.consultarPorAsignatura(asignatura);
        CRUDAsignatura asig= new CRUDAsignatura();
        Asignatura asigna= asig.seleccionarAsignatura(asignatura);
        ModelAndView def= new ModelAndView();
        def.setViewName("respuestaAsesoriasXAsignatura");
        def.addObject("respuestas",respuesta);
        def.addObject("asignatura",asigna);
        return def;
    }
    
    @RequestMapping(value = "getTodasAsesorias.htm", method = RequestMethod.GET)
    public ModelAndView getTodas(){
        List respuesta = asesorias.consultarTodas();
        ModelAndView def= new ModelAndView();
        def.setViewName("respuestaTodasAsesorias");
        def.addObject("respuestas",respuesta);
        return def;
    }
    
    @RequestMapping(value = "getAsesoriasEstudiante.htm", method = RequestMethod.GET)
    public ModelAndView getXEstudiante(HttpServletRequest request){
        int estudiante=Integer.parseInt(request.getParameter("codigoEstudiante"));
        List respuesta = asesorias.consultarunaEstudiante(estudiante);
        ModelAndView def= new ModelAndView();
        def.setViewName("respuestaTodasAsesorias");
        def.addObject("respuestas",respuesta);
        return def;
    }
    
}
