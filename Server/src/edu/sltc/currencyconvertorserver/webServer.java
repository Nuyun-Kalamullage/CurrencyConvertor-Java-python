package edu.sltc.currencyconvertorserver;
/**
 * @author Nuyun-Kalamullage
 * @date 22-12-2022
 * @file_name WebServer
 * @project_Name Server
 */

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public class webServer {
    @WebMethod
    public double convert(String sourceCurrency, String targetCurrency, double amountInSourceCurrency){ // this is the method that client resetting to the server.
        currencyRate tempRate = new currencyRate(sourceCurrency,targetCurrency);
        double result = tempRate.convert(amountInSourceCurrency);
        System.out.println("Sending "+result+".\n");
        return result; //return the calculated amount.
    }
    public static void main(String[] args){
        Endpoint.publish("http://localhost:8888/SoapWebService", new webServer()); //Hosting the wsdl file in given url.
    }
}
