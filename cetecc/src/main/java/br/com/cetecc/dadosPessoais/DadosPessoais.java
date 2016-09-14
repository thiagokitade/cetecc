package br.com.cetecc.dadosPessoais;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.cetecc.aluno.Aluno;
import br.com.cetecc.aluno.Responsavel;
import br.com.cetecc.funcionario.Funcionario;

/**
 * The persistent class for the dados_pessoais database table.
 * 
 */
@Entity
@Table(name = "dados_pessoais")
public class DadosPessoais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_dados_pessoais")
	private long idDadosPessoais;

	private BigInteger cpf;

	@Temporal(TemporalType.DATE)
	@Column(name = "dt_nascimento")
	private Date dtNascimento;

	private String email;

	private String nacionalidade;

	private String naturalidade;

	private String nome;

	private BigInteger rg;

	private String uf;

	// bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy = "dadosPessoais")
	private List<Aluno> alunos;

	@OneToMany(mappedBy = "dadosPessoais")
	private List<Funcionario> funcionarios;

	@OneToMany(mappedBy = "dadosPessoais")
	private List<Responsavel> responsaveis;

	// bi-directional many-to-one association to Endereco
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_endereco")
	private Endereco endereco;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_telefone")
	private Telefone telefone;

	@JsonIgnore
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}

	public DadosPessoais() {
	}

	public long getIdDadosPessoais() {
		return this.idDadosPessoais;
	}

	public void setIdDadosPessoais(long idDadosPessoais) {
		this.idDadosPessoais = idDadosPessoais;
	}

	public BigInteger getCpf() {
		return this.cpf;
	}

	public void setCpf(BigInteger cpf) {
		this.cpf = cpf;
	}

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNacionalidade() {
		return this.nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getNaturalidade() {
		return this.naturalidade;
	}

	public void setNaturalidade(String naturalidade) {
		this.naturalidade = naturalidade;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigInteger getRg() {
		return this.rg;
	}

	public void setRg(BigInteger rg) {
		this.rg = rg;
	}

	public String getUf() {
		return this.uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@JsonIgnore
	// @JsonManagedReference("dadosPessoais-aluno")
	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setDadosPessoais(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setDadosPessoais(null);

		return aluno;
	}

	// @JsonBackReference("endereco-dadosPessoais")
	public Endereco getEndereco() {
		return this.endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@JsonIgnore
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}

}