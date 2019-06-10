package com.javarevolutions.spring.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.javarevolutions.spring.dao.iface.InversionesDAO;
import com.javarevolutions.spring.entity.Inversiones;
import com.javarevolutions.spring.entity.Index;

public class InversionesDAOImpl extends PersistenceDAO implements InversionesDAO {
    @Override
    @Transactional
    public boolean agregar(Object obj) throws Exception {
        Inversiones entity = (Inversiones)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into "+getEsquema()+".inversiones(concepto, fecha,valor,tipo, usuario) values(?,?,?,?,?)");
        Object[] args = {entity.getConcepto(), entity.getFecha(), entity.getValor(), entity.getTipo(), entity.getUsuario().getUsuario()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    @Transactional
    public boolean borrar(Object obj) throws Exception {
        Inversiones entity = (Inversiones)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from "+getEsquema()+".inversiones where id = ?");
        Object[] args = {entity.getId()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    @Transactional
    public boolean actualizar(Object obj) throws Exception {
        Inversiones entity = (Inversiones)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("update "+getEsquema()+".inversiones set concepto = ?, valor = ?, fecha = ?, tipo = ?, usuario = ? where id = ?");
        Object[] args = {entity.getConcepto(), entity.getValor(), entity.getFecha(), entity.getTipo(), entity.getUsuario().getUsuario(), entity.getId()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    public List<?> obtenerLista() throws Exception {
        List<Inversiones> lista = new ArrayList<Inversiones>();
        StringBuilder sb = new StringBuilder("select * from "+getEsquema()+".inversiones");
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sb.toString());
        if(rows != null && rows.size() > 0) {
            for(int i = 0; i < rows.size(); i++) {
                Map<String, Object> mapa = rows.get(i);
                Inversiones entity = new Inversiones();
                entity.setId((Integer)mapa.get("id"));
                entity.setConcepto(""+mapa.get("concepto"));
                entity.setValor((Integer)mapa.get("valor"));
                entity.setFecha((Date)mapa.get("fecha"));
                entity.setTipo(""+mapa.get("tipo"));
                Index usuario = new Index();
                usuario.setUsuario(""+mapa.get("usuario"));
                entity.setUsuario(usuario);
                lista.add(entity);
            }
        }
        return lista;
    }
    @Override
    public Object obtenerObjetoPorId(Object entity) throws Exception {
        Inversiones obj = (Inversiones)entity;
        StringBuilder sb = new StringBuilder("select * from "+getEsquema()+".inversiones where id = ?");
        Object[] args = {obj.getId()};
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sb.toString(), args);
        if(rows != null && rows.size() > 0) {
            for(int i = 0; i < rows.size();) {
                Map<String, Object> mapa = rows.get(i);
                obj.setConcepto(""+mapa.get("concepto"));
                obj.setValor((Integer)mapa.get("valor"));
                obj.setFecha((Date)mapa.get("fecha"));
                obj.setTipo(""+mapa.get("tipo"));
                Index usuario = new Index();
                usuario.setUsuario(""+mapa.get("usuario"));
                obj.setUsuario(usuario);
                return obj;
            }
        }
        return obj;
    }
    public boolean insertaInversion(Inversiones entity) throws Exception {
        return agregar(entity);
    }
    public boolean borraInversion(Inversiones entity) throws Exception {
        return borrar(entity);
    }
    public boolean actualizaInversion(Inversiones entity) throws Exception {
        return actualizar(entity);
    }
    @SuppressWarnings("unchecked")
    public List<Inversiones> consultaInversiones() throws Exception {
        return (List<Inversiones>)obtenerLista();
    }
    public Inversiones getInversionPorId(Inversiones entity) throws Exception {
        return (Inversiones)obtenerObjetoPorId(entity);
    }
}