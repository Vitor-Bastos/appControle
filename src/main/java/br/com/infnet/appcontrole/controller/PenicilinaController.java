package br.com.infnet.appcontrole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.infnet.appcontrole.model.negocio.Penicilina;
import br.com.infnet.appcontrole.model.service.PenicilinaService;

@Controller
public class PenicilinaController {

	@Autowired private PenicilinaService penicilinaService;
	
	@GetMapping(value = "/penicilina")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "registro");
		
		return "penicilina/detalhe";
	}
	
	@GetMapping(value = "/penicilinas")
	public String lista(
				Model model
			) {
		model.addAttribute("penicilinas", penicilinaService.obterLista());
		
		return "penicilina/lista";
	}
	
	@PostMapping(value = "/penicilina/incluir")
	public String incluir(
				Penicilina penicilina
			) {
		
		penicilinaService.incluir(penicilina);
		
		return "redirect:/penicilinas";
	}

	@GetMapping(value = "/penicilina/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			penicilinaService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/penicilinas";
	}
	
	@GetMapping(value = "/penicilina/{id}/alterar")
	public String alterar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "alteração");
		
		model.addAttribute("penicilina", penicilinaService.obterPorId(id));
		
		return "penicilina/detalhe";
	}
}