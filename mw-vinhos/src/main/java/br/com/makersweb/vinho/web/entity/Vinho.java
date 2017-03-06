/**
 * 
 */
package br.com.makersweb.vinho.web.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.makersweb.vinho.web.enums.TipoVinhoEnum;

/**
 *
 * @author andersonaristides
 *
 */
@Entity
@Table(name = "tb_vinho")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Vinho extends DefaultEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 726630803070612403L;

	@NotBlank
	private String nome;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoVinhoEnum tipo;

	@NotNull
	@NumberFormat(pattern = "#,##0.00")
	private BigDecimal valor;

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
	 * @return the tipo
	 */
	public TipoVinhoEnum getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(TipoVinhoEnum tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the valor
	 */
	public BigDecimal getValor() {
		return valor;
	}

	/**
	 * @param valor
	 *            the valor to set
	 */
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

}
