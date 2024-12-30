package br.edu.ifms.pais;

import java.net.URL;

import javax.xml.namespace.QName;

import br.edu.ifms.pais.servico.CountryInfoServiceSoapType;
import br.edu.ifms.pais.servico.TCurrency;
import jakarta.xml.ws.Service;

public class App {
	public static void main(String[] args) throws Exception{
		
		URL url = new URL("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL");
		QName qname = new QName("http://www.oorsprong.org/websamples.countryinfo","CountryInfoService");
	
		//service
		Service service = Service.create(url,qname);
		
		
		
		//portType
		CountryInfoServiceSoapType c = service.getPort(CountryInfoServiceSoapType.class);
		
		String a = c.countryISOCode("Brazil");
		System.out.println("Código ISO: " + a);
		
		String b = c.capitalCity("BR");
		System.out.println("Capital: " + b);
		
		String d = c.countryIntPhoneCode("BR");
		System.out.println("Telefone: " + d);
		
		TCurrency tcurrency =  c.countryCurrency("BR");
		System.out.println(tcurrency.getSName());
		System.out.println(tcurrency.getSISOCode());
		
	}
}
