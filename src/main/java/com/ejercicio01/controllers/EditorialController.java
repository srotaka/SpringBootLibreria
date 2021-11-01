/*

 */
package com.ejercicio01.controllers;


import com.ejercicio01.entities.Editorial;
import com.ejercicio01.services.EditorialService;
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
@RequestMapping("/editoriales")
public class EditorialController {

    @Autowired
    private EditorialService eService;

    @GetMapping
    public ModelAndView mostrarEditoriales() {
        ModelAndView mav = new ModelAndView("editoriales");
        mav.addObject("editoriales", eService.buscarEditoriales());
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crearEditorial() {
        ModelAndView mav = new ModelAndView("editorial-formulario");
        mav.addObject("editorial", new Editorial());
        mav.addObject("title", "Crear Editorial");
        mav.addObject("action", "guardar");
        return mav;
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarEditorial(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("editorial-formulario");
        mav.addObject("editorial", eService.buscarEditorialPorId(id));
        mav.addObject("title", "Editar Editorial");
        mav.addObject("action", "modificar");
        return mav;
    }

    @PostMapping("/guardar")
    public RedirectView guardar(@RequestParam String nombre, RedirectAttributes attributes) throws Exception {
        try {
            eService.crearEditorial(nombre);
            attributes.addFlashAttribute("exito", "EDITORIAL CREADA CON ÉXITO.");
        } catch (Exception e) {
            attributes.addFlashAttribute("error", e.getMessage());
            return new RedirectView("/editoriales/crear");
        }
        return new RedirectView("/editoriales");
    }

    @PostMapping("/modificar")
    public RedirectView modificar(@RequestParam String id, @RequestParam String nombre, RedirectAttributes attributes) throws Exception {
       try {
            eService.modificarEditorial(id, nombre);
            attributes.addFlashAttribute("exito", "EDITORIAL MODIFICADA CON ÉXITO.");
        } catch (Exception e) {
             attributes.addFlashAttribute("error", e.getMessage());
        }
        return new RedirectView("/editoriales");
    }

    @PostMapping("/eliminar/{id}")
    public RedirectView eliminar(@PathVariable String id) {
        eService.eliminarEditorial(id);
        return new RedirectView("/editoriales");
    }
    
    @PostMapping("/darAlta/{id}")
    public RedirectView darAlta(@PathVariable String id) {
        eService.darAltaEditorial(id);
        return new RedirectView("/editoriales");
    }
}
