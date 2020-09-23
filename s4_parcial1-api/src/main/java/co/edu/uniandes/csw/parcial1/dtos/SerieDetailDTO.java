/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.dtos;

import co.edu.uniandes.csw.parcial1.entities.CapituloEntity;
import co.edu.uniandes.csw.parcial1.entities.SerieEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class SerieDetailDTO extends SerieDTO implements Serializable {
    
        private List<CapituloDTO> capitulos;

        public SerieDetailDTO(){
        super();
    }

        public SerieDetailDTO(SerieEntity serieEntity)
        {
            if (serieEntity.getCapitulos()!= null)
        {
         capitulos = new ArrayList<>();
            for (CapituloEntity cortoEntity : serieEntity.getCapitulos())
            {
                capitulos.add(new CapituloDTO(cortoEntity));
            }
        }
        }
}
