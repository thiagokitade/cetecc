package br.com.cetecc.aluno;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

/**
 * The persistent class for the condicao_fisica database table.
 * 
 */
@Entity(name = "condicao_fisica")
public class CondicaoFisica implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_condicao_fisica")
	private int idCondicaoFisica;

	private String alergia;

	@Column(name = "deficiencia_fisica")
	private String deficienciaFisica;

	private String doencas;

	@Column(name = "outras_doencas")
	private String outrasDoencas;

	@Column(name = "problema_saude")
	private String problemaSaude;

	// bi-directional many-to-one association to Aluno
	@OneToOne(mappedBy = "condicaoFisica")
	private Aluno aluno;

	public CondicaoFisica() {
	}

	public int getIdCondicaoFisica() {
		return this.idCondicaoFisica;
	}

	public void setIdCondicaoFisica(int idCondicaoFisica) {
		this.idCondicaoFisica = idCondicaoFisica;
	}

	public String getAlergia() {
		return this.alergia;
	}

	public void setAlergia(String alergia) {
		this.alergia = alergia;
	}

	public String getDeficienciaFisica() {
		return this.deficienciaFisica;
	}

	public void setDeficienciaFisica(String deficienciaFisica) {
		this.deficienciaFisica = deficienciaFisica;
	}

	public String getDoencas() {
		return this.doencas;
	}

	public void setDoencas(String doencas) {
		this.doencas = doencas;
	}

	public String getOutrasDoencas() {
		return this.outrasDoencas;
	}

	public void setOutrasDoencas(String outrasDoencas) {
		this.outrasDoencas = outrasDoencas;
	}

	public String getProblemaSaude() {
		return this.problemaSaude;
	}

	public void setProblemaSaude(String problemaSaude) {
		this.problemaSaude = problemaSaude;
	}

	@JsonIgnore
	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
}