/**
 * 
 */
package br.com.makersweb.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.makersweb.festa.model.Convidado;
import br.com.makersweb.festa.repository.IConvidadoRepository;

/**
 *
 * @author anderson.aristides
 *
 */
@Controller
@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private IConvidadoRepository convidadoRepository;
	
	@GetMapping
	public ModelAndView listar() {
		ModelAndView mav = new ModelAndView("ListaConvidados");
		
		mav.addObject("convidados", convidadoRepository.findAll());
		mav.addObject(new Convidado());
		
		return mav;
	}
	
	@PostMapping
	public String salvar(Convidado convidado) {
		convidadoRepository.save(convidado);
		return "redirect:/convidados";
	}
 
}
