package br.com.cetecc.aluno;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="alunos",path="/aluno")
public interface AlunoRepository extends CrudRepository<Aluno, Long>   {

}
