/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarevolutions.spring.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.javarevolutions.spring.dao.iface.MovimientosDAO;
import com.javarevolutions.spring.dominio.MovimientosBean;
import com.javarevolutions.spring.entity.Movimientos;
import com.javarevolutions.spring.service.iface.MovimientosService;
import com.javarevolutions.spring.util.BaseUtil;


public class MovimientosServiceImpl implements MovimientosService {
    @Autowired
    private MovimientosDAO movimientosDAO;

    public boolean insertaMovimiento(MovimientosBean obj) throws Exception {
        Movimientos entity = new Movimientos();
        BaseUtil.copyProperties(entity, obj);
        return movimientosDAO.insertaMovimiento(entity);
    }
    public boolean borraMovimiento(MovimientosBean obj) throws Exception {
        Movimientos entity = new Movimientos();
        BaseUtil.copyProperties(entity, obj);
        return movimientosDAO.borraMovimiento(entity);
    }
    public boolean actualizaMovimiento(MovimientosBean obj) throws Exception {
        Movimientos entity = new Movimientos();
        BaseUtil.copyProperties(entity, obj);
        return movimientosDAO.actualizaMovimiento(entity);
    }
    public List<MovimientosBean> consultaMovimientos() throws Exception {
        List<MovimientosBean> lista = new ArrayList<MovimientosBean>();
        List<Movimientos> entities = movimientosDAO.consultaMovimientos();
        for(Movimientos entity: entities) {
            MovimientosBean bean = new MovimientosBean();
            BaseUtil.copyProperties(bean, entity);
            lista.add(bean);
        }
        return lista;
    }
    public MovimientosBean getMovimientoPorId(MovimientosBean obj) throws Exception {
        Movimientos entity = new Movimientos();
        BaseUtil.copyProperties(entity, obj);
        entity = movimientosDAO.getMovimientoPorId(entity);
        BaseUtil.copyProperties(obj, entity);
        return  obj;
    }
}
