/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenedor;

import agentes.Ag1;
import agentes.Ag2;
import agentes.Ag3;
import agentes.Ag4;
import jade.core.Profile;
import jade.core.ProfileImpl;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LabP351
 */
public class Contenedor {

    AgentContainer contenedorAgentes;

    public void crearContenedor() {
        jade.core.Runtime runtime = jade.core.Runtime.instance();

        Profile profile = new ProfileImpl(null,
                1099, null);
        contenedorAgentes = runtime.createMainContainer(profile);
        iniciarAgentes();
    }

    private void iniciarAgentes() {
        try {
            contenedorAgentes.createNewAgent("Agente2",
                    Ag2.class.getName(), null).start();
            contenedorAgentes.createNewAgent("Agente1",
                    Ag1.class.getName(), null).start();
            contenedorAgentes.createNewAgent("Agente3",
                    Ag3.class.getName(), null).start();
            contenedorAgentes.createNewAgent("Agente4",
                    Ag4.class.getName(), null).start();

        } catch (StaleProxyException ex) {
            Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
