package br.com.cetecc.turma;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.cetecc.aluno.Aluno;
import br.com.cetecc.curso.Curso;


/**
 * The persistent class for the turma database table.
 * 
 */
@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_turma")
	private long id;
	private String estado;

	//bi-directional many-to-many association to Aluno
	@ManyToMany(mappedBy="turmas")
	private List<Aluno> alunos;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_curso")
	private Curso curso;

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Turma() {
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

}