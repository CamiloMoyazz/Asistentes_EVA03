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

/**
 *
 * @author Chalabera
 */
public class AsistenteDAOImp implements AsistenteDAO{
    
    @PersistenceContext(name = "ASISTENTES")
    EntityManager em;
        
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
        em.persist(asistente);
    }

    @Override
    public void deleteAsistente(Asistente asistente) {
        em.remove(em.merge(asistente));
    }
    
}
