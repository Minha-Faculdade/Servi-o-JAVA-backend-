package br.edu.ifms.crud.servico;


import java.util.List;

import br.edu.ifms.crud.modelo.Noticia;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;
import jakarta.jws.soap.SOAPBinding;
import jakarta.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding (style = Style.DOCUMENT)
public interface NoticiaSEI {
	
	@WebMethod
	public long adicionar(Noticia noticia);
	
	@WebMethod
	public Noticia alterar(Noticia noticia);
	
	@WebMethod
	public boolean apagar(long id);
	
	@WebMethod
	public List<Noticia> listar();
	
	@WebMethod
	public Noticia ler(long id);
}

