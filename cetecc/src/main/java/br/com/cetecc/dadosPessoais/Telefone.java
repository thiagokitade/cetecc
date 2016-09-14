package br.com.cetecc.dadosPessoais;

import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigInteger;
import java.util.List;

/**
 * The persistent class for the telefone database table.
 * 
 */
@Entity
public class Telefone implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_telefone")
	private int idTelefone;

	private BigInteger celular;

	private BigInteger comercial;

	private BigInteger residencial;

	// bi-directional many-to-one association to DadosPessoais
	@OneToMany(mappedBy = "telefone")
	private List<DadosPessoais> dadosPessoais;

	public Telefone() {
	}

	@JsonIgnore
	public int getIdTelefone() {
		return this.idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public BigInteger getCelular() {
		return this.celular;
	}

	public void setCelular(BigInteger celular) {
		this.celular = celular;
	}

	public BigInteger getComercial() {
		return this.comercial;
	}

	public void setComercial(BigInteger comercial) {
		this.comercial = comercial;
	}

	public BigInteger getResidencial() {
		return this.residencial;
	}

	public void setResidencial(BigInteger residencial) {
		this.residencial = residencial;
	}
	@JsonIgnore
	public List<DadosPessoais> getDadosPessoais() {
		return this.dadosPessoais;
	}

	public void setDadosPessoais(List<DadosPessoais> dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosPessoais addDadosPessoais(DadosPessoais dadosPessoais) {
		getDadosPessoais().add(dadosPessoais);
		dadosPessoais.setTelefone(this);

		return dadosPessoais;
	}

	public DadosPessoais removeDadosPessoais(DadosPessoais dadosPessoais) {
		getDadosPessoais().remove(dadosPessoais);
		dadosPessoais.setTelefone(null);

		return dadosPessoais;
	}

}