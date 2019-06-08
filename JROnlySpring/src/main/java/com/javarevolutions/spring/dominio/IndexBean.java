/**
 * Todos los Derechos Reservados � 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene informaci�n propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgaci�n en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: IndexBean.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cort�s Rios
 * @version 1.0
 *
 * Bit�cora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripci�n del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.dominio;

public class IndexBean extends GenericoBean {
    private static final long serialVersionUID = -7949085843200863279L;
    private String usuario;
    private String password;
    /**
     * M�todo para obtener el usuario
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * M�todo para establecer el usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * M�todo para establecer el password
     * @return usuario
     */
    public String getPassword() {
        return password;
    }
    /**
     * M�todo para obtener el usuario
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
