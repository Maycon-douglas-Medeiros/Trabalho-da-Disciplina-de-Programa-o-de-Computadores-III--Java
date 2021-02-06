package br.prog3.trabalho4.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.prog3.trabalho4.repository.EmpregadoRepository;

@Service
public class EmpregadoService {
	@Autowired
	private EmpregadoRepository empregadoRepository;
	
	public Empregado save(Empregado empregado) {
		return empregadoRepository.save(empregado);
	}
	
	public List<EmpregadoDTO> findAll() {
		return empregadoRepository.findAll().stream().map(empregado -> new EmpregadoDTO(empregado)).collect(Collectors.toList());
	}
	
	public Optional<Empregado> findByCpf(String cpf) {
		return empregadoRepository.findByCpf(cpf);
	}
	
	public Empregado update(Empregado empregado) {
		return empregadoRepository.save(empregado);
	}
	
	public void deleteById(String cpf) {
		empregadoRepository.deleteByCpf(cpf);
	}
	
	public List<Empregado> findByDependente(Dependente dependente) {
		return (List<Empregado>) empregadoRepository.findByDependente(dependente);
	}
}
