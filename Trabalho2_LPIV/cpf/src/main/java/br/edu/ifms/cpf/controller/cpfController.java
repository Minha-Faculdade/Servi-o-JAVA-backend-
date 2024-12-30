package br.edu.ifms.cpf.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.cpf.model.Cpf;

@RestController
@RequestMapping("/cpfs")
public class cpfController {

	@GetMapping("/{id}")
	public ResponseEntity<Cpf> buscarClienteCPF(@PathVariable Long id) throws Exception {

		Cpf cpf= new Cpf(id, "", "123.456.789-00");
		
		Thread.sleep(3000);

		return ResponseEntity.ok(cpf);
	}
	
	@PostMapping
	public ResponseEntity<Cpf> criar(@RequestBody Cpf cpf) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(cpf);
	}
	
}
