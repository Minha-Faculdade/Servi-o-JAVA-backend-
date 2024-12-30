package br.edu.ifms.cliente.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.cliente.model.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Long id) throws Exception {

		Cliente cliente = new Cliente(id, "Geraldinha", "");
		
		Thread.sleep(3000);

		return ResponseEntity.ok(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criar(@RequestBody Cliente cliente) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
	}
	
}
