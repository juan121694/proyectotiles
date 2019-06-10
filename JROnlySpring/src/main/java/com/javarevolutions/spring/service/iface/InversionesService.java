/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarevolutions.spring.service.iface;

import com.javarevolutions.spring.dominio.InversionesBean;
import java.util.List;

public interface InversionesService {
    public boolean insertaInversion(InversionesBean obj) throws Exception;
    public boolean borraInversion(InversionesBean obj) throws Exception;
    public boolean actualizaInversion(InversionesBean obj) throws Exception;
    public List<InversionesBean> consultaInversiones() throws Exception;
    public InversionesBean getInversionPorId(InversionesBean obj) throws Exception;
}