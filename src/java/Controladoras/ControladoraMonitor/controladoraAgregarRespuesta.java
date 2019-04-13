/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras.ControladoraMonitor;

import Modelos.CRUDEntidades.CRUDRespuestaAsesoria;
import Modelos.Entidades.RespuestaAsesoria;
import java.sql.Time;
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
public class controladoraAgregarRespuesta {
    
    private CRUDRespuestaAsesoria respuestaAsesorias;

    public controladoraAgregarRespuesta() {
        this.respuestaAsesorias= new CRUDRespuestaAsesoria();
    }
    
    @RequestMapping(value = "agregarRespuesta.htm", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request) {
        
        int idInquietud = Integer.parseInt(request.getParameter("idAsesoria"));
        int codigoEstudiante = Integer.parseInt(request.getParameter("codigoMonitor"));
        //String asignatura = request.getParameter("asignatura");
        String fecha = request.getParameter("fecha");
        String hora = request.getParameter("hora");
        Time horaRespuesta = new Time(Integer.parseInt(hora.substring(0, 2)), Integer.parseInt(hora.substring(3, 5)), 0);
        int respuesta = respuestaAsesorias.IngresarRespuestaAsesoria(idInquietud, codigoEstudiante, fecha, horaRespuesta);
        ModelAndView def= new ModelAndView();
        def.setViewName("respuestaResponderAsesoria");
        def.addObject("respuestas",respuesta);
       
        return def;
    }
    
    @RequestMapping(value = "getDetallesAsesoria.htm", method = RequestMethod.GET)
    public ModelAndView getMasDetalles(HttpServletRequest request){
        int idAsesoria=Integer.parseInt(request.getParameter("idAsesoria"));
        List respuesta=respuestaAsesorias.consultarIdConMonitor(idAsesoria);
        ModelAndView def= new ModelAndView();
        def.setViewName("respuestaMasDetalles");
        def.addObject("respuestas",respuesta);
       
        return def;
    }
    
    @RequestMapping(value = "getRespuestaAsesoria.htm", method = RequestMethod.GET)
    public RespuestaAsesoria getRespuestaId(HttpServletRequest request) {
        int idRespuesta = Integer.parseInt(request.getParameter("idAsesoria"));
        RespuestaAsesoria respuesta = respuestaAsesorias.consultaruna(idRespuesta);
        return respuesta;
    }

    @RequestMapping(value = "getRespuestaAsignatura.htm", method = RequestMethod.GET,headers="Accept=application/json")
    public RespuestaAsesoria getRespuestaAsignatura(HttpServletRequest request) {
        String asignatura = request.getParameter("asignatura");
        RespuestaAsesoria respuesta = respuestaAsesorias.consultarUnaPorAsignatura(asignatura);
        return respuesta;
    }

    @RequestMapping(value = "getTodasRespuestas.htm", method = RequestMethod.GET,headers="Accept=application/json")
    public List getTodas() {
        List respuest = respuestaAsesorias.consultarTodas();
        return respuest;
    }
    
}
