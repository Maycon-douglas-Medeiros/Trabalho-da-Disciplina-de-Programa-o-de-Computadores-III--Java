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

import br.prog3.trabalho4.domain.Empregado;
import br.prog3.trabalho4.dto.EmpregadoDTO;

@RestController
@RequestMapping("/api/v1/empregados")
public class EmpregadoResource {
	@Autowired
	private EmpregadoService empregadoService;
	
	@PostMapping
	public Empregado save(@RequestBody Empregado empregado) {
		return empregadoService.save(empregado);
	}
	
	@GetMapping
	public ResponseEntity<List<EmpregadoDTO>> findAll() {
		List<EmpregadoDTO> empregados = empregadoService.findAll();
		if (empregados == null || empregados.isEmpty()) {
			return new ResponseEntity<List<EmpregadoDTO>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmpregadoDTO>>(empregados, HttpStatus.OK);
	}
	
	@GetMapping(path = { "/{cpf}" })
	public ResponseEntity<?> findByCpf(@PathVariable String cpf) {
		return empregadoService.findByCpf(cpf).map(record -> ResponseEntity.ok().body(record))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@PutMapping(value = "/{cpf}")
	public ResponseEntity<Empregado> update(@PathVariable("cpf") String cpf, @RequestBody Empregado empregado) {
		return empregadoService.findByCpf(cpf).map(record -> {
			record.setCpf(empregado.getCpf());
			record.setNome(empregado.getNome());
			record.setIdade(empregado.getIdade());
			record.setSalario(empregado.getSalario());
			record.setDependentes(empregado.getDependentes());
			Empregado updated = empregadoService.save(record);
			return ResponseEntity.ok().body(updated);
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@DeleteMapping(path = { "/{cpf}" })
	public ResponseEntity<?> delete(@PathVariable String cpf) {
		return empregadoService.findByCpf(cpf).map(record -> {
			empregadoService.deleteByCpf(cpf);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping(path = { "empregado/{empregado}" })
	public ResponseEntity<?> findByDependente(@PathVariable("empregado") Empregado empregado) {
		List<Empregado> empregados = empregadoService.findByEmpregado(empregado);
		return empregados.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(empregados);
	}
}
