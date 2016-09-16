package br.com.cetecc.aluno;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the socioeconomico database table.
 * 
 */
@Entity
public class Socioeconomico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_socioeconomico")
	private int idSocioeconomico;

	@Column(name = "aluguel_financiamento")
	private float aluguelFinanciamento;

	@Column(name = "auxilio_governo")
	private String auxilioGoverno;

	private String observacao;

	@Column(name = "pai_convive")
	private byte paiConvive;

	private float pensao;

	@Column(name = "propiedade_residencia")
	private String propiedadeResidencia;

	@Column(name = "salario_mae")
	private float salarioMae;

	@Column(name = "salario_outros")
	private String salarioOutros;

	@Column(name = "salario_pai")
	private float salarioPai;

	@Column(name = "soma_salario_outros")
	private float somaSalarioOutros;

	@Column(name = "tipo_construcao")
	private String tipoConstrucao;

	// bi-directional many-to-one association to Aluno
	@OneToOne(mappedBy = "socioeconomico")
	private Aluno aluno;

	public Socioeconomico() {
	}

	public int getIdSocioeconomico() {
		return this.idSocioeconomico;
	}

	public void setIdSocioeconomico(int idSocioeconomico) {
		this.idSocioeconomico = idSocioeconomico;
	}

	public float getAluguelFinanciamento() {
		return this.aluguelFinanciamento;
	}

	public void setAluguelFinanciamento(float aluguelFinanciamento) {
		this.aluguelFinanciamento = aluguelFinanciamento;
	}

	public String getAuxilioGoverno() {
		return this.auxilioGoverno;
	}

	public void setAuxilioGoverno(String auxilioGoverno) {
		this.auxilioGoverno = auxilioGoverno;
	}

	public String getObservacao() {
		return this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public byte getPaiConvive() {
		return this.paiConvive;
	}

	public void setPaiConvive(byte paiConvive) {
		this.paiConvive = paiConvive;
	}

	public float getPensao() {
		return this.pensao;
	}

	public void setPensao(float pensao) {
		this.pensao = pensao;
	}

	public String getPropiedadeResidencia() {
		return this.propiedadeResidencia;
	}

	public void setPropiedadeResidencia(String propiedadeResidencia) {
		this.propiedadeResidencia = propiedadeResidencia;
	}

	public float getSalarioMae() {
		return this.salarioMae;
	}

	public void setSalarioMae(float salarioMae) {
		this.salarioMae = salarioMae;
	}

	public String getSalarioOutros() {
		return this.salarioOutros;
	}

	public void setSalarioOutros(String salarioOutros) {
		this.salarioOutros = salarioOutros;
	}

	public float getSalarioPai() {
		return this.salarioPai;
	}

	public void setSalarioPai(float salarioPai) {
		this.salarioPai = salarioPai;
	}

	public float getSomaSalarioOutros() {
		return this.somaSalarioOutros;
	}

	public void setSomaSalarioOutros(float somaSalarioOutros) {
		this.somaSalarioOutros = somaSalarioOutros;
	}

	public String getTipoConstrucao() {
		return this.tipoConstrucao;
	}

	public void setTipoConstrucao(String tipoConstrucao) {
		this.tipoConstrucao = tipoConstrucao;
	}
	
	@JsonIgnore
	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}


}