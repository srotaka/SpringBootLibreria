/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejercicio01.repositories;

import com.ejercicio01.entities.Editorial;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, String> {

    @Modifying
    @Query("UPDATE Editorial e SET e.nombre = :nombre WHERE e.id = :id")
    void modificarEditorial(@Param("id") String id, @Param("nombre") String nombre);

    
    @Query("SELECT e FROM Editorial e") //WHERE e.alta = true
    List<Editorial> mostrarEditoriales();
    
    @Modifying
    @Query("UPDATE Editorial e SET e.alta = true WHERE e.id = :id")
    void darAltaEditorial(@Param("id") String id);
    
    @Query("SELECT e FROM Editorial e WHERE e.nombre = :nombre")
    Editorial buscarEditorialPorNombre(@Param("nombre") String nombre);

}
