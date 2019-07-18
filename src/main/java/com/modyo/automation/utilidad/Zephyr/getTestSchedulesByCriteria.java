package com.modyo.automation.utilidad.Zephyr;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;

public class getTestSchedulesByCriteria {

    String searchName = "";
    String searchOperation = "";
    String returnAllDataFlag = "true";
    //String searchValue = "118";    // Es el id del caso de prueba

    String releaseTestScheduleId = ""; // Variable de retorno

    // Atributos: searchName, searchOperation, searchValue, returnAllDataFlag, token (Externo)
    // Creacion de SOAP MESSAGE
    public SOAPMessage getTesteSchudleByCriteria(String token, String searchValue) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        String serverURI = "http://soap.service.thed.com/";
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("soap", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyGet = soapBody.addChildElement("getTestSchedulesByCriteria", "soap");
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
        //System.out.print("SOAP getTesteSchudleByCriteria: ");
        //soapMessage.writeTo(System.out);

        return soapMessage;
    }

    public String EjecutarGetTesteSchudleByCriteria (String token, String searchValue){

        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            // Send SOAP Message to SOAP Server
            String url = "https://3it.yourzephyr.com/flex/services/soap/zephyrsoapservice-v1?Wsdl";
            SOAPMessage SOAPMESAGE = soapConnection.call(getTesteSchudleByCriteria(token, searchValue), url);
            //System.out.print("Respuesta: ");
            //SOAPMESAGE.writeTo(System.out); //  msg.writeTo(out);

            Document doc = SOAPMESAGE.getSOAPBody().extractContentAsDocument();
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("return");

            //System.out.println("Cantidad de returns: " + list.getLength());
            for (int i = 0; i < list.getLength(); i++) {   // Por cada Retur

                for(int x= 0; x<list.item(i).getChildNodes().getLength(); x++){  // Por cada hijo del return
                    // System.out.println(list.item(i).getChildNodes().item(x)); // Obtiene los valores de cada child dentro del return

                    // Si corresponde al usuario que se logueo
                    if(list.item(i).getChildNodes().item(x).toString().contains("remoteTestcaseId") && list.item(i).getChildNodes().item(x).getTextContent().equals(searchValue) ) {

                        //System.out.println("searchValue: " + list.item(i).getChildNodes().item(x).getTextContent());

                        if(list.item(i).getChildNodes().item(x+2).toString().contains("lastTestResult")){  // Se adelanta la posicón del objeto x

                            NodeList list_2 = list.item(i).getChildNodes().item(x+2).getChildNodes();

                            for(int p= 0; p < list_2.getLength(); p++) {  // Por cada hijo del LastTestReturn
                                if(list_2.item(p).getChildNodes().toString().contains("releaseTestScheduleId")){
                                    //list.item(i).getChildNodes().item(x).toString().contains("remoteTestcaseId")
                                    //System.out.println("releaseTestScheduleId: " + list_2.item(p).getTextContent());
                                    releaseTestScheduleId = list_2.item(p).getTextContent();
                                }
                                if(list_2.item(p).getChildNodes().toString().contains("testerId")){
                                    //list.item(i).getChildNodes().item(x).toString().contains("remoteTestcaseId")
                                    //System.out.println("releaseTestScheduleId: " + list_2.item(p).getTextContent());
                                    releaseTestScheduleId = releaseTestScheduleId + "," +  list_2.item(p).getTextContent();
                                }

                            }
                        }
                    }
                }
            }

            soapConnection.close();
        }catch(Exception p){
            System.out.println("Error RequestSoap: " + p.getMessage());
        }
        return releaseTestScheduleId;
    }




}
