/**
 * Todos los Derechos Reservados � 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene informaci�n propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgaci�n en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: ClientesService.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cort�s Rios
 * @version 1.0
 *
 * Bit�cora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripci�n del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.service.iface;

import java.util.List;

import com.javarevolutions.spring.dominio.ClientesBean;

public interface ClientesService {
    public boolean insertaCliente(ClientesBean obj) throws Exception;
    public boolean borraCliente(ClientesBean obj) throws Exception;
    public boolean actualizaCliente(ClientesBean obj) throws Exception;
    public List<ClientesBean> consultaClientes() throws Exception;
    public ClientesBean getClientePorId(ClientesBean obj) throws Exception;
}
