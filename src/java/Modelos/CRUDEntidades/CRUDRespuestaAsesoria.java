/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.CRUDEntidades;

import Conexión.conexion;
import Modelos.Entidades.RespuestaAsesoria;
import java.sql.ResultSet;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author JulianCamilo
 */
public class CRUDRespuestaAsesoria {
    
     private JdbcTemplate jdbcTemplate;
     private String sql;

    public CRUDRespuestaAsesoria() {
        conexion con = new conexion();
        this.jdbcTemplate = new JdbcTemplate (con.conectar());
        this.sql="";
    }
    
   /**
     * Método para registrar una nueva respuesta asesoria en el sistema
     * @param idAsesoria
     * @param codigoMonitor
     * @param fechaRespuesta
     * @param hora
     * @return retorna un valor entero, si es 0 es que hubo algun error
     *                                  si es 1 es que fue correcto
     */
    public int IngresarRespuestaAsesoria(int idAsesoria,int codigoMonitor, String fechaRespuesta, Time hora) {
        RespuestaAsesoria nuevaasesoria = new RespuestaAsesoria(idAsesoria,codigoMonitor, null, hora);
        this.sql = "insert into respuestaasesoria(idAsesoria,codigoMonitor,fechaRespuesta,hora) values ("
                + nuevaasesoria.getIdAsesoria()+ ","+'"' + nuevaasesoria.getCodigoMonitor()+ '"'+","+'"' + fechaRespuesta+ '"'+","+'"'+nuevaasesoria.getHora()+'"' +");";
        int resul = this.jdbcTemplate.update(sql);
        return resul;
    }

    /**
     * Método para consultar una unica respuesta de asesoria dado su identificador
     * @param idRespuesta el identificador de la respuesta en la bd
     * @return respuesta asesoria con toda la informacion registrada en el sistema
     */
    public RespuestaAsesoria consultaruna(int idRespuesta) {
        this.sql = "select * from respuestaasesoria where idRespuesta=" + idRespuesta + ";";
        return (RespuestaAsesoria) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if (rs.next()) {
                RespuestaAsesoria aux = new RespuestaAsesoria();
                aux.setIdRespuesta(rs.getInt(1));
                aux.setIdAsesoria(rs.getInt(2));
                aux.setCodigoMonitor(rs.getInt(3));
                aux.setFechaRespuesta(rs.getDate(4));
                aux.setHora(rs.getTime(5));
                return aux;
            }
            return null;
        });
    }

    /**
     * Método para consultar una unica respuesta asesoria dado su idee¿ntificador
     * @param asignatura la asignatura a la que se le desea consultar las respuestas programadas
     * @return asesoria con toda la informacion registrada en el sistema
     */
    public RespuestaAsesoria consultarUnaPorAsignatura(String asignatura) {
        this.sql = "select * from asesoria where idasesoria=" + asignatura + ";";
        return (RespuestaAsesoria) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if (rs.next()) {
                RespuestaAsesoria aux = new RespuestaAsesoria();
                aux.setIdRespuesta(rs.getInt(1));
                aux.setIdAsesoria(rs.getInt(2));
                aux.setCodigoMonitor(rs.getInt(3));
                aux.setFechaRespuesta(rs.getDate(4));
                aux.setHora(rs.getTime(5));
                return aux;
            }
            return null;
        });
    }
    
    /**
     * Método para generar un reporte con todas las respuesta deasesorias registradas en el sistema
     * @return lista con todas las respuestas asesorias registrada en el sistema
     */
    public List consultarTodas() {
        this.sql = "select * from respuestaasesoria inner join estudiante on codigoMonitor=codigo order by idRespuesta";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }
    
     /**
     * Método para generar un reporte con una respuesta que fue dada por el monitor
     * @param idAsesoria el identificador de la asesoria propia a consultar
     * @return lista con todas las respuestas asesorias registrada en el sistema
     */
    public List consultarIdConMonitor(int idAsesoria) {
        this.sql = "select * from respuestaasesoria inner join estudiante on codigoMonitor=codigo where idAsesoria="+idAsesoria+";";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }
     
    
}
