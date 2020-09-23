/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.persistence;

import co.edu.uniandes.csw.parcial1.entities.SerieEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author estudiante
 */
@Stateless
public class SeriePersistence {
    
    private static final Logger LOGGER = Logger.getLogger(SeriePersistence.class.getName());
     
    @PersistenceContext(unitName = "parcial1PU")
    protected EntityManager em;
    
    public List<SerieEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las series");
        Query q = em.createQuery("select u from SerieEntity u");
        return q.getResultList();
    }
        /**
     * Crea una publicación en la base de datos
     *
     * @param serieEntity objeto author que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public SerieEntity create(SerieEntity serieEntity) {
        LOGGER.log(Level.INFO, "Creando una serie nueva");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la author en la base de datos.
        Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(serieEntity);
        LOGGER.log(Level.INFO, "Serie creada");
        return serieEntity;
    }

}
