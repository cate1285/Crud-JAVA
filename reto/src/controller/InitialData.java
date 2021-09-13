/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import java.util.ArrayList;
import access.ClientDAO;
import model.ClientModel;

/**
 *
 * @author robin
 */
public class InitialData {
    private ArrayList<ClientModel>       clients       = null;
    private ArrayList<ClientModel>       clientp       = null;
    private ArrayList<ClientModel>       Sectors       = null;
    
    /**
     * Zero-parameters constructor
     */
    public InitialData(){
        ClientDAO clientDAO = new ClientDAO();
        this.clients = clientDAO.getAllClients();
        
        
        ClientDAO client = new ClientDAO();
        this.clientp = client.getAllClient();
        this.clientp.add(0, new ClientModel(-1, "Todos los Clientes "));
        
        ClientDAO Sectors1 = new ClientDAO();
        this.Sectors = Sectors1.getAllSectors();
        this.Sectors.add(0, new ClientModel(-1, "Todos los Sectores"));
        
       
    }

    /**
     * @return the clients
     */
    public ArrayList<ClientModel> getClients() {
        return clients;
    }



    /**
     * @return the clientp
     */
    public ArrayList<ClientModel> getClientp() {
        return clientp;
    }

    /**
     * @return the Sectors
     */
    public ArrayList<ClientModel> getSectors() {
        return Sectors;
    }
    
    
 
    
}
