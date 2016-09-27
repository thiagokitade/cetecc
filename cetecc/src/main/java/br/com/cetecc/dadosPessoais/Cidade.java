package br.com.cetecc.dadosPessoais;

import java.io.Serializable;
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
 * The persistent class for the cidade database table.
 * 
 */
@Entity
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade")
	private long idCidade;

	private String nome;

	// bi-directional many-to-one association to Bairro
	@OneToMany(mappedBy = "cidade")

	private List<Bairro> bairros;

	// bi-directional many-to-one association to Estado
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name = "id_estado")

	private Estado estado;

	public Cidade() {
	}

	public long getIdCidade() {
		return this.idCidade;
	}

	public void setIdCidade(long idCidade) {
		this.idCidade = idCidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	@JsonIgnore
	//@JsonManagedReference("cidade-bairro")
	public List<Bairro> getBairros() {
		return this.bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Bairro addBairro(Bairro bairro) {
		getBairros().add(bairro);
		bairro.setCidade(this);

		return bairro;
	}

	public Bairro removeBairro(Bairro bairro) {
		getBairros().remove(bairro);
		bairro.setCidade(null);

		return bairro;
	}

	//@JsonBackReference("estado-cidade")
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}