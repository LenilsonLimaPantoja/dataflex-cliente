package com.lenilsontsi.dataflexcliente;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

import com.lenilsontsi.dataflexcliente.servico.CountryInfoServiceSoapType;

import jakarta.xml.ws.Service;

/**
 * Hello world!
 */
public class App {
	public static void main(String[] args) throws MalformedURLException {
		URL url = new URL("http://webservices.oorsprong.org/websamples.countryinfo/CountryInfoService.wso?WSDL");
		QName qname = new QName("http://www.oorsprong.org/websamples.countryinfo", "CountryInfoService");

		// Criar instância do serviço
        Service service = Service.create(url, qname);
        CountryInfoServiceSoapType countryService = service.getPort(CountryInfoServiceSoapType.class);
        
        // Obter o código ISO do Brasil
        String isoCode = countryService.countryISOCode("Brazil");
        
     // Obter informações sobre o Brasil com base no código ISO
        var countryInfo = countryService.fullCountryInfo(isoCode);
        System.out.println("Nome: " + countryInfo.getSName());
        System.out.println("Código ISO: " + countryInfo.getSISOCode());
        System.out.println("Capital: " + countryInfo.getSCapitalCity());
        System.out.println("Telefone: " + countryInfo.getSPhoneCode());
        System.out.println("Continete: " + countryInfo.getSContinentCode());
        System.out.println("Moeda: " + countryInfo.getSCurrencyISOCode());
	}
}
