package com.modyo.automation.utilidad.Zephyr;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;

public class getUsersByCriteria {

    String searchName = "";
    String searchOperation = "";
    String returnAllDataFlag = "true";
    //String searchValue = "cristian";

    String TesterID = ""; // Variable de retorno

    // Atributos: searchName, searchOperation, searchValue, returnAllDataFlag, token (Externo)
    // Creacion de SOAP MESSAGE
    public SOAPMessage getUsersByCriteria(String token, String searchValue) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        String serverURI = "http://soap.service.thed.com/";
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("soap", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyGet = soapBody.addChildElement("getUsersByCriteria", "soap");

        SOAPElement soapBodySearch = soapBodyGet.addChildElement("searchCriterias");
        SOAPElement soapBodySearchName = soapBodySearch.addChildElement("searchName");
        soapBodySearchName.addTextNode(searchName.toString()); // Valor Para SearchName
        SOAPElement soapBodySearchOperation = soapBodySearch.addChildElement("searchOperation");
        soapBodySearchOperation.addTextNode(searchOperation); // Valor Para SearchName
        SOAPElement soapBodySearchValue = soapBodySearch.addChildElement("searchValue");
        soapBodySearchValue.addTextNode(searchValue); // Valor Para SearchValue
        SOAPElement soapBodyReturnDataFlag = soapBodyGet.addChildElement("returnAllDataFlag");
        soapBodyReturnDataFlag.addTextNode(returnAllDataFlag); // Valor Para returnAllDataFlag
        SOAPElement soapBodyToken = soapBodyGet.addChildElement("token");
        soapBodyToken.addTextNode(token); // Valor Para Token
        soapMessage.saveChanges();

        /* Print the request message */
        //System.out.print("SOAP getUsersByCriteria: ");
        //soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public String EjecutarGetUsersByCriteria (String token, String searchValue){

        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            // Send SOAP Message to SOAP Server
            String url = "https://3it.yourzephyr.com/flex/services/soap/zephyrsoapservice-v1?Wsdl";
            SOAPMessage SOAPMESAGE = soapConnection.call(getUsersByCriteria(token, searchValue), url);
            //System.out.print("Respuesta: ");
            //SOAPMESAGE.writeTo(System.out); //  msg.writeTo(out);

            Document doc = SOAPMESAGE.getSOAPBody().extractContentAsDocument();
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("return");

            //System.out.println("Cantidad de returns: " + list.getLength());

            for (int i = 0; i < list.getLength(); i++) {   // Por cada Retur

                for(int x= 0; x<list.item(i).getChildNodes().getLength(); x++) {  // Por cada hijo del return
                    // Obtiene los valores de cada child dentro del return
                    //System.out.println("Indice i: " + i + ", indice X: " + x + list.item(i).getChildNodes().item(x).toString() + " " + list.item(i).getChildNodes().item(x).getTextContent());

                    if (list.item(i).getChildNodes().item(x).getTextContent().contains(searchValue)){
                        //System.out.println(list.item(i).getChildNodes().item(0).getTextContent());
                        TesterID = list.item(i).getChildNodes().item(0).getTextContent();
                    }
                }
            }

            soapConnection.close();
        }catch(Exception p){
            System.out.println("Error RequestSoap: " + p.getMessage());
        }
        return TesterID;
    }


}
