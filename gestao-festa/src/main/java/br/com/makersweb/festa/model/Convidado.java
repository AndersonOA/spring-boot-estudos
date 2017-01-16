/**
 * 
 */
package br.com.makersweb.festa.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author anderson.aristides
 *
 */
@Entity
public class Convidado implements Serializable {

	private static final long serialVersionUID = -4447672869834098694L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private Integer quantidadeAcompanhantes;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome
	 *            the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * @return the quantidadeAcompanhantes
	 */
	public Integer getQuantidadeAcompanhantes() {
		return quantidadeAcompanhantes;
	}

	/**
	 * @param quantidadeAcompanhantes
	 *            the quantidadeAcompanhantes to set
	 */
	public void setQuantidadeAcompanhantes(Integer quantidadeAcompanhantes) {
		this.quantidadeAcompanhantes = quantidadeAcompanhantes;
	}

}
