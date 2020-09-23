/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.dtos;

import co.edu.uniandes.csw.parcial1.entities.CapituloEntity;
import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class CapituloDTO implements Serializable {
    private Long id;
    private String nombre;
    private Integer duracion;
    private String descripcionCorta;
    private Boolean esParaMenores;
    private SerieDTO serie;

    
    public CapituloDTO(){
        
    }
    /**
     * Constructor a partir de la entidad
     *
     * @param capituloEntity La entidad del libro
     */
    public CapituloDTO(CapituloEntity capituloEntity) {
        if (capituloEntity != null) {
            this.id = capituloEntity.getId();
            this.descripcionCorta = capituloEntity.getDescripcionCorta();
            this.duracion = capituloEntity.getDuracion();
            this.esParaMenores = capituloEntity.getEsParaMenores();
            this.nombre= capituloEntity.getNombre();
            if (capituloEntity.getSerie()!= null) {
                this.serie= new SerieDTO(capituloEntity.getSerie());
            } else {
                this.serie = null;
            }
        }
    }
        public CapituloEntity toEntity() {
        CapituloEntity serieEntity = new CapituloEntity();
        serieEntity.setDescripcionCorta(this.descripcionCorta);
        serieEntity.setDuracion(this.duracion);
        serieEntity.setId(this.id);
        serieEntity.setEsParaMenores(this.esParaMenores);
        serieEntity.setNombre(this.nombre);
        return serieEntity;
    }

    public Long getId() {
        return id;
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

    public void setId(Long id) {
        this.id = id;
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
