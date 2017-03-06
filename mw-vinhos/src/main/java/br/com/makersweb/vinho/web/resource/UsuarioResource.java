/**
 * 
 */
package br.com.makersweb.vinho.web.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.vinho.web.entity.Usuario;
import br.com.makersweb.vinho.web.service.BaseService;
import br.com.makersweb.vinho.web.service.UsuarioService;

/**
 *
 * @author andersonaristides
 *
 */
@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioResource extends BaseResource<Usuario> {

	@Autowired
	private UsuarioService service;

	@Override
	protected BaseService<Usuario> getService() {
		return service;
	}

}
