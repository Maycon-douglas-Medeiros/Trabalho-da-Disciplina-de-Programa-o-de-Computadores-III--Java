package br.prog3.trabalho4.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.prog3.trabalho4.domain.Dependente;


@RestController
@RequestMapping("/api/v1/dependentes")
public class DependenteResource {
	@Autowired
	private DependenteService dependenteService;
	
	@GetMapping
	public ResponseEntity<List<Dependente>> findAll() {
		List<Dependente> dependentes = dependenteService.findAll();
		if (dependentes == null || dependentes.isEmpty()) {
			return new ResponseEntity<List<Dependente>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Dependente>>(dependente, HttpStatus.OK);
	}
	
	@PostMapping
	public Dependente create(@RequestBody Dependente dependente) {
		return dependenteService.save(dependente);
	}
	
	@GetMapping(path = { "/{cpfEmpregado}" })
	public ResponseEntity<?> findByCpfEmpregado(@PathVariable String cpfEmpregado) {
		return dependenteService.findByCpfEmpregado(cpfEmpregado).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/{cpfEmpregado}")
	public ResponseEntity<Dependente> update(@PathVariable("cpf") String cpf, @RequestBody Dependente dependente) {
		return dependenteService.findByCpfEmpregado(cpfEmpregado).map(record -> {
			record.setCpfEmpregado(dependente.getCpfEmpregado());
			record.setNome(dependente.getNome());
			record.setGrauParentesco(dependente.getGrauParentesco());
			record.setDataNascimento(dependente.getDataNascimento());
			record.setEmpregado(empregado.getEmpregado());
			Dependente updated = dependenteService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = { "/{cpfEmpregado}" })
	public ResponseEntity<?> delete(@PathVariable String cpfEmpregado) {
		return dependenteService.findById(cpfEmpregado).map(record -> {
			dependenteService.deleteByCpfEmpregado(cpfEmpregado);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
}
