/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.test.logic;

import co.edu.uniandes.csw.parcial1.ejb.SerieLogic;
import co.edu.uniandes.csw.parcial1.entities.CapituloEntity;
import co.edu.uniandes.csw.parcial1.entities.SerieEntity;
import co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.parcial1.persistence.SeriePersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class SerieLogicTest {
 
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private SerieLogic serieLogic;

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<SerieEntity> data = new ArrayList<SerieEntity>();

    private List<CapituloEntity> capitulos = new ArrayList<CapituloEntity>();
            
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(SerieEntity.class.getPackage())
                .addPackage(SerieLogic.class.getPackage())
                .addPackage(SeriePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from SerieEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            SerieEntity entity = factory.manufacturePojo(SerieEntity.class);
            //entity.setUsuarios(capituloData);
            capitulos = entity.getCapitulos();
            em.persist(entity);
            data.add(entity);
        }
        
        for (int j = 0; j < 4; j++) {
            CapituloEntity cap = factory.manufacturePojo(CapituloEntity.class);
            cap.setEsParaMenores(Boolean.TRUE);
            capitulos.add(cap);
        }
    }

    
    /**
     * Prueba para crear una serie bien
     *
     * @throws co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException
     */
    @Test
    public void createSerieTest() throws BusinessLogicException {
        
        SerieEntity newEntity = factory.manufacturePojo(SerieEntity.class);
        newEntity.setCapitulos(capitulos);
        newEntity.setName("novacio");
        newEntity.setRating(new Float(8.42));
        SerieEntity result = serieLogic.createSerie(newEntity);
        Assert.assertNotNull(result);
        SerieEntity entity = em.find(SerieEntity.class, result.getId());
        Assert.assertEquals(newEntity.getCategory(), entity.getCategory());
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getRating(), entity.getRating());
        Assert.assertEquals(newEntity.getReleaseYear(), entity.getReleaseYear());
    
}
    /**
     * Prueba para crear una serie mal
     *
     * @throws co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException
     */
    @Test(expected = BusinessLogicException.class)
    public void createSerieMalTest() throws BusinessLogicException {
        
        SerieEntity newEntity = factory.manufacturePojo(SerieEntity.class);
        CapituloEntity capituloMalo = factory.manufacturePojo(CapituloEntity.class);
        newEntity.setCategory("Infantil");
        capituloMalo.setEsParaMenores(false);
        capitulos.add(capituloMalo);
        newEntity.setCapitulos(capitulos);
        newEntity.setName("novacio");
        newEntity.setRating(new Float(8.42));
        newEntity.setCapitulos(capitulos);
        SerieEntity result = serieLogic.createSerie(newEntity);
    }
   
}
