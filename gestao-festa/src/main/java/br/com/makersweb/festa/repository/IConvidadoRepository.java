/**
 * 
 */
package br.com.makersweb.festa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.makersweb.festa.model.Convidado;

/**
 *
 * @author anderson.aristides
 *
 */
public interface IConvidadoRepository extends JpaRepository<Convidado, Long> {

}
