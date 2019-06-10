/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarevolutions.spring.service.impl;


import com.javarevolutions.spring.service.iface.MovimientosService;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.javarevolutions.spring.dao.iface.InversionesDAO;
import com.javarevolutions.spring.dominio.InversionesBean;
import com.javarevolutions.spring.entity.Inversiones;
import com.javarevolutions.spring.service.iface.InversionesService;
import com.javarevolutions.spring.util.BaseUtil;


public class InversionesServiceImpl implements InversionesService {
    @Autowired
    private InversionesDAO inversionesDAO;

    public boolean insertaInversion(InversionesBean obj) throws Exception {
        Inversiones entity = new Inversiones();
        BaseUtil.copyProperties(entity, obj);
        return inversionesDAO.insertaInversion(entity);
    }
    public boolean borraInversion(InversionesBean obj) throws Exception {
        Inversiones entity = new Inversiones();
        BaseUtil.copyProperties(entity, obj);
        return inversionesDAO.borraInversion(entity);
    }
    public boolean actualizaInversion(InversionesBean obj) throws Exception {
        Inversiones entity = new Inversiones();
        BaseUtil.copyProperties(entity, obj);
        return inversionesDAO.actualizaInversion(entity);
    }
    public List<InversionesBean> consultaInversiones() throws Exception {
        List<InversionesBean> lista = new ArrayList<InversionesBean>();
        List<Inversiones> entities = inversionesDAO.consultaInversiones();
        for(Inversiones entity: entities) {
            InversionesBean bean = new InversionesBean();
            BaseUtil.copyProperties(bean, entity);
            lista.add(bean);
        }
        return lista;
    }
    public InversionesBean getInversionPorId(InversionesBean obj) throws Exception {
        Inversiones entity = new Inversiones();
        BaseUtil.copyProperties(entity, obj);
        entity = inversionesDAO.getInversionPorId(entity);
        BaseUtil.copyProperties(obj, entity);
        return  obj;
    }
}