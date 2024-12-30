package br.edu.ifms.veiculo;


import br.edu.ifms.veiculo.servico.VeiculoSIB;
import jakarta.xml.ws.Endpoint;

public class App 
{
    public static void main( String[] args ) {
    	String porta = "8088";
        System.out.println( "Publicando o serviço da porta: " + porta);
        Endpoint.publish("http://localhost:"+porta+"/veiculos", new VeiculoSIB());
        System.out.println("Serviço publicado na porta:" +porta);
    }
}
