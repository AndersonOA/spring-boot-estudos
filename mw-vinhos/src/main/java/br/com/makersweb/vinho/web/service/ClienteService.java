/**
 * 
 */
package br.com.makersweb.vinho.web.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.makersweb.vinho.web.entity.Cliente;
import br.com.makersweb.vinho.web.repository.IBaseRepository;
import br.com.makersweb.vinho.web.repository.IClienteRepository;

/**
 *
 * @author andersonaristides
 *
 */
@Service
@Transactional
public class ClienteService extends BaseService<Cliente> {

	@Autowired
	private IClienteRepository repository;

	/**
	 * @param currentClass
	 */
	public ClienteService() {
		super(Cliente.class);
	}

	@Override
	protected IBaseRepository<Cliente> getRepository() {
		return repository;
	}

}
