/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.ClientModel;

/**
 *
 * @author robin
 */
public class ControlsPanel extends JPanel {
    
    private JLabel                       lblClients;
    private JComboBox<ClientModel>       cbxClientsList;
    private JLabel                       lblSectors;
    private JComboBox<ClientModel>       cbxSectorsList;
    private JLabel                       lblProjects;
    private JLabel                       lblName;
    private JTextField                   txtName;
    private JButton                      btnSearch;
    private JButton                      btnAddClient;
    private JButton                      btnUpdateClient;
    private JButton                      btnDeleteClient;
    private JTable                       tblResults;
    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }
    /**
     * 
     */
    private void initComponents(){
        setLayout(new GridLayout(2,2));
        InitialData initialData = new InitialData();
        
        // Complete ArtPieces info
        this.setTblResults(initialData.getClients());
        
        // Museum selection     
        this.cbxClientsList = new JComboBox();
        this.cbxClientsList.setModel(new DefaultComboBoxModel<>(initialData.getClientp().toArray(new ClientModel[initialData.getClientp().size()])));
        this.cbxClientsList.setSelectedIndex(0);
        add(this.getCbxClientsList());
        
        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxClientsList().addActionListener(changeEvent);
        
        
        // Exhibition selection
        
        
        
        // Name patttern 
               
        this.lblName = new JLabel("      Nombre cliente");
        add(this.getLblName());
        
        this.txtName = new JTextField();
        add(this.getTxtName());
        
        
        // Search button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);
        
        this.setTblResults(initialData.getClients());
        
        // Museum selection     
        this.cbxSectorsList = new JComboBox();
        this.getCbxSectorsList().setModel(new DefaultComboBoxModel<>(initialData.getSectors().toArray(new ClientModel[initialData.getSectors().size()])));
        this.getCbxSectorsList().setSelectedIndex(0);
        add(this.getCbxSectorsList());
        
        ChangeEvent changeEven = new ChangeEvent(this);
        this.getCbxSectorsList().addActionListener(changeEven);
        
        
        
        // Insert  button
        this.btnAddClient = new JButton("Agregar Nuevo Cliente");
        add(this.getBtnAddClient());
        this.getBtnAddClient().addActionListener(clickEvent);
        
        this.btnDeleteClient = new JButton("Borrar Cliente");
        add(this.getBtnDeleteClient());
        this.getBtnDeleteClient().addActionListener(clickEvent);
        
        this.btnUpdateClient = new JButton("Actualizar Cliente");
        add(this.getBtnUpdateClient());
        this.getBtnUpdateClient().addActionListener(clickEvent);
    }

    /**
     * @return the lblClients
     */
    public JLabel getLblClients() {
        return lblClients;
    }

    /**
     * @return the cbxClientsList
     */
    public JComboBox getCbxClientsList() {
        return cbxClientsList;
    }

    /**
     * @return the lblPresentations
     */
    public JLabel getLblProjects() {
        return lblProjects;
    }

    

    /**
     * @return the lblName
     */
    public JLabel getLblName() {
        return lblName;
    }

    /**
     * @return the txtName
     */
    public JTextField getTxtName() {
        return txtName;
    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    /**
     * @param presentations
     */
    public void setCbxClientsList(ArrayList<ClientModel> clients) {
        this.cbxClientsList.setModel(new DefaultComboBoxModel<>(clients.toArray(new ClientModel[clients.size()])));
        this.getCbxClientsList().setSelectedIndex(0);
    }

    /**
     * @param artPieces
     */
    public void setTblResults(ArrayList<ClientModel> clients) {
        String[] headers = {"Cliente id","Nombre","Nit", "Representante Legal", "Sector Comercial"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers); 
        this.tblResults.setModel(tableModel);
        for(int i=0; i<clients.size(); i++){
            tableModel.addRow(clients.get(i).toArray() );
        }
    }

    /**
     * @return the btnAddArtPiece
     */
    public JButton getBtnAddClient() {
        return btnAddClient;
    }
    
    public JButton getBtnDeleteClient() {
        return btnDeleteClient;
    }
    
    public JButton getBtnUpdateClient() {
        return btnUpdateClient;
    }

    /**
     * @return the lblSectors
     */
    public JLabel getLblSectors() {
        return lblSectors;
    }

    /**
     * @return the cbxSectorsList
     */
    public JComboBox<ClientModel> getCbxSectorsList() {
        return cbxSectorsList;
    }

 

    
}
