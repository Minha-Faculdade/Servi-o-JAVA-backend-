package br.edu.ifms.crud;

import br.edu.ifms.crud.servico.NoticiaSEI;
import br.edu.ifms.crud.servico.NoticiaSIB;
import jakarta.xml.ws.Endpoint;


public class App {
    public static void main(String[] args) {
    	NoticiaSEI objetoServico = new NoticiaSIB();
    	Endpoint.publish("http://localhost:8085/servico/noticia", objetoServico);
    	System.out.println("Serviço publicado com sucesso!");
    }
}
