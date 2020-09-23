/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author estudiante
 */
@Entity
public class SerieEntity extends BaseEntity {
    
    private String name;
    private String description;
    private String category;
    private Float rating;
    private Integer releaseYear;
    @PodamExclude
    @OneToMany(mappedBy = "serie", cascade= CascadeType.PERSIST, orphanRemoval = true )
     private List<CapituloEntity> capitulos = new ArrayList<CapituloEntity>();

    public void setCapitulos(List<CapituloEntity> capitulos) {
        this.capitulos = capitulos;
    }

    public List<CapituloEntity> getCapitulos() {
        return capitulos;
    }


    public SerieEntity() {
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
    
    
}
