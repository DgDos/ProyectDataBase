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
public class Trabajador {
    private int idUsuario;
    private String usuarioT;
    private String passwordT;
    private String nombre;
    private String cargo;
    private int supervisor;
    private int estado;
    

    public Trabajador() {
    }

    public Trabajador(int idUsuario, String usuarioT, String passwordT, String nombre, String cargo, int supervisor,int estado) {
        this.idUsuario = idUsuario;
        this.usuarioT = usuarioT;
        this.passwordT = passwordT;
        this.nombre = nombre;
        this.cargo = cargo;
        this.supervisor = supervisor;
        this.estado=estado;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuarioT() {
        return usuarioT;
    }

    public void setUsuarioT(String usuarioT) {
        this.usuarioT = usuarioT;
    }

    public String getPasswordT() {
        return passwordT;
    }

    public void setPasswordT(String passwordT) {
        this.passwordT = passwordT;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idUsuario=" + idUsuario + ", usuarioT=" + usuarioT + ", passwordT=" + passwordT + ", nombre=" + nombre + ", cargo=" + cargo + ", supervisor=" + supervisor + ", estado=" + estado + '}';
    }
    
    
}
