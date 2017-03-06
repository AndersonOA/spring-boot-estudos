/**
 * 
 */
package br.com.makersweb.vinho.web.repository;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.makersweb.vinho.web.entity.DefaultEntity;

/**
 *
 * @author andersonaristides
 *
 */
@NoRepositoryBean
public interface IBaseRepository<T extends DefaultEntity> extends PagingAndSortingRepository<T, Long> {

}
