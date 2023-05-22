/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import Mensajes.EnviarMensajes;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

/**
 *
 * @author LabP351
 */
public class Ag4 extends Agent{

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }

    @Override
    protected void takeDown() {
        System.out.println("NOoooooooooooooooooooooo");
    }
   
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            System.out.println(getName()); 
            EnviarMensajes.enviarMensajes(
                    ACLMessage.REQUEST, 
                    "Agente2", 
                    getAgent(), 
                    "COD004-002", 
                    true, 
                    "Hola Agente, son "+getName(), 
                    null);
            ACLMessage acl =  blockingReceive();
            System.out.println(acl);
            //blockingReceive(5000);
            //doDelete();
        }
        
    }
    
}
