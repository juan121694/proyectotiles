package com.javarevolutions.spring.web;


import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarevolutions.spring.dominio.MovimientosBean;
import com.javarevolutions.spring.service.iface.MovimientosService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MovimientosController extends ControllerUtil {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private MovimientosService service;

    @RequestMapping("/catalogos/movimientos/consultaMovimientos.jr")
    public String consultaMovimientos(@ModelAttribute("movimientosBean") MovimientosBean movimientosBean,
        @ModelAttribute("listaMovimientos") ArrayList<MovimientosBean> listaMovimientos, HttpServletRequest request) {
        try {
            listaMovimientos.addAll(service.consultaMovimientos());
            return "catalogoMovimientos";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e;
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
    }
    
    @RequestMapping("/catalogos/movimientos/showMovimiento.jr")
    public String showMovimiento(@ModelAttribute("movimientosBean") MovimientosBean movimientosBean,
                    Model model, HttpServletRequest request) {
        Map<String, String> tipo = new LinkedHashMap<String, String>();
        tipo.put(null, "Seleccionar . . .");
        tipo.put("A", "Abono");
        tipo.put("C", "Cargo");
        model.addAttribute("listaTipos", tipo);
        if(!movimientosBean.getAccion().equals("nuevo")) {
            try {
                movimientosBean = service.getMovimientoPorId(movimientosBean);
                movimientosBean.setFechaStr(formatFechaString(movimientosBean.getFecha().toString()));
            } catch(Exception e) {
                String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e;
                request.setAttribute("error", error);
                log.error(error);
                return "error";
            }
        }
        return "catalogos/movimientos/aaMovimiento";
    }

    @RequestMapping("/catalogos/movimientos/doAAMovimiento.jr")
    public String doAAMovimiento(@ModelAttribute("movimientosBean") MovimientosBean movimientosBean, HttpServletRequest request,
            HttpServletResponse response) {
        if(movimientosBean.getAccion().equals("nuevo")) {
            return insertaMovimiento(movimientosBean, request, response);
        } else {
            return actualizaMovimiento(movimientosBean, request);
        }
    }

    @RequestMapping("/catalogos/movimientos/insertaMovimiento.jr")
    public String insertaMovimiento(@ModelAttribute("movimientosBean") MovimientosBean movimientosBean, HttpServletRequest request,
        HttpServletResponse response) {
        try {
            movimientosBean.setFecha(Date.valueOf(formatFechaSQL(movimientosBean.getFechaStr())));
            service.insertaMovimiento(movimientosBean);
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e+" - "+movimientosBean.getMensaje();
            movimientosBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
        return "success";
    }

    @RequestMapping("/catalogos/movimientos/borraMovimiento.jr")
    public String borraCliente(@ModelAttribute("movimientosBean") MovimientosBean movimientosBean, HttpServletRequest request) {
        try {
            service.borraMovimiento(movimientosBean);
            request.setAttribute("pathURL", "/catalogos/movimientos/consultaMovimientos.jr");
            return "redirectScreen";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e+" - "+movimientosBean.getMensaje();
            movimientosBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "errorCatalogo";
        }
    }

    @RequestMapping("/catalogos/movimientos/actualizaMovimiento.jr")
    public String actualizaMovimiento(@ModelAttribute("movimientosBean") MovimientosBean movimientosBean, HttpServletRequest request) {
        try {
            movimientosBean.setFecha(Date.valueOf(formatFechaSQL(movimientosBean.getFechaStr())));
            service.actualizaMovimiento(movimientosBean);
            request.setAttribute("pathURL", "/catalogos/movimientos/consultaMovimientos.jr");
            return "success";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e+" - "+movimientosBean.getMensaje();
            movimientosBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
    }
}