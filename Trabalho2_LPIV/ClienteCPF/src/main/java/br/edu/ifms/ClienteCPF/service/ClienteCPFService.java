package br.edu.ifms.ClienteCPF.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import br.edu.ifms.ClienteCPF.model.ClienteCPF;
import reactor.core.publisher.Mono;

@Service
public class ClienteCPFService{

	@Autowired
	private WebClient webClientClientes;
	
	@Autowired
	private WebClient webClientCpfs;
	
	public ClienteCPF obterPorIdParalelo(Long idCliente) {

		Mono<ClienteCPF> monoCliente = this.webClientClientes
			.method(HttpMethod.GET)
			.uri("/clientes/{id}", idCliente)
			.retrieve()
			.bodyToMono(ClienteCPF.class);
	
		Mono<ClienteCPF> monoCpf = this.webClientCpfs
				.method(HttpMethod.GET)
				.uri("/cpfs/{id}", idCliente)
				.retrieve()
				.bodyToMono(ClienteCPF.class);

		ClienteCPF clienteCPF = Mono.zip(monoCliente, monoCpf).map(tuple -> {
			tuple.getT1().setCpf(tuple.getT2().getCpf());
			return tuple.getT1();
		}).block();

		return clienteCPF;
	}
	
	public ClienteCPF obterPorIdSincrono(Long idCliente) {

		Mono<ClienteCPF> monoCliente = this.webClientClientes
			.method(HttpMethod.GET)
			.uri("/clientes/{id}", idCliente)
			.retrieve()
			.bodyToMono(ClienteCPF.class);
	
		Mono<ClienteCPF> monoCpf = this.webClientCpfs
				.method(HttpMethod.GET)
				.uri("/cpfs/{id}", idCliente)
				.retrieve()
				.bodyToMono(ClienteCPF.class);
		
		ClienteCPF cliente = monoCliente.block();
		ClienteCPF cpf = monoCpf.block();

		cliente.setCpf(cpf.getCpf());

		return cliente;
	}
	
	public ClienteCPF criar(ClienteCPF clienteCPF ) {

		Mono<ClienteCPF > monoCliente = 
				this.webClientClientes
					.post()
					.uri("/clientes")
					.body(BodyInserters.fromValue(clienteCPF ))
					.retrieve()
					.bodyToMono(ClienteCPF.class);

		return monoCliente.block();
	}
}