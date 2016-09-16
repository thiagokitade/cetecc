package br.com.cetecc.disciplina;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="disciplinas",path="/disciplina")
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long>   {

}

