/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.service;

import cl.inacap.asistentes_eva03.dao.AsistenteDAO;
import cl.inacap.asistentes_eva03.dto.Asistente;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Chalabera
 */
public class AsistenteServiceImp implements AsistenteService {
    
    @Inject
    private AsistenteDAO asistenteDAO;

    @Override
    public List<Asistente> listaAsistentes() {
        return asistenteDAO.getAll();
    }

    @Override
    public Asistente encontrarPorRut(Asistente asistente) {
        return asistenteDAO.findByRut(asistente);
    }

    @Override
    public void ingresarAsistente(Asistente asistente) {
        asistenteDAO.insertAsistente(asistente);
    }

    @Override
    public void eliminarAsistente(Asistente asistente) {
       asistenteDAO.deleteAsistente(asistente);
    }

    @Override
    public int totalAsistentes() {
        return asistenteDAO.totalAsistentes();
    }
    
    
    
}
