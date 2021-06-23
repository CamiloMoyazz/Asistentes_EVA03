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
       
        //      ----------   VALIDACIONES DEL FORMULARIO    ---------- 
        
         List<String> errores = new ArrayList<String>();
         
         Asistente asis = new Asistente();
        
        //VALIDACION NOMBRE
        String nombre = request.getParameter("nombre-txt");
        if(nombre.isEmpty()){
            errores.add("Debe Ingresar un Nombre");
        }

        //VALIDACION RUT
        String rut = request.getParameter("rut-txt");
        if(rut.isEmpty()){
            errores.add("Debe Ingresar un Rut");
        }else{
            //          ---- VERIFICACION DE RUT CHILENO VALIDO ----
            
            try{
                // ELIMINARMOS CUALQUIER CARACTER QUE NO NOS IMPORTE
				rut = rut.toUpperCase();
				rut = rut.replace(".", "");
				rut = rut.replace("-", "");

				// INVERTIMOS LA CADENA PARA PODER EMPEZAR A MULTIPLICAR DESDE EL ULTIMO DIGITO
				// PERO PRIMERO VALIDAMOS SI EL RUT COMIENZA SOLO CON 1 DIGITO
				if (rut.length() > 8) {
					String rutVerificado = rut.substring(0, 8);
					char verificador = rut.charAt(8);
					String veri = String.valueOf(verificador);

					char[] rutArray = rutVerificado.toCharArray();
					Object[] invertir = new Object[rutArray.length];
					int tope = rutArray.length;

					for (int i = 0; i < rutArray.length; i++) {

						invertir[tope - 1] = rutArray[i];
						tope--;
					}

					// MULTIPLICAMOS LOS VALORES DESDE EL ULTIMO AL PRIMERO POR 2,3,4,5,6,7
					int secuencia = 2;
					int suma = 0;
					int mult;

					for (int i = 0; i < invertir.length; i++) {
						mult = 0;
						mult = Integer.parseInt(String.valueOf(invertir[i])) * secuencia;
						suma += mult;

						if (secuencia == 7) {
							secuencia = 1;
						}
						secuencia++;
					}

					// CALCULAMOS EL MODULO 11
					int resto = suma % 11;
					String digito = String.valueOf(11 - resto);

					// VALIDAMOS QUE EL DIGITO REL RUT INGRESADO CORRESPONDE AL RESTO QUE SE
					// CUALCULO
					if (digito.equals("11")) {
						digito = "0";
						if (!digito.equals(veri)) {
							errores.add("Debe Ingresar un Rut Válido");
						}
					} else if (digito.equals("10")) {
						digito = "K";
						if (!digito.equals(veri)) {
							errores.add("Debe Ingresar un Rut Válido");
						}
					}
					if (digito.contentEquals(veri)) {
						// AGREGAMOS EL GUION AL FINAL PARA HACERLO MAS LEIBLE
						StringBuilder division = new StringBuilder(rut);
						division.insert(8, "-");
						rut = division.toString();

						 asis.setRut(rut);
					} else {
						errores.add("Debe Ingresar un Rut Válido");
					}

			// ESTA PARTE ES SIMILAR A LA DE ARRIBA SOLO QUE VERIFICA A LOS RUT DE PERSONAS MAS ANTIGUAS QUE CUENTAN CON UN RUT CON MENOS DIGITOS
				} else {
					String rutVerificado = rut.substring(0, 7);
					char verificador = rut.charAt(7);
					String veri = String.valueOf(verificador);

					char[] rutArray = rutVerificado.toCharArray();
					Object[] invertir = new Object[rutArray.length];
					int tope = rutArray.length;

					for (int i = 0; i < rutArray.length; i++) {

						invertir[tope - 1] = rutArray[i];
						tope--;
					}

					// MULTIPLICAMOS LOS VALORES DESDE EL ULTIMO AL PRIMERO POR 2,3,4,5,6,7
					int secuencia = 2;
					int suma = 0;
					int mult;

					for (int i = 0; i < invertir.length; i++) {
						mult = 0;
						mult = Integer.parseInt(String.valueOf(invertir[i])) * secuencia;
						suma += mult;

						if (secuencia == 7) {
							secuencia = 1;
						}
						secuencia++;
					}

					// CALCULAMOS EL MODULO 11
					int resto = suma % 11;
					String digito = String.valueOf(11 - resto);

					// VALIDAMOS QUE EL DIGITO REL RUT INGRESADO CORRESPONDE AL RESTO QUE SE
					// CUALCULO
					if (digito.equals("11")) {
						digito = "0";
						if (!digito.equals(veri)) {
							errores.add("Debe Ingresar un Rut Válido");
						}
					} else if (digito.equals("10")) {
						digito = "K";
						if (!digito.equals(veri)) {
							errores.add("Debe Ingresar un Rut Válido");
						}
					}
					if (digito.contentEquals(veri)) {
						// AGREGAMOS EL GUION AL FINAL PARA HACERLO MAS LEIBLE
						StringBuilder division = new StringBuilder(rut);
						division.insert(7, "-");
						rut = division.toString();

						// SETEAMOS EL RUT EN LA CLASE SOLICITUD
						 asis.setRut(rut);
					} else {
						errores.add("Debe Ingresar un Rut Válido");
					}
                                        
				}
            }catch(Exception ex){
                errores.add("Debe Ingresar un Rut Chileno Válido");
            }
        }
        
        //VALIDACION APELLIDO
        String apellido = request.getParameter("apellido-txt");
        if(apellido.isEmpty()){
            errores.add("Debe Ingresar un Apellido");
        }
        
        //VALIDACION EDAD Y PARSEO A INTEGER
        String edad = request.getParameter("edad-txt");
        if(edad.isEmpty()){
            errores.add("Debe Ingresar una Edad");
        }else{
            int edadPars = 0;
            try{
                edadPars = Integer.parseInt(edad);
            }catch(Exception ex){
                errores.add("Debe Ingresar una Edad Válida");
            }
              asis.setEdad(edadPars);
        }
        
        //VALIDACION EMPRESA
        String empresa = request.getParameter("empresa-txt");
        if(empresa.isEmpty()){
            errores.add("Debe Ingresar una Empresa");
        }
        
        String estado = request.getParameter("estado-select");
        String region = request.getParameter("region-select");
        
        asis.setNombre(nombre);
        asis.setApellido(apellido);
        asis.setEmpresa(empresa);
        asis.setEstado(estado);
        asis.setRegion(region);
        
        if(errores.isEmpty()){
                asistenteImp.ingresarAsistente(asis);   
        }else{ 
            request.setAttribute("errores", errores);
        }
       
            
         doGet(request, response);
    }

}
