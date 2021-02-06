package br.prog3.trabalho4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.prog3.trabalho4.domain.Dependente;
import br.prog3.trabalho4.repository.DependenteRepository;

@Service
public class DependenteService {
	@Autowired
	private DependenteRepository dependenteRepository;

	public Dependente save(Dependente dependente) {
		return dependenteRepository.save(dependente);
	}

	public List<Dependente> findAll() {
		return (List<Dependente>) dependenteRepository.findAll();
	}

	public Optional<Dependente> findByCpfEmpregado(String cpfEmpregado) {
		return dependenteRepository.findByCpfEmpregado(cpfEmpregado);
	}

	public Dependente update(Dependente dependente) {
		return dependenteRepository.save(dependente);
	}

	public void deleteByCpfEmpregado(String cpfEmpregado) {
		dependenteRepository.deleteByCpfEmpregado(cpfEmpregado);
	}
}
