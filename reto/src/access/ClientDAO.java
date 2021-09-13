/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import java.util.ArrayList;
import model.ClientModel;
import utils.ConnectionDB;

/**
 *
 * @author robin
 */
public class ClientDAO {
   
    private Connection conn = null;
    public ArrayList<ClientModel> getAllClients() {
        ArrayList<ClientModel> clients = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT cliente.codigo,cliente.nombre,cliente.nit, cliente.representante_legal, cliente.sector_comercial\n"+
                         "FROM cliente ;";
                         
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                ClientModel client = new ClientModel(result.getInt(1), result.getString(2),result.getString(3),result.getString(4),result.getString(5));
                clients.add( client );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return clients;
    } 
    /**
     * 
     * @param nombre
     * @return 
     */
    public ArrayList<ClientModel> getAllClient() {
        ArrayList<ClientModel> client = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT cliente.codigo,cliente.nombre\n"+
                         "FROM cliente ;";
                         
                         
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                ClientModel client1 = new ClientModel(result.getInt(1), result.getString(2));
                client.add( client1 );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return client;
    } 
    
    public ArrayList<ClientModel> getAllSectors() {
        ArrayList<ClientModel> sector = new ArrayList();
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT cliente.codigo,cliente.sector_comercial\n"+
                         "FROM cliente ;";
                         
                         
            Statement statement = conn.createStatement();
            ResultSet result    = statement.executeQuery(sql);
            
            while (result.next()) {
                ClientModel sector1 = new ClientModel(result.getInt(1), result.getString(2));
                sector.add( sector1 );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return sector;
    }
    
    public ClientModel getClient(String nombre) {
        ClientModel client = null;
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT nombre FROM cliente WHERE nombre=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(2, nombre);
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                client = new ClientModel(result.getInt(1), result.getInt(2),result.getString(3),result.getString(4),result.getInt(5),result.getString(6));
                break;
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return client;
    }

    
    /**
     * 
     * @param client 
     */
    public void insertClient(ClientModel client){
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "INSERT INTO cliente(codigo, nombre, nit, representante_legal, sector_comercial) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, client.getCodigo());
            statement.setString(2, client.getNombre());
            statement.setString(3, client.getNit());
            statement.setString(4, client.getRepresentanteLegal());
            statement.setString(5, client.getSectorComercial());
            
            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue agregado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
    /**
     * 
     * @param client
     */
    public void updateExhibition(ClientModel client) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE CLIENTE SET nombre =? WHERE nit =?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, client.getNombre());
            statement.setString(2, client.getNit());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    public  ArrayList<ClientModel> getFilteredClients(int codigo_cliente,int sectores,String nombre,String borrar_cliente,String nombre_sector) {
        ArrayList<ClientModel> clients = new ArrayList();
        int case_ = -1;
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "SELECT cliente.codigo,cliente.nombre,cliente.nit, cliente.representante_legal, cliente.sector_comercial\n"+
                         "FROM cliente \n"+
                         "WHERE cliente.nombre LIKE ?";
            if(codigo_cliente != -1){
                if(sectores != -1){
                    sql += " AND cliente.codigo=?;";
                    case_ = 1;
                }else{
                    sql += " AND  cliente.codigo=?;";
                    case_ = 2;
                }
                
            }
            else if(sectores != -1){
                    sql += " AND cliente.sector_comercial=?;";
                    case_ = 3;
            }
            System.out.println(case_);            
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(sql);            
            statement.setString(1, "%"+nombre+"%");
            switch(case_){
                case 1:     statement.setInt(2, codigo_cliente);    break;
                case 2:     statement.setInt(2, codigo_cliente);    break;
                case 3:     statement.setInt(2, codigo_cliente);   break;
            }
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                ClientModel client = new ClientModel(result.getInt(1),result.getString(2),result.getString(3),result.getString(4),result.getString(5));
                clients.add( client );
            }
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
        return clients;
    }

 
    public void DeleteClient(int id) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "DELETE FROM cliente WHERE codigo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente !");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : "
                    + ex.getErrorCode() + "\nError :" + ex.getMessage());
        }
    }

    public void UpdateClient(ClientModel nombre) {
        try {
            if(conn == null)
                conn = ConnectionDB.getConnection();
            
            String sql = "UPDATE cliente SET nombre =? WHERE codigo=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, nombre.getNombre());
            statement.setInt(2, nombre.getCodigo());
            
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) 
                JOptionPane.showMessageDialog(null, "El registro fue actualizado exitosamente !");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Código : " + ex.getErrorCode() 
                                        + "\nError :" + ex.getMessage());
        }
    }
    
    
}
