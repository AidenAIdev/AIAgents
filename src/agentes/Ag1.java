/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agentes;

import Mensajes.EnviarMensajes;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.wrapper.AgentController;
import modelo.Cliente;
import modelo.arregloCliente;
import jade.core.behaviours.OneShotBehaviour;

/**
 *
 * @author LabP351
 */
public class Ag1 extends Agent{

    private Object agentInfo;

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }
    class CloneAgentBehaviour extends OneShotBehaviour {
        @Override
        public void action() {
            // Crear nuevo agente
            Ag1 newAgent = new Ag1();
            newAgent.agentInfo = agentInfo;
            try {
                getContainerController().acceptNewAgent(getLocalName() + "_clon", newAgent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void takeDown() {

        System.out.println("Agente clonado");
        super.takeDown();

        // Realizar las operaciones necesarias antes de eliminar el agente
        // ...

        try {
            // Clonar el agente actual
            super.takeDown();

            // Realizar las operaciones necesarias antes de eliminar el agente
            // ...

            // Clonar el agente actual creando un nuevo agente y copiando la información
            addBehaviour(new CloneAgentBehaviour());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            System.out.println(getName());
            Cliente cliente1 = new Cliente("Juan", "Perez", "12345678", "3243545353");
            Cliente cliente2 = new Cliente("Pedro", "Perez", "12345678", "3243545353");
            Cliente cliente3 = new Cliente("Maria", "Perez", "12345678", "3243545353");
            Cliente cliente4 = new Cliente("Jose", "Perez", "12345678", "3243545353");
            arregloCliente aC = new arregloCliente();
            aC.addCliente(cliente1, 0);
            aC.addCliente(cliente2, 1);
            aC.addCliente(cliente3, 2);
            aC.addCliente(cliente4, 3);
            EnviarMensajes.enviarMensajes(
                    ACLMessage.REQUEST, 
                    "Agente2", 
                    getAgent(), 
                    "COD001-002", 
                    false, 
                    "Hola Agente, son "+getName(), 
                    aC);
            ACLMessage acl =  blockingReceive();
            System.out.println(acl);
            //blockingReceive(5000);

            doDelete();
        }
        
    }
    
}
