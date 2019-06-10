package com.javarevolutions.spring.entity;

import java.io.Serializable;
import java.sql.Date;

public class Inversiones implements Serializable{
    private static final long serialVersionUID = 2286378858501851031L;
    private Integer id;
    private String concepto;
    private Date fechaInicio;
    private String tipo;
    private Integer valor;
    private Index usuario;

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public Index getUsuario() {
        return usuario;
    }

    public void setUsuario(Index usuario) {
        this.usuario = usuario;
    }
    
}
