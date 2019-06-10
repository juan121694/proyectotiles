/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.javarevolutions.spring.dominio;

import java.sql.Date;
/**
 *
 * @author juan
 */
public class InversionesBean extends GenericoBean{
    private static final long serialVersionUID = -1833702209651210286L;
    private Integer id;
    private String concepto;
    private Date fecha;
    private Integer valor;
    private String fechaStr;
    private String tipo;
    private IndexBean usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public String getFechaStr() {
        return fechaStr;
    }

    public void setFechaStr(String fechaStr) {
        this.fechaStr = fechaStr;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public IndexBean getUsuario() {
        return usuario;
    }

    public void setUsuario(IndexBean usuario) {
        this.usuario = usuario;
    }
    
    
}
