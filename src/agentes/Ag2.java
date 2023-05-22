/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import Mensajes.EnviarMensajes;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Cliente;
import modelo.arregloCliente;

/**
 *
 * @author LabP351
 */
public class Ag2 extends Agent {

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {

    }

    class Comportamiento extends Behaviour {

        boolean finalizacion = false;

        @Override
        public void action() {
            System.out.println(getName());
            ACLMessage acl = blockingReceive();
            String idC = acl.getConversationId();
            if (idC.equalsIgnoreCase("COD001-002")) {
                System.out.println(acl);
                try {
                    arregloCliente cl = (arregloCliente)acl.getContentObject();
                    System.out.println(cl);
                    EnviarMensajes.enviarMensajes(
                            ACLMessage.REQUEST,
                            "Agente1",
                            getAgent(),
                            "COD002-001",
                            true,
                            "Hola Agente, son " + getName(),
                            null);
                } catch (UnreadableException ex) {
                    Logger.getLogger(Ag2.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (idC.equalsIgnoreCase("COD004-002")) {
                    EnviarMensajes.enviarMensajes(
                    ACLMessage.REQUEST,
                    "Agente4",
                    getAgent(),
                    "COD002-004",
                    true,
                    "Hola Agente, son " + getName(),
                    null);
                } else {
                    System.out.println(acl);
                }
            }
            
            
            finalizacion = false;
        }

        @Override
        public boolean done() {
            return finalizacion;
        }

    }

}
