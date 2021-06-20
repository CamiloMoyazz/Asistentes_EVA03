/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.controllers;

import cl.inacap.asistentes_eva03.dto.Asistente;
import cl.inacap.asistentes_eva03.service.AsistenteServiceImp;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chalabera
 */
@WebServlet("/MostrarAsistentesController.do")
public class MostrarAsistentesController extends HttpServlet {
    
    @Inject
    private AsistenteServiceImp asistenteService;

  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Asistente> asistentes = asistenteService.listaAsistentes();
        request.setAttribute("asistentes", asistentes);
        
        request.getRequestDispatcher("WEB-INF/vistas/MostrarAsistentes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   

}
