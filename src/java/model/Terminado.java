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
public class Terminado {
    
    private int idHorario;
    private String fechaTerminado;
    private String fechaRevisado;
    private int supervisor;
    private int estado;

    public Terminado(){
        
    }
    public Terminado(int idHorario, String fechaTerminado, String fechaRevisado, int supervisor, int estado) {
        this.idHorario = idHorario;
        this.fechaTerminado = fechaTerminado;
        this.fechaRevisado = fechaRevisado;
        this.supervisor = supervisor;
        this.estado = estado;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getFechaTerminado() {
        return fechaTerminado;
    }

    public void setFechaTerminado(String fechaTerminado) {
        this.fechaTerminado = fechaTerminado;
    }

    public String getFechaRevisado() {
        return fechaRevisado;
    }

    public void setFechaRevisado(String fechaRevisado) {
        this.fechaRevisado = fechaRevisado;
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
        return "Terminado{" + "idHorario=" + idHorario + ", fechaTerminado=" + fechaTerminado + ", fechaRevisado=" + fechaRevisado + ", supervisor=" + supervisor + ", estado=" + estado + '}';
    }
     
}
