package br.prog3.trabalho4.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Dependente{
	
	@Id
	private String cpfEmpregado;
	private String nome;
	private String grauParentesco;
	private Integer dataNascimento;

	public Dependente() {
	}
	
	@ManyToOne
	@JoinColumn(name = "cpf")
	private Empregado empregado;

	public String getCpfEmpregado() {
		return cpfEmpregado;
	}

	public void setCpfEmpregado(String cpfEmpregado) {
		this.cpfEmpregado = cpfEmpregado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public Integer getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Integer dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Empregado getEmpregado() {
		return empregado;
	}

	public void setEmpregado(Empregado empregado) {
		this.empregado = empregado;
	}
}