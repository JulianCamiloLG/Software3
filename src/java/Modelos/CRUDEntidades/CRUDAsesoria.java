/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos.CRUDEntidades;

import Conexión.conexion;
import Modelos.Entidades.Asesoria;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author JulianCamilo
 */
public class CRUDAsesoria {
    
    private conexion conectar;
    private String sql;
    private JdbcTemplate jdbcTemplate;

    public CRUDAsesoria() {
        this.conectar = new conexion();
        this.jdbcTemplate = new JdbcTemplate(conectar.conectar());
        this.sql = "";
    }
    
    /**
     * Método para registrar una nueva asesoria en el sistema
     * @param codigoestudiante Identificador del estudiante que esta realizando la asesoria
     * @param codigoasignatura Identificador de la asignatura para la cual se esta registrando la asesoria
     * @param tema Tema de asesoria registrada
     * @return retorna un valor entero, si es 0 es que hubo algun error
     *                                  si es 1 es que fue correcto
     */
    public int IngresarAsesoria(int codigoestudiante, String codigoasignatura, String tema) {
        Asesoria nuevainquietud = new Asesoria(codigoestudiante, codigoasignatura, tema);
        this.sql = "insert into asesoria(codigoEstudiante,codigoAsignatura,tema) values ("
                + nuevainquietud.getCodigoEstudiante() + ","+'"' + nuevainquietud.getCodigoAsignatura()+ '"'+","+'"' + nuevainquietud.getTema() + '"'+");";
        int resul = this.jdbcTemplate.update(sql);
        return resul;
    }

    /**
     * Método para consultar una unica asesoria dado su idee¿ntificador
     * @param idAsesoria identificador de la asesoria en la bd
     * @return asesoria con toda la informacion registrada en el sistema
     */
    public Asesoria consultaruna(int idAsesoria) {
        this.sql = "select * from asesoria where idasesoria=" + idAsesoria + ";";
        return (Asesoria) this.jdbcTemplate.query(sql, (ResultSet rs) -> {
            if (rs.next()) {
                Asesoria aux = new Asesoria();
                aux.setIdasesoria(rs.getInt(1));
                aux.setCodigoEstudiante(rs.getInt(2));
                aux.setCodigoAsignatura(rs.getString(3));
                aux.setTema(rs.getString(4));
                aux.setFechaPublicacion(rs.getDate(5));
                return aux;
            }
            return null;
        });
    }

    /**
     * Método para consultar una unica asesoria dado su idee¿ntificador
     * @param asignatura la asignatura a la que se le desea consultar las asesorias programadas
     * @return asesoria con toda la informacion registrada en el sistema
     */
    public List consultarPorAsignatura(String asignatura) {
        this.sql = "select * from asesoria inner join estudiante on codigoEstudiante=codigo where codigoAsignatura="+ asignatura+"order by idasesoria;";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }
    
    /**
     * Método para generar un reporte con todas las asesorias registradas en el sistema
     * @return lista con todas las asesorias registrada en el sistema
     */
    public List consultarTodas() {
        this.sql = "select * from asesoria inner join estudiante on codigoEstudiante=codigo order by idasesoria desc";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }

    public List consultarunaEstudiante(int codigoEstudiante) {
        this.sql = "select * from bemonitorfinal.asesoria inner join bemonitorfinal.asignatura on codigoAsignatura=codigo where codigoEstudiante="+codigoEstudiante+"  order by idasesoria;";
        List datos = this.jdbcTemplate.queryForList(sql);
        return datos;
    }
    
    
}
