
package com.javarevolutions.spring.service.iface;

import com.javarevolutions.spring.dominio.MovimientosBean;
import java.util.List;

public interface MovimientosService {
    public boolean insertaMovimiento(MovimientosBean obj) throws Exception;
    public boolean borraMovimiento(MovimientosBean obj) throws Exception;
    public boolean actualizaMovimiento(MovimientosBean obj) throws Exception;
    public List<MovimientosBean> consultaMovimientos() throws Exception;
    public MovimientosBean getMovimientoPorId(MovimientosBean obj) throws Exception;
}
