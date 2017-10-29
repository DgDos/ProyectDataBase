/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author FiJus
 */
public class Horario {
    
    private int idHorario;
    private int idTaR;
    private int idTrabajador;
    private int horaInicio;
    private int horaFinal;
    private String fecha;
    private int estado;

    public Horario() {
    }

    public Horario(int idHorario, int idTaR, int idTrabajador, int horaInicio, int horaFinal, String fecha, int estado) {
        this.idHorario = idHorario;
        this.idTaR = idTaR;
        this.idTrabajador = idTrabajador;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdTaR() {
        return idTaR;
    }

    public void setIdTaR(int idTaR) {
        this.idTaR = idTaR;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
   
    
    
}
