package com.modyo.automation.utilidad.Zephyr;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;

public class ObtenerToken {



    // Retorna el valor de la sesion Token para un usuario
    public String RetornaToken_Zephyr (String userName, String pass){

        String node = "";
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            // Send SOAP Message to SOAP Server
            String url = "https://3it.yourzephyr.com/flex/services/soap/zephyrsoapservice-v1?Wsdl";
            SOAPMessage SOAPMESAGE = soapConnection.call(createSOAPRequest_ZephyrToken(userName, pass), url);
            //SOAPMESAGE.writeTo(System.out); //        msg.writeTo(out);
            String usuario = userName.substring(0, 8);
            System.out.println("Usuario Token: " + usuario);

            if (SOAPMESAGE.getSOAPBody() == null) {
                node = "Usuario o contraseña invalilda para zephyr.";
            }else{
                Document doc = SOAPMESAGE.getSOAPBody().extractContentAsDocument();
                doc.getDocumentElement().normalize();

                NodeList listaToken = doc.getElementsByTagName("return");
                Node nodo = listaToken.item(0);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    node = nodo.getTextContent();
                } else {
                    node = "No hay Return";
                    //System.out.println("No hay return");
                }
                soapConnection.close();
            }
        }catch(Exception p){
            node = "No hay Return";
            //System.out.println("Error RequestSoap: " + p.getMessage());
        }
        return node;
    }

    // Creacion de SOAP MESSAGE
    public SOAPMessage createSOAPRequest_ZephyrToken(String name, String Pass) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://soap.service.thed.com/";   // Sería el xmlns Soap=:http://soap.service.thed.com/  ' Encabezado del soap

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("soap", serverURI);
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("login", "soap");
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("username");
        soapBodyElem1.addTextNode(name);  // "cristian.avila"
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("password");
        soapBodyElem2.addTextNode(Pass);  // "Banco001"
        soapMessage.saveChanges();

        /* Print the request message */
        //System.out.print("Request SOAP Message createSOAPRequest: ");
        //soapMessage.writeTo(System.out);
        //System.out.println();

        return soapMessage;
    }


}
