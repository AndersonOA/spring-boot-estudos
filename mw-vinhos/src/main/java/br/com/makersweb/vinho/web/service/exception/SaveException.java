/**
 * 
 */
package br.com.makersweb.vinho.web.service.exception;

/**
 *
 * @author andersonaristides
 *
 */
public class SaveException extends BaseRuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4148882352752687496L;

	private Object object;

	public SaveException(Throwable cause, Object object) {
		super(cause);
		this.object = object;
	}

	public Object getObject() {
		return object;
	}

}
