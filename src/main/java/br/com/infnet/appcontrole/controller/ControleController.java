package br.com.infnet.appcontrole.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.infnet.appcontrole.model.negocio.Controle;
import br.com.infnet.appcontrole.model.negocio.Remedio;
import br.com.infnet.appcontrole.model.service.ControleService;
import br.com.infnet.appcontrole.model.service.RemedioService;
import br.com.infnet.appcontrole.model.service.SolicitanteService;

@Controller
public class ControleController {

	@Autowired private RemedioService remedioService;
	@Autowired private ControleService controleService;
	@Autowired private SolicitanteService solicitanteService;

	@GetMapping(value = "/controle")
	public String novo(
				Model model
			) {
		model.addAttribute("operacao", "registro");
		model.addAttribute("remedio", remedioService.obterLista());
		model.addAttribute("solicitantes", solicitanteService.obterLista());
		
		return "controle/detalhe";
	}

	@GetMapping(value = "/controles")
	public String lista(
				Model model
			) {
		model.addAttribute("controles", controleService.obterLista());
		
		return "controle/lista";
	}
	
	@PostMapping(value = "/controle/incluir")
	public String incluir(
				Model model,
				@RequestParam String[] remediosIds,
				Controle controle
			) {
		
		List<Remedio> lista = new ArrayList<Remedio>();
		
		for(String id : remediosIds) {
			lista.add(new Remedio(Integer.valueOf(id)));
		}
		
		controle.setRemedios(lista);
		
		controleService.incluir(controle);

		return "redirect:/controles";
	}
	
	@GetMapping(value = "/controle/{id}/excluir")
	public String excluir(
				Model model,
				@PathVariable Integer id
			) {
		
		try {
			controleService.excluir(id);
		} catch (Exception e) {
			model.addAttribute("msgError", "Impossível realizar a exclusão: este item está sendo utilizado!!");
			return this.lista(model);
		}
		
		return "redirect:/controles";
	}
	@GetMapping(value = "/controle/{id}/consultar")
	public String consultar(
				Model model,
				@PathVariable Integer id
			) {
		model.addAttribute("operacao", "consulta");
		
		model.addAttribute("controle", controleService.obterPorId(id));
		
		return "controle/consulta";
	}
}
