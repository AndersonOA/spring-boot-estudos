/**
 * 
 */
package br.com.makersweb.despesa.service;

import br.com.makersweb.despesa.domain.User;

/**
 *
 * @author anderson.aristides
 *
 */
public interface IUserService {
	
	User findUserByEmail(String email);
	
	void salvar(User user);

}
