/**
 * 
 */
package br.com.makersweb.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.despesa.domain.User;

/**
 *
 * @author anderson.aristides
 *
 */
public interface IUserRepository extends JpaRepository<User, Long> {
	
	User findByEmail(String email);

}
