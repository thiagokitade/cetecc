package br.com.cetecc.aluno;

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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cetecc.dadosPessoais.DadosPessoais;

/**
 * The persistent class for the responsavel database table.
 * 
 */
@Entity
public class Responsavel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_responsavel")
	private int idResponsavel;

	private BigInteger cic;
	
	@Column(name = "parentesco_relacao")
	private String parentescoRelacao;

	// bi-directional many-to-many association to Aluno
	@ManyToMany(mappedBy = "responsaveis")
	private List<Aluno> alunos;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_dados_pessoais")
	private DadosPessoais dadosPessoais;

	public Responsavel() {
	}

	public int getIdResponsavel() {
		return this.idResponsavel;
	}

	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public BigInteger getCic() {
		return this.cic;
	}

	public void setCic(BigInteger cic) {
		this.cic = cic;
	}


	public String getParentescoRelacao() {
		return this.parentescoRelacao;
	}

	public void setParentescoRelacao(String parentescoRelacao) {
		this.parentescoRelacao = parentescoRelacao;
	}

	@JsonIgnore
	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	
	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public DadosPessoais getDadosPessoais() {
		return dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

}