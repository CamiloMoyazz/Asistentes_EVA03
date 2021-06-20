/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.service;

import cl.inacap.asistentes_eva03.dto.Asistente;
import java.util.List;

/**
 *
 * @author Chalabera
 */
public interface AsistenteService {
        
    public List<Asistente> listaAsistentes();
    public Asistente encontrarPorRut(Asistente asistente);
    public void ingresarAsistente(Asistente asistente);
    public void eliminarAsistente(Asistente asistente);
}
