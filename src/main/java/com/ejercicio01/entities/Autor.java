/*

 */
package com.ejercicio01.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

@Entity
@SQLDelete(sql = "UPDATE Autor a SET a.alta = false WHERE a.id = ?")
public class Autor {

    // Atributos
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private Boolean alta;
//    
//    @OneToMany(mappedBy="autor")
//    private List<Libro> libros;
    
    
    // Constructores
   

    public Autor(String nombre, List<Libro> libros) {
        this.nombre = nombre;
        //this.libros = libros;
    }

    public Autor() {
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
//
//    public List<Libro> getLibros() {
//        return libros;
//    }
//
//    public void setLibros(List<Libro> libros) {
//        this.libros = libros;
//    }

    
    // toString()
    @Override
    public String toString() {
        return String.format("%-40s", nombre);
    }
}
