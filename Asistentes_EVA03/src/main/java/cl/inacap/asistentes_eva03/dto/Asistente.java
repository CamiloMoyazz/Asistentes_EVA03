/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.inacap.asistentes_eva03.dto;

import java.io.Serializable;
import javax.persistence.*;

@Entity

@NamedQueries({

    @NamedQuery(name = "Asistente.findAll", query = "SELECT a FROM Asistente a")

})

@Table(name = "Asistente")
public class Asistente implements Serializable{
        
        @Id
        @Column(name = "Rut")
	private String Rut;
        @Column(name = "Nombre")
	private String Nombre;
        @Column(name = "Apellido")
	private String Apellido;
        @Column(name = "Edad")
	private int Edad;
        @Column(name = "Empresa")
	private String Empresa;
        @Column(name = "Region")
	private String Region;
        @Column(name = "Estado")
	private String Estado;

      
    public Asistente() {
    }
        
    public Asistente(String Rut, String Nombre, String Apellido, int Edad, String Empresa, String Region, String Estado) {
        this.Rut = Rut;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Empresa = Empresa;
        this.Region = Region;
        this.Estado = Estado;
    }



    public String getRut() {
        return Rut;
    }

    public void setRut(String Rut) {
        this.Rut = Rut;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getEmpresa() {
        return Empresa;
    }

    public void setEmpresa(String Empresa) {
        this.Empresa = Empresa;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String Region) {
        this.Region = Region;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return "Asistente{" + "Nombre=" + Nombre + ", Empresa=" + Empresa + ", Estado=" + Estado + '}';
    }
        
    
}
