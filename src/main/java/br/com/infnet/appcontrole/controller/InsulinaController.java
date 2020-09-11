package br.com.infnet.appcontrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appcontrole.model.negocio.Insulina;
import br.com.infnet.appcontrole.model.service.InsulinaService;

@Controller
public class InsulinaController {

	@Autowired private InsulinaService insulinaService;
	
	@GetMapping(value = "/insulina")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "registro");
		
		return "insulina/detalhe";
	}
	
	@GetMapping(value = "/insulinas")
	public String lista(
				Model model
			) {
		model.addAttribute("insulinas", insulinaService.obterLista());
		
		return "insulina/lista";
	}
	
	@PostMapping(value = "/insulina/incluir")
	public String incluir(
				Insulina insulina
			) {
		
		insulinaService.incluir(insulina);
		
		return "redirect:/insulinas";
	}

	@GetMapping(value = "/insulina/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			insulinaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/insulinas";
	}
	
	@GetMapping(value = "/insulina/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		
		model.addAttribute("insulina", insulinaService.obterPorId(id));
		model.addAttribute("operacao", "alteração");
		
		return "insulina/detalhe";
	}
}