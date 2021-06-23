/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.controllers;

import cl.inacap.asistentes_eva03.dto.Asistente;
import cl.inacap.asistentes_eva03.service.AsistenteServiceImp;
import java.io.IOException;
import java.util.ArrayList;
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

        //       ---- FILTRADO DE TABLA ----
        
            //DECLARAMOS 2 LISTAS
            // 1 PARA OBTENER TODAS LAS SOLICITUDES
            // 2 PARA OBTENER SOLO LAS QUE COINCIDAN CON EL FILTRO OBTENIDO DESDE EL JSP
            List<Asistente> asistentes = asistenteService.listaAsistentes();
            List<Asistente> asistentesFiltrados = new ArrayList<Asistente>();
            
            
            // FUNCION PARA FILTRAR POR ESTADO, SI COINCIDEN SE GUARDA EN LA LISTA.
            // SI EL FILTRO ES TODAS, ME LANZA LA LISTA COMPLETA.
            // EN CASO DE NO FILTRAR NADA , ME LANZARA LA LISTA POR DEFAULT.
             if(request.getParameter("filtro-select") != null){
                for(Asistente asisTemp : asistentes){
                    if(request.getParameter("filtro-select").equalsIgnoreCase(asisTemp.getEstado())){
                        asistentesFiltrados.add(asisTemp);
                        System.out.println("Se agrego!");
                    }
                }
                
                request.setAttribute("asistentes", asistentesFiltrados);
                
                if(request.getParameter("filtro-select").equalsIgnoreCase("Todas")){
                    request.setAttribute("asistentes", asistentes);
                }     
            }else{
               request.setAttribute("asistentes", asistentes);
             }
        int totalAsistentes = asistenteService.totalAsistentes();
        request.setAttribute("total", totalAsistentes);
        request.getRequestDispatcher("WEB-INF/vistas/MostrarAsistentes.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

   

}
