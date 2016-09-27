package br.com.cetecc.disciplina;

import java.io.Serializable;
import javax.persistence.*;

import br.com.cetecc.curso.Curso;

import java.util.List;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_disciplina")
	private long idDisciplina;

	private String descricao;

	private String nome;

	//bi-directional many-to-many association to Curso
	@ManyToMany(mappedBy="disciplinas")
	private List<Curso> cursos;

	public Disciplina() {
	}

	public long getIdDisciplina() {
		return this.idDisciplina;
	}

	public void setIdDisciplina(long idDisciplina) {
		this.idDisciplina = idDisciplina;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Curso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

}