package br.com.cetecc.curso;

import java.io.Serializable;
import javax.persistence.*;

import br.com.cetecc.disciplina.Disciplina;
import br.com.cetecc.turma.Turma;

import java.util.List;


/**
 * The persistent class for the curso database table.
 * 
 */
@Entity
public class Curso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_curso")
	private long idCurso;

	private String descricao;

	private String nome;

	//bi-directional many-to-many association to Disciplina
	@ManyToMany(mappedBy="cursos")
	private List<Disciplina> disciplinas;

	//bi-directional many-to-one association to Turma
	
	@ManyToMany
	@JoinTable(
		name="curso_tem_disciplina"
		, joinColumns={
			@JoinColumn(name="id_curso")
			}
		, inverseJoinColumns={
			@JoinColumn(name="id_disciplina")
			}
		)
	private List<Turma> turmas;

	public Curso() {
	}

	public long getIdCurso() {
		return this.idCurso;
	}

	public void setIdCurso(long idCurso) {
		this.idCurso = idCurso;
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

	public List<Disciplina> getDisciplinas() {
		return this.disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setCurso(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setCurso(null);

		return turma;
	}

}