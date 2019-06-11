
package com.javarevolutions.spring.dao.iface;

import java.util.List;

import com.javarevolutions.spring.entity.Inversiones;

public interface InversionesDAO {
    public boolean insertaInversion(Inversiones entity) throws Exception;
    public boolean borraInversion(Inversiones entity) throws Exception;
    public boolean actualizaInversion(Inversiones entity) throws Exception;
    public List<Inversiones> consultaInversiones() throws Exception;
    public Inversiones getInversionPorId(Inversiones entity) throws Exception;
}