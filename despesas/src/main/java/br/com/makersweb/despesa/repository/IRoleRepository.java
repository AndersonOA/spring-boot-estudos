/**
 * 
 */
package br.com.makersweb.despesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.despesa.domain.Role;

/**
 *
 * @author anderson.aristides
 *
 */
public interface IRoleRepository extends JpaRepository<Role, Long> {
	
	Role findByRole(String role);

}
