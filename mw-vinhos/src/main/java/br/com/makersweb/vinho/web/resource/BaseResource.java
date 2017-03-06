/**
 * 
 */
package br.com.makersweb.vinho.web.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.makersweb.vinho.web.entity.DefaultEntity;
import br.com.makersweb.vinho.web.request.DataTableRequest;
import br.com.makersweb.vinho.web.response.DataTableResponse;
import br.com.makersweb.vinho.web.service.BaseService;
import br.com.makersweb.vinho.web.service.exception.SaveException;

/**
 *
 * @author andersonaristides
 *
 */
@RestController
public abstract class BaseResource<T extends DefaultEntity> {

	private Logger logger;

	public BaseResource() {
		logger = LoggerFactory.getLogger(this.getClass());
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deletar(@PathVariable Long id) {
		getService().deletar(id);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public T buscar(@PathVariable Long id) {
		return getService().buscar(id);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Page<T> listar(@RequestParam(value = "p", required = false, defaultValue = "0") Integer page) {
		return getService().listar(page);
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	public T salvar(@Validated @RequestBody T object) {
		T result = null;
		try {
			result = getService().salvar(object);
		} catch (DataIntegrityViolationException di) {
			getLogger().warn("Tentando inserir um dado duplicado: " + di.getMessage());
			throw new SaveException(di, object);
		} catch (Exception e) {
			getLogger().error("Erro ao gravar objeto: ", e);
			throw new SaveException(e, object);
		}

		return result;
	}
	
	@RequestMapping(value = "/filtrar", method = RequestMethod.GET)
	public DataTableResponse<T> filtrar(@Validated DataTableRequest dtrequest) {
		Page<T> page = getService().filtrar(dtrequest.getStart(), dtrequest.getLength(), dtrequest.getSearch().getValue(),
                dtrequest.getFilterColumns(), dtrequest.getOrderColumns());
        return DataTableResponse.fromPage(dtrequest.getDraw(), page);
	}

	protected abstract BaseService<T> getService();

	public Logger getLogger() {
		return logger;
	}

}
