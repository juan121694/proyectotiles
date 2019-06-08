/**
 * Todos los Derechos Reservados � 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene informaci�n propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgaci�n en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: ControllerUtil.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cort�s Rios
 * @version 1.0
 *
 * Bit�cora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripci�n del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ControllerUtil {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    
    public void showError(HttpServletResponse response, String error) {
        try {
            PrintWriter pw = response.getWriter();
            pw.write("<script>");
            pw.write("alert('"+error+"');");
            pw.write("</script>");
            pw.flush();
        } catch(IOException io) {
            String msgError = "ERROR EN ControllerUtil:showError : "+io;
            log.error(msgError);
        }
    }

    public String formatFechaSQL(String fecha) {
        String[] arr = fecha.split("/");
        return arr[2]+"-"+arr[1]+"-"+arr[0];
    }

    public String formatFechaString(String fecha) {
        String[] arr = fecha.split("-");
        return arr[2]+"/"+arr[1]+"/"+arr[0];
    }
}
