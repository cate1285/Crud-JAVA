/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import access.ClientDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.ClientModel;
import view.AddClient;
import view.ControlsPanel;
import view.DeleteClient;
import view.UpdateClient;

/**
 *
 * @author robin
 */
public class ClickEvent implements ActionListener {
    private ControlsPanel controlsPanel;
    
    /**
     * Constructor of the class
     * @param controlsPanel 
     */
    public ClickEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getBtnSearch()) {
            int codigo_cliente            = ((ClientModel)this.controlsPanel.getCbxClientsList().getSelectedItem()).getCodigo();
            String nombre = (String)this.controlsPanel.getTxtName().getText();
            int sectores    = ((ClientModel)this.controlsPanel.getCbxClientsList().getSelectedItem()).getCodigo();
            String borrar_cliente = ((ClientModel)this.controlsPanel.getCbxClientsList().getSelectedItem()).getNombre();
            String nombre_sector = ((ClientModel)this.controlsPanel.getCbxClientsList().getSelectedItem()).getSectorComercial();
            
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            ClientDAO clientDAO = new ClientDAO();
            ArrayList<ClientModel> clients = clientDAO.getFilteredClients(codigo_cliente,sectores, nombre, borrar_cliente,nombre_sector);
            
            this.controlsPanel.setTblResults(clients);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getCbxClientsList()) {
            int codigo_cliente            = ((ClientModel)this.controlsPanel.getCbxClientsList().getSelectedItem()).getCodigo();
            String nombre = (String)this.controlsPanel.getTxtName().getText();
            int sectores    = ((ClientModel)this.controlsPanel.getCbxClientsList().getSelectedItem()).getCodigo();
            String borrar_cliente = ((ClientModel)this.controlsPanel.getCbxClientsList().getSelectedItem()).getNombre();
            String nombre_sector = ((ClientModel)this.controlsPanel.getCbxClientsList().getSelectedItem()).getSectorComercial();
            
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            ClientDAO clientDAO = new ClientDAO();
            ArrayList<ClientModel> clients = clientDAO.getFilteredClients(codigo_cliente,sectores, nombre, borrar_cliente,nombre_sector);
            
            this.controlsPanel.setTblResults(clients);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getCbxSectorsList()) {
            int codigo_cliente            = ((ClientModel)this.controlsPanel.getCbxSectorsList().getSelectedItem()).getCodigo();
            String nombre = (String)this.controlsPanel.getTxtName().getText();
            int sectores    = ((ClientModel)this.controlsPanel.getCbxSectorsList().getSelectedItem()).getCodigo();
            String borrar_cliente = ((ClientModel)this.controlsPanel.getCbxSectorsList().getSelectedItem()).getNombre();
            String nombre_sector = ((ClientModel)this.controlsPanel.getCbxSectorsList().getSelectedItem()).getSectorComercial();
            
            //System.out.println(idMuseum + " " + idPresentation + " " + datePresentation + " " + artPieceName);
            ClientDAO clientDAO = new ClientDAO();
            ArrayList<ClientModel> clients = clientDAO.getFilteredClients(codigo_cliente,sectores, nombre, borrar_cliente,nombre_sector);
            
            this.controlsPanel.setTblResults(clients);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnAddClient()) {
            AddClient addArtPieceView = new AddClient();
            addArtPieceView.setVisible(true);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnDeleteClient()) {
            DeleteClient deleteClient = new DeleteClient();
            deleteClient.setVisible(true);
        }
        else if(actionEvent.getSource() == this.controlsPanel.getBtnUpdateClient()) {
            UpdateClient updateClient = new UpdateClient();
            updateClient.setVisible(true);
    }   }
    
}
