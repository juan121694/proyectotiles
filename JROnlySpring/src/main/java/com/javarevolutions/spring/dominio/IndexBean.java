
package com.javarevolutions.spring.dominio;

public class IndexBean extends GenericoBean {
    private static final long serialVersionUID = -7949085843200863279L;
    private String usuario;
    private String password;
    /**
     * M�todo para obtener el usuario
     * @return usuario
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * M�todo para establecer el usuario
     * @param usuario
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * M�todo para establecer el password
     * @return usuario
     */
    public String getPassword() {
        return password;
    }
    /**
     * M�todo para obtener el usuario
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
