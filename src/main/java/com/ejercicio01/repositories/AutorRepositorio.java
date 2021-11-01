/*

 */
package com.ejercicio01.repositories;

import com.ejercicio01.entities.Autor;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, String> {

    @Modifying
    @Query("UPDATE Autor a SET a.nombre = :nombre WHERE a.id = :id")
    void modificarAutor(@Param("id") String id, @Param("nombre") String nombre);

    @Query("SELECT a FROM Autor a")
    List<Autor> mostrarAutores();

    @Modifying
    @Query("UPDATE Autor a SET a.alta = true WHERE a.id = :id")
    void darAltaAutor(@Param("id") String id);
    
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
    Autor buscarAutorPorNombre(@Param("nombre") String nombre);
}
