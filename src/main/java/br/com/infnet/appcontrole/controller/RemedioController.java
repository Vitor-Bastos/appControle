package br.com.infnet.appcontrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.infnet.appcontrole.model.service.RemedioService;

@Controller
public class RemedioController {

	@Autowired private RemedioService remedioService;
	
	@GetMapping(value = "/remedios")
	public String lista(
				Model model
			) {
		model.addAttribute("remedios", remedioService.obterLista());
		
		return "remedio/lista";
	}

	@GetMapping(value = "/remedio/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			remedioService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/remedios";
	}
}