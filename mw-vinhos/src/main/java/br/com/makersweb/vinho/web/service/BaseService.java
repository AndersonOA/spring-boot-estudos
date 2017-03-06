/**
 * 
 */
package br.com.makersweb.vinho.web.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.makersweb.vinho.web.entity.DefaultEntity;
import br.com.makersweb.vinho.web.repository.IBaseRepository;
import br.com.makersweb.vinho.web.service.exception.ObjectNotFoundException;

/**
 *
 * @author andersonaristides
 *
 */
public abstract class BaseService<T extends DefaultEntity> {

	protected static final int PAGE_SIZE = 15;
	
	@Autowired
    private EntityManager em;

	private Class<T> currentClass;

	/**
	 * @param currentClass
	 */
	public BaseService(Class<T> currentClass) {
		super();
		this.currentClass = currentClass;
	}

	public void deletar(Long id) {
		T object = buscar(id);
		if (null == object) {
			throw new ObjectNotFoundException();
		}

		checkWriteAccess(object);
		getRepository().delete(id);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public T buscar(Long id) {
		return getRepository().findOne(id);
	}

	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<T> listar(Integer page) {
		PageRequest request = page >= 0 ? new PageRequest(page, PAGE_SIZE) : new PageRequest(0, Integer.MAX_VALUE);
		return getRepository().findAll(request);
	}

	public T salvar(T object) {
		checkWriteAccess(object);
		prepareToSave(object);

		T saved = getRepository().save(object);
		return saved;
	}
	
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.NOT_SUPPORTED)
	public Page<T> filtrar(Integer start, Integer length, String filter, String[] filterColumns, String[] orderColumns) {
		Query query = createQuery(filter, filterColumns, orderColumns, false);
        query.setMaxResults(length);
        query.setFirstResult(start);

        List<T> data = query.getResultList();

        Query countQuery = createQuery(filter, filterColumns, null, true);
        Long count = (Long) countQuery.getSingleResult();

        Integer currentPage = start / length;
        Pageable pageable = new PageRequest(currentPage, length);
        Page<T> page = new PageImpl<T>(data, pageable, count);

        return page;
	}
	
	protected Query createQuery(String filter, String[] filterColumns, String[] orderColumns, boolean count) {
        StringBuilder queryStr = new StringBuilder();

        if (count) {
            queryStr.append("SELECT COUNT(*) ");
        }

        queryStr.append("FROM " + currentClass.getCanonicalName())
                .append(" WHERE ")
                .append(getDefaultFilter());
        if (StringUtils.isNotBlank(filter) && filterColumns != null && filterColumns.length > 0) {
            queryStr.append(" AND ( ");
            
            for (int i = 0; i < filterColumns.length; i++) {
                queryStr.append(i > 0 ? " OR " : "").append(filterColumns[i]).append(" LIKE ? ");
            }

            queryStr.append(" )");
        }

        if (orderColumns != null && orderColumns.length > 0) {
            queryStr.append(" ORDER BY ").append(ArrayUtils.toString(orderColumns).replaceAll("[\\{\\}]", ""));
        }

        Query query = em.createQuery(queryStr.toString());
        if (StringUtils.isNotBlank(filter)) {
            for (int i = 0; i < filterColumns.length; i++) {
                query.setParameter(i + 1, filter + "%");
            }
        }

        return query;
    }

	protected abstract IBaseRepository<T> getRepository();

	protected void checkWriteAccess(T object) {
	}

	protected void prepareToSave(T object) {
	}

	protected String getDefaultFilter() {
		return " 1 = 1 ";
	}

}
