package com.javarevolutions.spring.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.javarevolutions.spring.dao.iface.MovimientosDAO;
import com.javarevolutions.spring.entity.Movimientos;
import com.javarevolutions.spring.entity.Index;

public class MovimientosDAOImpl extends PersistenceDAO implements MovimientosDAO {
    @Override
    @Transactional
    public boolean agregar(Object obj) throws Exception {
        Movimientos entity = (Movimientos)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("insert into "+getEsquema()+".movimientos(concepto, fecha, cantidad,tipo, usuario) values(?,?,?,?,?)");
        Object[] args = {entity.getConcepto(), entity.getFecha(), entity.getCantidad(), entity.getTipo(), entity.getUsuario().getUsuario()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    @Transactional
    public boolean borrar(Object obj) throws Exception {
        Movimientos entity = (Movimientos)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("delete from "+getEsquema()+".movimientos where id = ?");
        Object[] args = {entity.getId()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    @Transactional
    public boolean actualizar(Object obj) throws Exception {
        Movimientos entity = (Movimientos)obj;
        StringBuilder sb = new StringBuilder();
        sb.append("update "+getEsquema()+".movimientos set concepto = ?, cantidad = ?, fecha = ?, tipo = ?, usuario = ? where id = ?");
        Object[] args = {entity.getConcepto(), entity.getCantidad(), entity.getFecha(), entity.getTipo(), entity.getUsuario().getUsuario(), entity.getId()};
        return getJdbcTemplate().update(sb.toString(), args) == 0 ? true : false;
    }
    @Override
    public List<?> obtenerLista() throws Exception {
        List<Movimientos> lista = new ArrayList<Movimientos>();
        StringBuilder sb = new StringBuilder("select * from "+getEsquema()+".movimientos");
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sb.toString());
        if(rows != null && rows.size() > 0) {
            for(int i = 0; i < rows.size(); i++) {
                Map<String, Object> mapa = rows.get(i);
                Movimientos entity = new Movimientos();
                entity.setId((Integer)mapa.get("id"));
                entity.setConcepto(""+mapa.get("concepto"));
                entity.setCantidad((Integer)mapa.get("cantidad"));
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
        Movimientos obj = (Movimientos)entity;
        StringBuilder sb = new StringBuilder("select * from "+getEsquema()+".movimientos where id = ?");
        Object[] args = {obj.getId()};
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sb.toString(), args);
        if(rows != null && rows.size() > 0) {
            for(int i = 0; i < rows.size();) {
                Map<String, Object> mapa = rows.get(i);
                obj.setConcepto(""+mapa.get("concepto"));
                obj.setCantidad((Integer)mapa.get("cantidad"));
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
    public boolean insertaMovimiento(Movimientos entity) throws Exception {
        return agregar(entity);
    }
    public boolean borraMovimiento(Movimientos entity) throws Exception {
        return borrar(entity);
    }
    public boolean actualizaMovimiento(Movimientos entity) throws Exception {
        return actualizar(entity);
    }
    @SuppressWarnings("unchecked")
    public List<Movimientos> consultaMovimientos() throws Exception {
        return (List<Movimientos>)obtenerLista();
    }
    public Movimientos getMovimientoPorId(Movimientos entity) throws Exception {
        return (Movimientos)obtenerObjetoPorId(entity);
    }
}