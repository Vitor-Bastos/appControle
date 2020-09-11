package br.com.infnet.appcontrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appcontrole.model.negocio.Morfina;
import br.com.infnet.appcontrole.model.service.MorfinaService;

@Controller
public class MorfinaController {

	@Autowired private MorfinaService morfinaService;
	
	@GetMapping(value = "/morfina")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "registro");
		
		return "morfina/detalhe";
	}
	
	@GetMapping(value = "/morfinas")
	public String lista(
				Model model
			) {
		model.addAttribute("morfinas", morfinaService.obterLista());
		
		return "morfina/lista";
	}
	
	@PostMapping(value = "/morfina/incluir")
	public String incluir(
				Morfina morfina
			) {
		
		morfinaService.incluir(morfina);
		
		return "redirect:/morfinas";
	}

	@GetMapping(value = "/morfina/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			morfinaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/morfinas";
	}
	
	@GetMapping(value = "/morfina/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "alteração");
		
		model.addAttribute("morfina", morfinaService.obterPorId(id));
		
		return "morfina/detalhe";
	}
}