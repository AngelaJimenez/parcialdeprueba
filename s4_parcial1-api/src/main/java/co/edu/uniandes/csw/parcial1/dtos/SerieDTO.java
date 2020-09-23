/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.dtos;

import co.edu.uniandes.csw.parcial1.entities.SerieEntity;
import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class SerieDTO implements Serializable {
    
    private Long id;
    private String name;
    private String description;
    private String category;
    private Float rating;
    private Integer releaseYear;

    public SerieDTO() {
    }
    
    public SerieDTO( SerieEntity serieEntity ) {
        if( serieEntity != null ) {
            this.id = serieEntity.getId();
            this.name = serieEntity.getName();
            this.description = serieEntity.getDescription();
            this.category = serieEntity.getCategory();
            this.rating = serieEntity.getRating();
            this.releaseYear = serieEntity.getReleaseYear();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }
    
    public SerieEntity toEntity() {
        SerieEntity serieEntity = new SerieEntity();
        serieEntity.setDescription(this.description);
        serieEntity.setCategory(this.category);
        serieEntity.setId(this.id);
        serieEntity.setName(this.name);
        serieEntity.setRating(this.rating);
        serieEntity.setReleaseYear(this.releaseYear);
        return serieEntity;
    }
    

    
}
