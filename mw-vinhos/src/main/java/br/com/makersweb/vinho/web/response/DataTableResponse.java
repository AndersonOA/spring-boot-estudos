/**
 * 
 */
package br.com.makersweb.vinho.web.response;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;

/**
 *
 * @author andersonaristides
 *
 */
public class DataTableResponse<T extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4589193056792269249L;

	private int draw;
	private long recordsTotal;
	private long recordsFiltered;
	private List<T> data;
	private String error;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public static <T extends Serializable> DataTableResponse<T> fromPage(int draw, Page<T> page) {
		DataTableResponse<T> response = new DataTableResponse<T>();
		response.setDraw(draw);
		response.setData(page.getContent());
		response.setRecordsFiltered(page.getTotalElements());
		response.setRecordsTotal(page.getTotalElements());
		return response;
	}
}
