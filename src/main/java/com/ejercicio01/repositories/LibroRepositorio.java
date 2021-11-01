/*

 */
package com.ejercicio01.repositories;

import com.ejercicio01.entities.Autor;
import com.ejercicio01.entities.Editorial;
import com.ejercicio01.entities.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, String> {

    @Modifying
    @Query("UPDATE Libro l SET l.isbn = :isbn, l.titulo = :titulo, l.anio = :anio, l.ejemplares = :ejemplares , l.ejemplaresPrestados = :ejemplaresPrestados, l.autor = :autor, l.editorial = :editorial WHERE l.id = :id")
    void modificarLibro(@Param ("id") String id, @Param ("isbn") Long isbn, @Param("titulo") String titulo, @Param("anio") Integer anio, @Param("ejemplares") Integer ejemplares, @Param("ejemplaresPrestados") Integer ejemplaresPrestados, @Param("autor") Autor autor, @Param("editorial") Editorial editorial);
    
     @Query("SELECT l FROM Libro l")
    List<Libro> mostrarLibros();
    
    @Modifying
    @Query("UPDATE Libro l SET l.alta = true WHERE l.id = :id")
    void darAltaLibro(@Param("id") String id);
    
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo")
    Libro buscarLibroPorTitulo(@Param("titulo") String titulo);
    
    @Query("SELECT l FROM Libro l WHERE l.isbn = :isbn")
    Libro buscarLibroPorIsbn(@Param("isbn") Long isbn);
    
}
