package com.tresit.automation.utilidad.Zephyr;

import com.tresit.automation.utilidad.Herramientas.FechaHoraActual;
import com.tresit.automation.utilidad.Herramientas.Log;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.soap.*;

public class UpdateTestStatus {


    /* executionStatus : 1 passed, 2 failed, 3 wip, 4 blocked, 12 Fail UpdateTestStatus*/

    // Atributos: actualTime, executionDate, executionNotes, executionStatus, id, releaseTestScheduleId
    // Atributos testStepExecutions: key, value
    // Atributos testerId, token

    static String executionNotes = "Nota";
    //static int executionStatus = 1; // Blocked  ID = 12 Fail UpdateTestStatus
    int id = 0;

    static Log log = new Log();
    static FechaHoraActual fec = new FechaHoraActual();

    public String EjecutarUpdate (String token , String releaseTestScheduleId, String testerId, String executionStatus, String carpeta){

        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();
            // Send SOAP Message to SOAP Server
            String url = "https://3it.yourzephyr.com/flex/services/soap/zephyrsoapservice-v1?Wsdl";
            SOAPMessage SOAPMESAGE = soapConnection.call(updateTestStatus(token, releaseTestScheduleId, testerId, executionStatus), url);
            System.out.print("Respuesta: ");
            SOAPMESAGE.writeTo(System.out); //        msg.writeTo(out);

            Document doc = SOAPMESAGE.getSOAPBody().extractContentAsDocument();
            doc.getDocumentElement().normalize();
            System.out.println(" ");

            // Retorna el valor de la ejecución Key, Values
            NodeList listaNodos = doc.getElementsByTagName("return");
            for (int temp = 0; temp < listaNodos.getLength(); temp++) {
                org.w3c.dom.Node nodo = listaNodos.item(temp);
                if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) nodo;
                    log.AgregarLoguerDia("Respuesta: Key " + element.getElementsByTagName("key").item(temp).getTextContent() + ", Value " +  element.getElementsByTagName("value").item(temp).getTextContent(), carpeta);
                    System.out.println("key: " + element.getElementsByTagName("key").item(temp).getTextContent());
                    System.out.println("value: " + element.getElementsByTagName("value").item(temp).getTextContent());
                }
            }
            soapConnection.close();
        }catch(Exception p){
            log.AgregarLoguerDia("Error RequestSoap: " + p.getMessage(), carpeta);
            System.out.println("Error RequestSoap: " + p.getMessage());
        }
        return "Sin Error al parecer.";
    }

    // Creacion de SOAP MESSAGE
    public SOAPMessage updateTestStatus(String token_param, String releaseTestScheduleId, String testerId, String executionStatus) throws Exception {

        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();
        String serverURI = "http://soap.service.thed.com/";
        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("soap", serverURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyUpdate = soapBody.addChildElement("updateTestStatus", "soap");

        SOAPElement soapBodyTestResult = soapBodyUpdate.addChildElement("testResults");
        SOAPElement soapBodyTestTime = soapBodyTestResult.addChildElement("actualTime");
        soapBodyTestTime.addTextNode(fec.getHora().toString().replace(":","")); // Valor Para actualTime
        SOAPElement soapBodyTestExcecution = soapBodyTestResult.addChildElement("executionDate");
        soapBodyTestExcecution.addTextNode(fec.getFecha().toString()); // Valor Para executionDate
        SOAPElement soapBodyExecutionNotes = soapBodyTestResult.addChildElement("executionNotes");
        soapBodyExecutionNotes.addTextNode(executionNotes); // Valor Para executionNotes
        SOAPElement soapBodyExecutionStatus = soapBodyTestResult.addChildElement("executionStatus");
        soapBodyExecutionStatus.addTextNode(String.valueOf(executionStatus)); // Valor Para executionStatus
        SOAPElement soapBodyId = soapBodyTestResult.addChildElement("id");
        soapBodyId.addTextNode(String.valueOf(id)); // Valor Para id
        SOAPElement soapBodyReleaseTestScheduleId = soapBodyTestResult.addChildElement("releaseTestScheduleId");
        soapBodyReleaseTestScheduleId.addTextNode(String.valueOf(releaseTestScheduleId)); // Valor Para releaseTestScheduleId
        SOAPElement soapBodyTestStepExecutions = soapBodyTestResult.addChildElement("testStepExecutions");
        SOAPElement soapBodyTestStepExecutionsKey = soapBodyTestStepExecutions.addChildElement("key");
        soapBodyTestStepExecutionsKey.addTextNode(""); // Valor Para key
        SOAPElement soapBodyTestStepExecutionsValue = soapBodyTestStepExecutions.addChildElement("value");
        soapBodyTestStepExecutionsValue.addTextNode(""); // Valor Para value
        SOAPElement soapBodyTesterId = soapBodyTestResult.addChildElement("testerId");
        soapBodyTesterId.addTextNode(String.valueOf(testerId)); // Valor Para testerId

        SOAPElement soapBodyToken = soapBodyUpdate.addChildElement("token");
        soapBodyToken.addTextNode(token_param); // Valor Para Token
        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("SOAP updateTestStatus: ");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }






}
