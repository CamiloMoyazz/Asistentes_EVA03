/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.dao;

import cl.inacap.asistentes_eva03.dto.Asistente;
import java.util.List;

/**
 *
 * @author Chalabera
 */
public interface AsistenteDAO {
    
    public List<Asistente> getAll();
    public Asistente findByRut(Asistente asistente);
    public void insertAsistente(Asistente asistente);
    public void deleteAsistente(Asistente asistente);
    
    
}
