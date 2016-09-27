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
 * The persistent class for the bairro database table.
 * 
 */
@Entity
public class Bairro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_bairro")
	private long idBairro;

	private String nome;

	//bi-directional many-to-one association to Cidade
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="id_cidade")
	
	private Cidade cidade;

	//bi-directional many-to-one association to Endereco
	@OneToMany(mappedBy="bairro")
	
	private List<Endereco> enderecos;

	public Bairro() {
	}

	public long getIdBairro() {
		return this.idBairro;
	}

	public void setIdBairro(long idBairro) {
		this.idBairro = idBairro;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	//@JsonBackReference("cidade-bairro")
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	@JsonIgnore
	//@JsonManagedReference("bairro-endereco")
	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

	public Endereco addEndereco(Endereco endereco) {
		getEnderecos().add(endereco);
		endereco.setBairro(this);

		return endereco;
	}

	public Endereco removeEndereco(Endereco endereco) {
		getEnderecos().remove(endereco);
		endereco.setBairro(null);

		return endereco;
	}

}