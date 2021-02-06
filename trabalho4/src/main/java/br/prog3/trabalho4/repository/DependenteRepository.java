package br.prog3.trabalho4.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import br.prog3.trabalho4.domain.Dependente;

@Repository
public interface DependenteRepository extends CrudRepository<Dependente, String>{

}
