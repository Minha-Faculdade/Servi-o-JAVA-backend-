package br.edu.ifms.ClienteCPF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifms.ClienteCPF.model.ClienteCPF;
import br.edu.ifms.ClienteCPF.service.ClienteCPFService;

@RestController
public class ClienteCPFController {

	@Autowired
	private ClienteCPFService clienteCPFService;
	
	@GetMapping("/cliente/{id}/cpf")
	public ResponseEntity<ClienteCPF> buscarClienteComCPF(@PathVariable Long id) {
		
		ClienteCPF clienteCPF = this.clienteCPFService.obterPorIdSincrono(id);

		return ResponseEntity.ok(clienteCPF);
	}

	@GetMapping("/cliente/{id}/cpf/async")
	public ResponseEntity<ClienteCPF> buscarClienteComCPFParalelo(@PathVariable Long id) {
		
		ClienteCPF clienteCPF = this.clienteCPFService.obterPorIdParalelo(id);

		return ResponseEntity.ok(clienteCPF);
	}

	@PostMapping("/cliente")
	public ResponseEntity<ClienteCPF> criarCliente(@RequestBody ClienteCPF cliente) {

		ClienteCPF clienteCPF = this.clienteCPFService.criar(cliente);

		return ResponseEntity.ok(clienteCPF);
	}
}