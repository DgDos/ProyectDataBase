/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author FiJus
 */
public class Empresa {
    private int NIT;
    private String nombreEmpresa;
    private String usuarioE;
    private String passwordE;
    private String direccion;

    public Empresa() {
    }

    public int getNIT() {
        return NIT;
    }

    public Empresa(int NIT, String nombreEmpresa, String usuarioE, String passwordE, String direccion) {
        this.NIT = NIT;
        this.nombreEmpresa = nombreEmpresa;
        this.usuarioE = usuarioE;
        this.passwordE = passwordE;
        this.direccion = direccion;
    }
    
    public void setNIT(int NIT) {
        this.NIT = NIT;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getUsuarioE() {
        return usuarioE;
    }

    public void setUsuarioE(String usuarioE) {
        this.usuarioE = usuarioE;
    }

    public String getPasswordE() {
        return passwordE;
    }

    public void setPasswordE(String passwordE) {
        this.passwordE = passwordE;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}
