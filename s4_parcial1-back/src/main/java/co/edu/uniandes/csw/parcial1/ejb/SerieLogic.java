/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.ejb;

import co.edu.uniandes.csw.parcial1.entities.SerieEntity;
import co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.parcial1.persistence.SeriePersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class SerieLogic {
    
    private static final Logger LOGGER = Logger.getLogger(SerieLogic.class.getName());

    @Inject
    private SeriePersistence  persistence;
    
    public List<SerieEntity> getSeries() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas los series");
        List<SerieEntity> lista = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todas los series");
        return lista;
    }
    public SerieEntity createSerie(SerieEntity serieEntity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de evento");
        if (serieEntity.getName()== null || serieEntity.getName().equals("") ) 
        {
         throw new BusinessLogicException("El nombre no es valido");   
        }

        if (serieEntity.getRating()<0 || serieEntity.getRating()>10) {
            throw new BusinessLogicException("El rating no es valido");   
        }
        if(serieEntity.getCategory().equals("Infantil"))
        {
        for( int i = 0; i<serieEntity.getCapitulos().size(); i++)
            {
                if(serieEntity.getCapitulos().get(i).getEsParaMenores()== false)
                {
                throw new BusinessLogicException("No todos los capitulos son para menores");                
                }
            }
        }
        persistence.create(serieEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la serie");
        return serieEntity;
    }

}
