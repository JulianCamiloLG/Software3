/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras.ControladoraMonitor;

import Modelos.Entidades.Inquietud;
import Modelos.OperacionesEstudianteMonitor.OperacionInquietud;
import Modelos.OperacionesEstudianteMonitor.OperacionResponderInquietud;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SALDARRIAGA VILLADA
 */
@Controller
public class controladoraResponderInquietudRevisar
{
    
    OperacionInquietud inquietud;
    OperacionResponderInquietud respuestaInquietud;
    
    /**
     * Metodo para rediccionar hacia la vista solicitada
     * @param request metodo de la solicitud
     * @return redireccionamiento a la vista responderInquietudRevisar
     */
    @RequestMapping(value = "responderInquietudRevisar.htm", method = RequestMethod.GET)
    public ModelAndView home(HttpServletRequest request){
        
        this.inquietud= new OperacionInquietud();
        ModelAndView mav = new ModelAndView();
        List<Inquietud> inquietudes = inquietud.consultarTodas();
        mav.setViewName("responderInquietudRevisar");
        mav.addObject("respuestas", inquietudes);
        mav.addObject("codigo",request.getParameter("codigo"));
        return mav;
    }
    
    /**
     * Metodo para rediccionar hacia la vista solicitada
     * @return redireccionamiento a la vista responderInquietud
     */
    @RequestMapping(value = "responderInquietud.htm", method = RequestMethod.GET)
    public ModelAndView home(){       
        ModelAndView mav = new ModelAndView();
        mav.setViewName("responderInquietud");
        return mav;
    }
    
    /**
     * Metodo para redireccionar a la vista solicitada
     * @param request
     * @return redireccionamiento a la vista responderInquietud
     */
    @RequestMapping(value = "responderInquietud.htm", method = RequestMethod.POST)
    public ModelAndView form(HttpServletRequest request) {
        String fecha = request.getParameter("fechaRespuesta");
        String hora = request.getParameter("horaInicioRespuesta");
        String preRespuesta=request.getParameter("preRespuesta");
        LocalDate fechaR = LocalDate.of(Integer.parseInt(fecha.substring(0, 4)), Integer.parseInt(fecha.substring(5, 7)),Integer.parseInt(fecha.substring(8, 10)));
        Date fechaRespuesta= new Date(fechaR.getYear()-1900, fechaR.getMonthValue()+1, fechaR.getDayOfMonth());
        Time horaRespuesta = new Time(Integer.parseInt(hora.substring(0, 2)), Integer.parseInt(hora.substring(3, 5)), 0);
        this.respuestaInquietud = new OperacionResponderInquietud();
        this.respuestaInquietud.guardarRespuestaInquietud(Integer.parseInt(request.getParameter("inquietud")), Integer.parseInt(request.getParameter("codigo")), fechaRespuesta, horaRespuesta,preRespuesta);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("responderInquietud");
        mav.addObject("respuesta", "Su respuesta fue publicada con exito");
        return mav;
    }
    
    
}
