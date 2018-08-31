/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladoras.ControladoraEstudiante;

import Conexión.conexion;
import Modelos.CRUDEntidades.CRUDInquietud;
import Modelos.Entidades.*;
import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author SALDARRIAGA VILLADA
 */
@Controller
public class controladoraPublicarInquietud
{
    private JdbcTemplate jdbcTemplate;
    private CRUDInquietud inquietud;
    
    
    /**
     * @return  * @ModelAttribute("inquietud")
    public Inquietud getInquietud(){
        return new Inquietud();
    }
    **/
    @RequestMapping(value = "publicarInquietud.htm", method = RequestMethod.GET)
    public ModelAndView form() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("publicarInquietud");
        mav.addObject("inquietud", new Inquietud());
        return mav;
    }
    
//    @RequestMapping(value = "publicarInquietud.htm",method = RequestMethod.GET)
//    public String addInquietud(ModelMap model){
//        model.addAttribute("inquietud", new Inquietud());
//        return "inquietud";
//    }
 
    /**
     * Metodo para crear una inquietud
     * @param inquietud
     * @param result
     * @param status
     * @return una nueva vista con la inquietud publicada
     */
   @RequestMapping(method = RequestMethod.POST)
    public ModelAndView form(HttpServletRequest request) {
       inquietud = new CRUDInquietud();
       inquietud.IngresarInquietud(1701311587, request.getParameter("inputAsignatura"), request.getParameter("inputTema"), request.getParameter("inputDescripcion"));
       ModelAndView mav = new ModelAndView();
       mav.setViewName("publicarInquietud");
       mav.addObject("inquietud", new Inquietud());
       return mav;
    }
}
