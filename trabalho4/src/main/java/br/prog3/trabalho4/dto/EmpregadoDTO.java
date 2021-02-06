package br.prog3.trabalho4.dto;

import java.util.List;

import br.prog3.trabalho4.domain.Dependente;
import br.prog3.trabalho4.domain.Empregado;

public class EmpregadoDTO {
	private String cpf;
	private String nome;
	private Integer idade;
	private Double salario;
	private List<Dependente> dependentes;
	
	public EmpregadoDTO(Empregado empregado) {
		this.cpf = empregado.getCpf();
		this.nome = empregado.getNome();
		this.idade = empregado.getIdade();
		this.salario = empregado.getSalario();
		this.dependentes = empregado.getDependentes();
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public List<Dependente> getDependentes() {
		return dependentes;
	}

	public void setDependentes(List<Dependente> dependentes) {
		this.dependentes = dependentes;
	}
	
}
