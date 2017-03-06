/**
 * 
 */
package br.com.makersweb.vinho.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.makersweb.vinho.web.entity.Usuario;
import br.com.makersweb.vinho.web.repository.IBaseRepository;
import br.com.makersweb.vinho.web.repository.IUsuarioRepository;

/**
 *
 * @author andersonaristides
 *
 */
@Service
@Transactional
public class UsuarioService extends BaseService<Usuario> {

	@Autowired
	private IUsuarioRepository repository;

	public UsuarioService() {
		super(Usuario.class);
	}

	@Override
	protected IBaseRepository<Usuario> getRepository() {
		return repository;
	}

}
