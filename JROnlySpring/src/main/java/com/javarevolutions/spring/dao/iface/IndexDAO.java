/**
 * Todos los Derechos Reservados � 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene informaci�n propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgaci�n en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: IndexDAO.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cort�s Rios
 * @version 1.0
 *
 * Bit�cora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripci�n del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.dao.iface;

import java.util.List;

import com.javarevolutions.spring.entity.Index;

public interface IndexDAO {
	public boolean validaLogin(Index entity) throws Exception;
	public boolean insertaUsuario(Index entity) throws Exception;
	public boolean borraUsuario(Index entity) throws Exception;
	public boolean actualizaUsuario(Index entity) throws Exception;
	public List<Index> consultaUsuarios() throws Exception;
	public Index getUsuarioPorId(Index entity) throws Exception;
}
