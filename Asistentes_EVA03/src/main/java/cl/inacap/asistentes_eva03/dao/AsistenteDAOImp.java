/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.dao;

import cl.inacap.asistentes_eva03.dto.Asistente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;


/**
 *
 * @author Chalabera
 */
@Transactional()
public class AsistenteDAOImp implements AsistenteDAO{
    
    @PersistenceContext(unitName = "Asistente" )
    private EntityManager em;
   
    @Override
    public List<Asistente> getAll() {
        return em.createNamedQuery("Asistente.findAll").getResultList();
    }

    @Override
    public String findByRut(String rut) {
        Query query = em.createQuery("FROM Asistente a where a.Rut = :rut");
        query.setParameter("rut", "%" + rut + "%");
        return (String) query.getSingleResult();
    }

    @Override
    public void insertAsistente(Asistente asistente) {
        em.persist(asistente);
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
