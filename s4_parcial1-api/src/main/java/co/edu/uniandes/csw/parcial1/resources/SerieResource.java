/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.resources;

import co.edu.uniandes.csw.parcial1.dtos.SerieDTO;
import co.edu.uniandes.csw.parcial1.ejb.SerieLogic;
import co.edu.uniandes.csw.parcial1.entities.SerieEntity;
import co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 *
 * @author estudiante
 */
@Path("/series")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class SerieResource {
    
    private static final Logger LOGGER = Logger.getLogger(SerieResource.class.getName());

    @Inject
    private SerieLogic serieLogic;
    
    @GET
    public List<SerieDTO> getSeries() {
        LOGGER.info("SerieResource getSeries: input: void");
        List<SerieDTO> listaSeries = listEntity2DTO(serieLogic.getSeries());
        LOGGER.log(Level.INFO, "SerieResource getSeries: output: {0}", listaSeries);
        return listaSeries;
    }
    
    private List<SerieDTO> listEntity2DTO(List<SerieEntity> entityList) {
        List<SerieDTO> list = new ArrayList<>();
        for (SerieEntity entity : entityList) {
            list.add(new SerieDTO(entity));
        }
        return list;
    }
        
    @POST
    public SerieDTO createSerie(SerieDTO serie) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "SerieResource createSerie: input: {0}", serie);
        SerieDTO nuevaSerieDTO = new SerieDTO(serieLogic.createSerie(serie.toEntity()));
        LOGGER.log(Level.INFO, "SerieResource createSerie: output: {0}", nuevaSerieDTO);
        return nuevaSerieDTO;
    }   

}
