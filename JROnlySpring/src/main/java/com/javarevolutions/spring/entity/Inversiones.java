package com.javarevolutions.spring.entity;

import java.io.Serializable;
import java.sql.Date;

public class Inversiones implements Serializable{
    private static final long serialVersionUID = 2286378858501851031L;
    private Integer id;
    private String concepto;
    private Date fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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
