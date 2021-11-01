/*

 */
package com.ejercicio01.services;

import com.ejercicio01.entities.Editorial;
import com.ejercicio01.repositories.EditorialRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepositorio editorialRepositorio;

    @Transactional
    public void crearEditorial(String nombre) throws Exception {

        validarNombreEditorial(nombre.toUpperCase());
        Editorial editorial = new Editorial();

        editorial.setNombre(nombre.toUpperCase());
        editorial.setAlta(true);

        editorialRepositorio.save(editorial);

    }

    @Transactional(readOnly = true)
    public Editorial buscarEditorialPorId(String id) {
        Optional<Editorial> editorialOptional = editorialRepositorio.findById(id);
        return editorialOptional.orElse(null);

    }

    @Transactional(readOnly = true)
    public List<Editorial> buscarEditoriales() {

        return editorialRepositorio.mostrarEditoriales();

    }

    @Transactional
    public void modificarEditorial(String id, String nombre) throws Exception {

        validarNombreEditorial(nombre.toUpperCase());
        editorialRepositorio.modificarEditorial(id, nombre.toUpperCase());
    }

    @Transactional
    public void eliminarEditorial(String id) {
        editorialRepositorio.deleteById(id);

    }

    @Transactional
    public void darAltaEditorial(String id) {
        editorialRepositorio.darAltaEditorial(id);

    }

    public void validarNombreEditorial(String nombre) throws Exception {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new Exception("EL NOMBRE DE LA EDITORIAL ES OBLIGATORIO.");
        }

        if (editorialRepositorio.buscarEditorialPorNombre(nombre) != null) {
            throw new Exception("YA EXISTE UNA EDITORIAL CON ESE NOMBRE.");
        }
    }

}
