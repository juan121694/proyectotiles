package com.javarevolutions.spring.dao.iface;

import java.util.List;

import com.javarevolutions.spring.entity.Movimientos;

public interface MovimientosDAO {
    public boolean insertaMovimiento(Movimientos entity) throws Exception;
    public boolean borraMovimiento(Movimientos entity) throws Exception;
    public boolean actualizaMovimiento(Movimientos entity) throws Exception;
    public List<Movimientos> consultaMovimientos() throws Exception;
    public Movimientos getMovimientoPorId(Movimientos entity) throws Exception;
}
