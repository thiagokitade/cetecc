package br.com.cetecc.aluno;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import br.com.cetecc.dadosPessoais.DadosPessoais;
//comentario

@Entity
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aluno")
	private long idAluno;

	

	@Column(name="bl_habilidade_informatica")
	private byte blHabilidadeInformatica;

	@Column(name="estado_aluno")
	private String estadoAluno;

	private String etnia;

	@Column(name="experiencia_profissional")
	private String experienciaProfissional;

	@Column(name="habilidade_manual")
	private String habilidadeManual;

	@Column(name="problemas_familia")
	private String problemasFamilia;

	//bi-directional many-to-one association to DadosPessoais
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_dados_pessoais")
	private DadosPessoais dadosPessoais;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_condicao_fisica")
	private CondicaoFisica condicaoFisica;

	//bi-directional many-to-one association to Socioeconomico
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_socioeconomico")
	private Socioeconomico socioeconomico;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="id_escolaridade")
	private Escolaridade escolaridade;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
		name="aluno_tem_responsavel"
		, joinColumns={
			@JoinColumn(name="id_aluno")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_responsavel")
			}
		)
	private List<Responsavel> responsaveis;

	public Aluno() {
	}
	
	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}

	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
	
	public CondicaoFisica getCondicaoFisica() {
		return condicaoFisica;
	}
	public void setCondicaoFisica(CondicaoFisica condicaoFisica) {
		this.condicaoFisica = condicaoFisica;
	}
	public Socioeconomico getSocioeconomico() {
		return socioeconomico;
	}
	public void setSocioeconomico(Socioeconomico socioeconomico) {
		this.socioeconomico = socioeconomico;
	}
	public Escolaridade getEscolaridade() {
		return escolaridade;
	}
	public void setEscolaridade(Escolaridade escolaridade) {
		this.escolaridade = escolaridade;
	}
	public long getIdAluno() {
		return this.idAluno;
	}

	public void setIdAluno(long idAluno) {
		this.idAluno = idAluno;
	}

	public byte getBlHabilidadeInformatica() {
		return this.blHabilidadeInformatica;
	}

	public void setBlHabilidadeInformatica(byte blHabilidadeInformatica) {
		this.blHabilidadeInformatica = blHabilidadeInformatica;
	}

	public String getEstadoAluno() {
		return this.estadoAluno;
	}

	public void setEstadoAluno(String estadoAluno) {
		this.estadoAluno = estadoAluno;
	}

	public String getEtnia() {
		return this.etnia;
	}

	public void setEtnia(String etnia) {
		this.etnia = etnia;
	}

	public String getExperienciaProfissional() {
		return this.experienciaProfissional;
	}

	public void setExperienciaProfissional(String experienciaProfissional) {
		this.experienciaProfissional = experienciaProfissional;
	}

	public String getHabilidadeManual() {
		return this.habilidadeManual;
	}

	public void setHabilidadeManual(String habilidadeManual) {
		this.habilidadeManual = habilidadeManual;
	}

	public String getProblemasFamilia() {
		return this.problemasFamilia;
	}

	public void setProblemasFamilia(String problemasFamilia) {
		this.problemasFamilia = problemasFamilia;
	}
	//@JsonBackReference("dadosPessoais-aluno")
	public DadosPessoais getDadosPessoais() {
		return this.dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

}