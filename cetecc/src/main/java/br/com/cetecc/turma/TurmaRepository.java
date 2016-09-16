package br.com.cetecc.turma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.cetecc.disciplina.Disciplina;

@RepositoryRestResource(collectionResourceRel="turmas",path="/turma")
public interface TurmaRepository extends CrudRepository<Disciplina, Long>   {

}
