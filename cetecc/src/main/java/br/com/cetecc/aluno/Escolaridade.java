package br.com.cetecc.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the escolaridade database table.
 * 
 */
@Entity
public class Escolaridade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_escolaridade")
	private long idEscolaridade;

	@Column(name = "ds_escolaridade")
	private String dsEscolaridade;

	@Column(name = "nr_estado")
	private String nrEstado;

	@Column(name = "txt_observacao")
	private String txtObservacao;

	// bi-directional many-to-one association to Aluno
	@OneToOne(mappedBy = "escolaridade")
	private Aluno aluno;

	public Escolaridade() {
	}

	public long getIdEscolaridade() {
		return idEscolaridade;
	}

	public void setIdEscolaridade(long idEscolaridade) {
		this.idEscolaridade = idEscolaridade;
	}
	@JsonIgnore
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getDsEscolaridade() {
		return this.dsEscolaridade;
	}

	public void setDsEscolaridade(String dsEscolaridade) {
		this.dsEscolaridade = dsEscolaridade;
	}

	public String getNrEstado() {
		return this.nrEstado;
	}

	public void setNrEstado(String nrEstado) {
		this.nrEstado = nrEstado;
	}

	public String getTxtObservacao() {
		return this.txtObservacao;
	}

	public void setTxtObservacao(String txtObservacao) {
		this.txtObservacao = txtObservacao;
	}


}