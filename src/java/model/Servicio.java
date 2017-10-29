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
public class Servicio {
    private int idServicio;
    private String nombreS;
    private int estado;

    public Servicio() {
    }

    public Servicio(int idServicio, String Servicio,int estado) {
        this.idServicio = idServicio;
        this.nombreS = Servicio;
        this.estado=estado;
    }

    
    public Servicio( String Servicio) {
        this.idServicio =0;
        this.nombreS = Servicio;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    
}
