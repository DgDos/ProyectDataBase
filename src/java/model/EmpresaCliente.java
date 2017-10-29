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
public class EmpresaCliente {
    private int NIT;
    private String nombreEmpresa;
    private String usuarioE;
    private String passwordE;
    private String direccion;
    private int estado;

    public EmpresaCliente() {
    }

    public int getNIT() {
        return NIT;
    }

    public EmpresaCliente(int NIT, String nombreEmpresa, String usuarioE, String passwordE, String direccion, int estado) {
        this.NIT = NIT;
        this.nombreEmpresa = nombreEmpresa;
        this.usuarioE = usuarioE;
        this.passwordE = passwordE;
        this.direccion = direccion;
        this.estado= estado;
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
    
     public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
