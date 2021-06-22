/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.dao;

import cl.inacap.asistentes_eva03.dto.Asistente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


/**
 *
 * @author Chalabera
 */
public class AsistenteDAOImp implements AsistenteDAO{
    
    @PersistenceContext(unitName = "Asistente" )
    private EntityManager em;
   
    @Override
    public List<Asistente> getAll() {
        return em.createNamedQuery("Asistente.findAll").getResultList();
    }

    @Override
    public Asistente findByRut(Asistente asistente) {
        return em.find(Asistente.class, asistente.getRut());
    }

    @Override
    public void insertAsistente(Asistente asistente) {
        
        try{
            em.persist(asistente);
        }catch(Exception e){
            System.err.println(e);
        }
        
        
    }

    @Override
    public void deleteAsistente(Asistente asistente) {
        em.remove(em.merge(asistente));
        
    }

    @Override
    public int totalAsistentes() {
        Query queryCount = em.createQuery("SELECT COUNT(a) FROM Asistente a");
        long total = ((Number) queryCount.getSingleResult()).longValue();
        return (int) total;
    }

    
}
