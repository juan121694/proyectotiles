/**
 * Todos los Derechos Reservados � 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene informaci�n propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgaci�n en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: PersistenceDAO.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cort�s Rios
 * @version 1.0
 *
 * Bit�cora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripci�n del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public abstract class PersistenceDAO extends JdbcDaoSupport {
    private String esquema;

    /**
     * Este m�todo obtiene el esquema de la base de datos
     * @return esquema
     */
    public String getEsquema() {
        return esquema;
    }
    /**
     * Este m�todo establece el esquema de la base de datos
     * @param esquema
     */
    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }
    @Transactional
    public abstract boolean agregar(Object obj) throws Exception;
    @Transactional
    public abstract boolean borrar(Object obj) throws Exception;
    @Transactional
    public abstract boolean actualizar(Object obj) throws Exception;
    public abstract List<?> obtenerLista() throws Exception;
    public abstract Object obtenerObjetoPorId(Object obj) throws Exception;
}
