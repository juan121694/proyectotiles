package com.javarevolutions.spring.web;

import com.javarevolutions.spring.dominio.IndexBean;
import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javarevolutions.spring.dominio.InversionesBean;
import com.javarevolutions.spring.service.iface.InversionesService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InversionesController extends ControllerUtil {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    private InversionesService service;

    @RequestMapping("/catalogos/inversiones/consultaInversiones.jr")
    public String consultaInversiones(@ModelAttribute("inversionesBean") InversionesBean inversionesBean,
        @ModelAttribute("listaInversiones") ArrayList<InversionesBean> listaInversiones, HttpServletRequest request) {
        try {
            listaInversiones.addAll(service.consultaInversiones());
            return "catalogoInversiones";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e;
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
    }
    
    @RequestMapping("/catalogos/inversiones/showInversion.jr")
    public String showInversion(@ModelAttribute("inversionesBean") InversionesBean inversionesBean,
                    Model model, HttpServletRequest request) {
        Map<String, String> tipo = new LinkedHashMap<String, String>();
        tipo.put(null, "Seleccionar . . .");
        tipo.put("Arriesgada", "Arriesgada");
        tipo.put("Seguro", "Seguro");
        model.addAttribute("listaTipos", tipo);
        if(!inversionesBean.getAccion().equals("nuevo")) {
            try {
                inversionesBean = service.getInversionPorId(inversionesBean);
                inversionesBean.setFechaStr(formatFechaString(inversionesBean.getFecha().toString()));
            } catch(Exception e) {
                String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e;
                request.setAttribute("error", error);
                log.error(error);
                return "error";
            }
        }
        return "catalogos/inversiones/aaInversion";
    }

    @RequestMapping("/catalogos/inversiones/doAAInversion.jr")
    public String doAAInversion(@ModelAttribute("inversionesBean") InversionesBean inversionesBean, HttpServletRequest request,
            HttpServletResponse response) {
        if(inversionesBean.getAccion().equals("nuevo")) {
            return insertaInversion(inversionesBean, request, response);
        } else {
            return actualizaInversion(inversionesBean, request);
        }
    }

    @RequestMapping("/catalogos/inversiones/insertaInversion.jr")
    public String insertaInversion(@ModelAttribute("inversionesBean") InversionesBean inversionesBean, HttpServletRequest request,
        HttpServletResponse response) {
        try {
            IndexBean bean = new IndexBean();
            bean.setUsuario("juan");
            bean.setPassword("1");
            inversionesBean.setUsuario(bean);
            inversionesBean.setFecha(Date.valueOf(formatFechaSQL(inversionesBean.getFechaStr())));
            service.insertaInversion(inversionesBean);
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e+" - "+inversionesBean.getMensaje();
            inversionesBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
        return "success";
    }

    @RequestMapping("/catalogos/inversiones/borraInversion.jr")
    public String borraInversion(@ModelAttribute("inversionesBean") InversionesBean inversionesBean, HttpServletRequest request) {
        try {
            service.borraInversion(inversionesBean);
            request.setAttribute("pathURL", "/catalogos/inversiones/consultaInversiones.jr");
            return "redirectScreen";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e+" - "+inversionesBean.getMensaje();
            inversionesBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "errorCatalogo";
        }
    }

    @RequestMapping("/catalogos/inversiones/actualizaInversion.jr")
    public String actualizaInversion(@ModelAttribute("inversionesBean") InversionesBean inversionesBean, HttpServletRequest request) {
        try {
            inversionesBean.setFecha(Date.valueOf(formatFechaSQL(inversionesBean.getFechaStr())));
            service.actualizaInversion(inversionesBean);
            request.setAttribute("pathURL", "/catalogos/inversiones/consultaInversiones.jr");
            return "success";
        } catch(Exception e) {
            String error = "ERROR EN LA INVOCACI�N AL SERVICIO: "+e+" - "+inversionesBean.getMensaje();
            inversionesBean.setMensaje(error);
            request.setAttribute("error", error);
            log.error(error);
            return "error";
        }
    }
}