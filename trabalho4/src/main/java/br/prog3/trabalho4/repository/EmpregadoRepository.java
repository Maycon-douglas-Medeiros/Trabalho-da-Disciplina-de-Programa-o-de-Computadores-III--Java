package br.prog3.trabalho4.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.prog3.trabalho4.domain.Empregado;

@Repository
public interface EmpregadoRepository extends JpaRepository<Empregado, String>{
	List<Empregado> findByEmpregado(Empregado empregado);
}
