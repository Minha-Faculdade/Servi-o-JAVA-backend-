package br.edu.ifms.veiculo.servico;


import java.util.List;

import br.edu.ifms.veiculo.modelo.Veiculo;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding (style = Style.DOCUMENT)
public interface VeiculoSEI {
	
	@WebMethod
	public long adicionar(Veiculo veiculo);
	
	@WebMethod
	public Veiculo alterar(Veiculo veiculo);
	
	@WebMethod
	public boolean apagar(long id);
	
	@WebMethod
	public List<Veiculo> listar();
	
	@WebMethod
	public Veiculo ler(long id);
}

