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
public class TrabajoARealizar {
    private int idTrabajo;
    private int idEmpresa;
    private int idServicio;
    private int urgencia;
    private String detalles;
    private int estado;

    public TrabajoARealizar() {
    }

    public TrabajoARealizar(int idTrabajo, int idEmpresa, int idServicio, int urgencia, String detalles, int estado) {
        this.idTrabajo = idTrabajo;
        this.idEmpresa = idEmpresa;
        this.idServicio = idServicio;
        this.urgencia = urgencia;
        this.detalles = detalles;
        this.estado = estado;
    }

    public int getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(int idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public int getUrgencia() {
        return urgencia;
    }

    public void setUrgencia(int urgencia) {
        this.urgencia = urgencia;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}
