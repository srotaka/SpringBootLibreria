/*

 */
package com.ejercicio01.controllers;

import com.ejercicio01.entities.Autor;
import com.ejercicio01.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService aService;

    @GetMapping
    public ModelAndView mostrarAutores() {
        ModelAndView mav = new ModelAndView("autores");
        mav.addObject("autores", aService.buscarAutores());
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crearAutor() {
        ModelAndView mav = new ModelAndView("autor-formulario");
        mav.addObject("autor", new Autor());
        mav.addObject("title", "Crear Autor");
        mav.addObject("action", "guardar");
        return mav;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarAutor(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("autor-formulario");
        mav.addObject("autor", aService.buscarAutorPorId(id));
        mav.addObject("title", "Editar Autor");
        mav.addObject("action", "modificar");
        return mav;
    }

    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String nombre, RedirectAttributes attributes) throws Exception {
        try {
            aService.crearAutor(nombre);
            attributes.addFlashAttribute("exito", "AUTOR CREADO CON ÉXITO.");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", e.getMessage());
            return new RedirectView("/autores/crear");
        }
        return new RedirectView("/autores");
    }

    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id, @RequestParam String nombre, RedirectAttributes attributes){
        try {
            aService.modificarAutor(id, nombre);
            attributes.addFlashAttribute("exito", "AUTOR MODIFICADO CON ÉXITO.");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", e.getMessage());
        }

        return new RedirectView("/autores");
    }

    @PostMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        aService.eliminarAutor(id);
        return new RedirectView("/autores");
    }

    @PostMapping("/darAlta/{id}")
    public RedirectView darAlta(@PathVariable String id) {
        aService.darAltaAutor(id);
        return new RedirectView("/autores");
    }

}
