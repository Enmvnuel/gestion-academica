package com.cibertec.gestionacademica.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cibertec.gestionacademica.model.Docente;
import com.cibertec.gestionacademica.service.DocenteService;

@Controller
@RequestMapping("/docentes")
public class DocenteController {

	private final DocenteService docenteService;

	public DocenteController(DocenteService docenteService) {
		this.docenteService = docenteService;
	}

	@GetMapping
	public String listar(Model model) {
		model.addAttribute("docentes", docenteService.listarTodos());
		return "mantenimientos/docentes/lista_docentes";
	}

	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		model.addAttribute("docente", new Docente());
		return "mantenimientos/docentes/form_docente";
	}

	@PostMapping("/guardar")
	public String guardar(@ModelAttribute Docente docente, RedirectAttributes attributes) {
		docenteService.guardar(docente);
		attributes.addFlashAttribute("mensaje", "Docente guardado con éxito");
		return "redirect:/docentes";
	}

	@GetMapping("/editar/{id}")
	public String editar(@PathVariable Integer id, Model model, RedirectAttributes attributes) {
		Docente docente = docenteService.buscarPorId(id);
		if (docente == null) {
			attributes.addFlashAttribute("error", "Docente no encontrado.");
			return "redirect:/docentes";
		}
		model.addAttribute("docente", docente);
		return "mantenimientos/docentes/form_docente";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminar(@PathVariable Integer id, RedirectAttributes attributes) {
		try {
			docenteService.eliminar(id);
			attributes.addFlashAttribute("mensaje", "Docente eliminado con éxito.");
		} catch (Exception e) {
			attributes.addFlashAttribute("error",
					"No se puede eliminar el docente porque está asignado a un curso o tiene registros vinculados.");
		}
		return "redirect:/docentes";
	}
}