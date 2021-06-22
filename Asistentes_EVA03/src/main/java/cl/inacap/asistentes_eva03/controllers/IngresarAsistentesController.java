/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.controllers;

import cl.inacap.asistentes_eva03.dto.Asistente;
import cl.inacap.asistentes_eva03.service.AsistenteServiceImp;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Chalabera
 */
@WebServlet("/IngresarAsistentesController.do")
public class IngresarAsistentesController extends HttpServlet {
    
    @Inject
    private AsistenteServiceImp asistenteImp;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        request.getRequestDispatcher("WEB-INF/vistas/IngresarAsistente.jsp").forward(request, response);
    }

     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String Nombre = request.getParameter("nombre-txt");
        String Rut = request.getParameter("rut-txt");
        String Apellido = request.getParameter("apellido-txt");
       
        String Empresa = request.getParameter("empresa-txt");
        String Estado = request.getParameter("estado-select");
        String Region = request.getParameter("region-select");
        
        Asistente a = new Asistente();
        a.setRut(Rut);
        a.setNombre(Nombre);
        a.setApellido(Apellido);
        a.setEdad(20);
        a.setEmpresa(Empresa);
        a.setEstado(Estado);
        a.setRegion(Region);
        
        asistenteImp.ingresarAsistente(a);
        
         RequestDispatcher redireccion;
         redireccion = request.getRequestDispatcher("MostrarAsistentesController.do");
         redireccion.forward(request, response);
         
         
         
        
        
    }

}
