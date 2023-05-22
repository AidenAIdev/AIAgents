/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mensajes;

import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EnviarMensajes {

    public static void enviarMensajes(int tipoMSJ,
            String receptor, Agent emisor, String codigoID,
            boolean isContent, String contenido, Serializable contenidoObject) {

        ACLMessage acl = new ACLMessage(tipoMSJ);
        AID aid = new AID();
        aid.setLocalName(receptor);
        acl.addReceiver(aid);
        acl.setSender(emisor.getAID());
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setConversationId(codigoID);
        if (isContent) {
            acl.setContent(contenido);
        } else {
            try {
                acl.setContentObject(contenidoObject);
            } catch (IOException ex) {
                Logger.getLogger(EnviarMensajes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        emisor.send(acl);
    }
    public static void enviarMensajeString(int tipoMsj, String receptor,
                                           Agent agenteEmisor, String contenido, String conversationID) {
        ACLMessage acl = new ACLMessage(tipoMsj);
        AID id = new AID();
        id.setLocalName(receptor);
        acl.addReceiver(id);
        acl.setSender(agenteEmisor.getAID());
//                    acl.setEncoding("utf8mb4");
        acl.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
        acl.setContent(contenido);
        acl.setConversationId(conversationID);
        agenteEmisor.send(acl);
    }
}
