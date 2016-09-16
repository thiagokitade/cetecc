package br.com.cetecc.funcionario;

import java.io.Serializable;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import br.com.cetecc.dadosPessoais.DadosPessoais;

/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
public class Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_funcionario")
	private int idFuncionario;

	@Column(name = "horario_entrada")
	private Time horarioEntrada;

	@Column(name = "horario_saida")
	private Time horarioSaida;

	private byte voluntario;

	// bi-directional many-to-one association to DadosPessoais
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_dados_pessoais")
	private DadosPessoais dadosPessoais;

	public Funcionario() {
	}

	public int getIdFuncionario() {
		return this.idFuncionario;
	}

	public void setIdFuncionario(int idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public Time getHorarioEntrada() {
		return this.horarioEntrada;
	}

	public void setHorarioEntrada(Time horarioEntrada) {
		this.horarioEntrada = horarioEntrada;
	}

	public Time getHorarioSaida() {
		return this.horarioSaida;
	}

	public void setHorarioSaida(Time horarioSaida) {
		this.horarioSaida = horarioSaida;
	}

	public byte getVoluntario() {
		return this.voluntario;
	}

	public void setVoluntario(byte voluntario) {
		this.voluntario = voluntario;
	}

	public DadosPessoais getDadosPessoais() {
		return this.dadosPessoais;
	}

	public void setDadosPessoais(DadosPessoais dadosPessoais) {
		this.dadosPessoais = dadosPessoais;
	}

}