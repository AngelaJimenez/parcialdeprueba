/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author estudiante
 */
@Entity
public class CapituloEntity extends BaseEntity{
    private String nombre;
    private Integer duracion;
    private String descripcionCorta;
    private Boolean esParaMenores;

    @PodamExclude
    @ManyToOne
    private SerieEntity serie;

    public void setSerie(SerieEntity serie) {
        this.serie = serie;
    }

    public SerieEntity getSerie() {
        return serie;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public Boolean getEsParaMenores() {
        return esParaMenores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public void setEsParaMenores(Boolean esParaMenores) {
        this.esParaMenores = esParaMenores;
    }
    
}
