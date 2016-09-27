package br.com.cetecc.dadosPessoais;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the endereco database table.
 * 
 */
@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_endereco")
	private int idEndereco;

	private BigInteger cep;

	private String complemento;

	private String logradouro;

	private int numero;

	@Column(name="tipo_local")
	private String tipoLocal;

	//bi-directional many-to-one association to DadosPessoais
	@OneToMany(mappedBy="endereco")
	private List<DadosPessoais> dadosPessoais;

	//bi-directional many-to-one association to Bairro
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_bairro")
	private Bairro bairro;

	public Endereco() {
	}

	public int getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(int idEndereco) {
		this.idEndereco = idEndereco;
	}

	public BigInteger getCep() {
		return this.cep;
	}

	public void setCep(BigInteger cep) {
		this.cep = cep;
	}

	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return this.logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getTipoLocal() {
		return this.tipoLocal;
	}

	public void setTipoLocal(String tipoLocal) {
		this.tipoLocal = tipoLocal;
	}
	@JsonIgnore
	//@JsonManagedReference("endereco-dadosPessoais")
	public List<DadosPessoais> getDadosPessoais() {
		return this.dadosPessoais;
	}

	public void setDadosPessoais(List<DadosPessoais> dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

	public DadosPessoais addDadosPessoai(DadosPessoais dadosPessoai) {
		getDadosPessoais().add(dadosPessoai);
		dadosPessoai.setEndereco(this);

		return dadosPessoai;
	}

	public DadosPessoais removeDadosPessoai(DadosPessoais dadosPessoai) {
		getDadosPessoais().remove(dadosPessoai);
		dadosPessoai.setEndereco(null);

		return dadosPessoai;
	}
	//@JsonBackReference("bairro-endereco")
	public Bairro getBairro() {
		return this.bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

}