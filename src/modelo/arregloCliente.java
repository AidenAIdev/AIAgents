
package modelo;

import java.io.Serializable;

public class arregloCliente implements Serializable{
    Cliente [] clientes = new Cliente[4];

    public arregloCliente() {
    }
    
    public void addCliente(Cliente cliente, int i){
        clientes[i] = cliente;
    }

    @Override
    public String toString() {
        String cls = "";
        for (Cliente cliente : clientes) {
            cls += cliente + " \n";
        }
        return cls;
    }
    
    
    
}
