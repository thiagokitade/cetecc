package br.com.cetecc.curso;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.cetecc.disciplina.Disciplina;

@RepositoryRestResource(collectionResourceRel="cursos",path="/curso")
public interface CursoRepository extends CrudRepository<Disciplina, Long>   {

}
