<%-- 
    Document   : respuestaTodasAsesorias
    Created on : 08-abr-2019, 0:22:02
    Author     : JulianCamilo
--%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%@page contentType="text/html; charset=UTF-8"%>

<json:array>
    <c:forEach items="${respuestas}" var="respuestas">
        <json:object>
            <json:property name="idasesoria" value="${respuestas.idasesoria}"/>
            <json:property name="codigoAsignatura" value="${respuestas.codigoAsignatura}"/>
            <json:property name="nombreAsignatura" value="${respuestas.nombre}"/>
            <json:property name="tema" value="${respuestas.tema}"/>
            <json:property name="fechaPublicacion" value="${respuestas.fechaPublicacion}"/>
            <json:property name="estudiante" value="${respuestas.codigoEstudiante}"/>
        </json:object>
    </c:forEach>
</json:array>
