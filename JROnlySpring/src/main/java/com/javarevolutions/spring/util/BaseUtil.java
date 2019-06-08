/**
 * Todos los Derechos Reservados � 2014 Java Revolutions.
 * Sistema Web construido solo con Spring.
 * Este software contiene informaci�n propiedad exclusiva de Java Revolutions considerada
 * Confidencial. Queda totalmente prohibido su uso o divulgaci�n en forma
 * parcial o total.
 *	---------------------------------------------------------------------------
 * Nombre de Aplicacion: Proyecto Web Java Revolutions Solo Spring
 * Nombre de archivo: BaseUtil.java
 * Fecha de creacion : Noviembre, 2013
 * @author : Sergio Alberto Cort�s Rios
 * @version 1.0
 *
 * Bit�cora de modificaciones:
 * CR/Defecto 		Fecha 			Autor 			Descripci�n del cambio
 *---------------------------------------------------------------------------
 */
package com.javarevolutions.spring.util;

import java.lang.reflect.Method;

public class BaseUtil {
    /**
     * Este m�todo copia todas las propiedades en cascada que sean identicas en nombre  y tipo de retorno de un bean a un entity o viceversa
     * @param to
     * @param from
     */
    public static void copyProperties(Object to, Object from) {
        Method[] metodos = from.getClass().getMethods();
        Class<?>[] types = new Class[]{};
        Object[] args = new Object[]{};
        for(Method metodo: metodos) {
            String name = metodo.getName();
            Method metodoGetTo = null;
            Method metodoSetTo = null;
            Method metodoGetFrom = null;
            Object objFrom = null;
            Object objAux = null;
            String get = null;
            if(name.startsWith("set")) {
                try {
                    get = name.replaceFirst("set", "get");
                    metodoGetTo = to.getClass().getMethod(get, types);
                    metodoSetTo = to.getClass().getMethod(name, metodoGetTo.getReturnType());
                    metodoGetFrom = from.getClass().getMethod(get, types);
                    objFrom = metodoGetFrom.invoke(from, args);
                    metodoSetTo.invoke(to, objFrom);
                } catch(NoSuchMethodException nsme) {
                } catch(IllegalArgumentException ilegal) {
                    try {
                        objAux = metodoGetTo.getReturnType().newInstance();
                        copyProperties(objAux, objFrom);
                        metodoSetTo.invoke(to, objAux);
                    } catch(Exception ex) {
                    }
                } catch(Exception e) {
                }
            }
        }
    }
}
