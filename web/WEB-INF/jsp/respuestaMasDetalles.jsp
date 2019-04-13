<%-- 
    Document   : respuestaMasDetalles
    Created on : 13-abr-2019, 0:38:18
    Author     : JulianCamilo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@page contentType="text/html; charset=UTF-8"%>
<json:array>
    <c:forEach items="${respuestas}" var="respuestas">
        <json:object>
            <json:property name="idRespuesta" value="${respuestas.idRespuesta}"/>
            <json:property name="idAsesoria" value="${respuestas.idAsesoria}"/>
            <json:property name="codigoMonitor" value="${respuestas.codigoMonitor}"/>
            <json:property name="fechaRespuesta" value="${respuestas.fechaRespuesta}"/>
            <json:property name="horaRespuesta" value="${respuestas.hora}"/>
            <json:property name="codigoMonitor" value="${respuestas.codigo}"/>
            <json:property name="nombreMonitor" value="${respuestas.nombre}"/>
            <json:property name="apellidoMonitor" value="${respuestas.apellido}"/>
            <json:property name="programa" value="${respuestas.programa}"/>
            <json:property name="correo" value="${respuestas.correo}"/>
        </json:object>
    </c:forEach>
</json:array>
