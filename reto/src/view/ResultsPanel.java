/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author robin
 */
public class ResultsPanel extends JPanel {
   
    private JTable      tblResults;
    private JScrollPane jspPane;
    
    public ResultsPanel(){
        initComponents();
    }
    
    private void initComponents(){
        this.tblResults = new JTable();
        this.tblResults.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        
        this.jspPane = new JScrollPane(this.tblResults);
        add(jspPane, BorderLayout.CENTER);
        
        setPreferredSize(new Dimension(200, 800));
    }

    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }

    
    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(JTable tblResults) {
        this.tblResults = tblResults;
    }
}

