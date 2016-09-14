package br.com.cetecc.funcionario;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel="funcionarios",path="/funcionario")
public interface FuncionarioRepository extends CrudRepository<Funcionario, Long>   {

}
