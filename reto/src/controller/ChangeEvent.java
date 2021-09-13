/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.ClientModel;
import access.ClientDAO;
import view.ControlsPanel;

/**
 *
 * @author robin
 */
public class ChangeEvent implements ActionListener {
    private ControlsPanel controlsPanel;
    
    
    public ChangeEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.controlsPanel.getCbxClientsList()) {
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
        
    }
    
}
