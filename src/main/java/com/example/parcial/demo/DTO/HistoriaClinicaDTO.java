package com.example.parcial.demo.DTO;

import java.util.Date;

public class HistoriaClinicaDTO {
    private Long id;
    private String descripcion;
    private Date fecha;
    private String tipoServicio;

    // Constructor, getters y setters

    public HistoriaClinicaDTO(Long id, String descripcion, Date fecha, String tipoServicio) {
        this.id = id;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.tipoServicio = tipoServicio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }
}
