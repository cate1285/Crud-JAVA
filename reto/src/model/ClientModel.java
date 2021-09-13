/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Vector;

/**
 *
 * @author robin
 */
public class ClientModel {
    private int       codigo;
    private int       empleado_id;
    private String    nombre;
    private String    nit;
    private String    representanteLegal;
    private String    sectorComercial;
    private int       proyecto;
    private String    inicio;
    private String    nombre_empleado;
    private String    apellido_empleado;
    private String    codigo1;
    
    public ClientModel(int codigo,String nombre){
        this.codigo           = codigo;
        this.nombre          = nombre;
    }
    public ClientModel(String codigo1,String nombre){
        this.codigo1           = codigo1;
        this.nombre          = nombre;
    }
    
    public ClientModel(int codigo){
        this.codigo           = codigo;
    }
    
    
    
    public ClientModel(int  codigo, String  nombre, String nit, String representanteLegal, String sectorComercial,int empleado_id ,String nombre_empleado){
        this.codigo                = codigo;
        this.nombre                = nombre;
        this.nit                   = nit;
        this.representanteLegal    = representanteLegal;
        this.sectorComercial       = sectorComercial;
        this.nombre_empleado       = nombre_empleado;
        this.empleado_id           = empleado_id;

    }
    
    public ClientModel(int  codigo,int empleado_id, String  nombre, String nit, int representanteLegal, String sectorComercial){
        this.codigo                = codigo;
        this.empleado_id           = empleado_id;
        this.nombre                = nombre;
        this.nit                   = nit;
        this.proyecto    = representanteLegal  ;
        this.inicio       = sectorComercial;
        
    }
    public ClientModel(int  codigo,int empleado_id, String sectorComercial){
        this.codigo                = codigo;
        this.empleado_id           = empleado_id;
        this.inicio       = sectorComercial;

    }
     public ClientModel(int  codigo, String  nombre, String nit, String representanteLegal, String sectorComercial){
        this.codigo                = codigo;
        this.nombre                = nombre;
        this.nit                   = nit;
        this.representanteLegal    = representanteLegal ;
        this.sectorComercial       = sectorComercial;

    }

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @return the representanteLegal
     */
    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    /**
     * @return the sectorComercial
     */
    public String getSectorComercial() {
        return sectorComercial;
    }
    

    /**
     * @return the empleado_id
     */
    public int getEmpleado_id() {
        return empleado_id;
    }

    /**
     * @return the proyecto
     */
    public int getProyecto() {
        return proyecto;
    }
    
    
 
    /**
     * @return the nombre_empleado
     */
    public String getNombre_empleado() {
        return nombre_empleado;
    }

    /**
     * @return the apellido_empleado
     */
    public String getApellido_empleado() {
        return apellido_empleado;
    }
    
    public Object[] toArray(){
        Object[] data = {  codigo, nombre,  nit, representanteLegal,sectorComercial};
        return data;
    }
    
    public String toString(){
        return this.nombre;
    }

    /**
     * @return the codigo1
     */
    public String getCodigo1() {
        return codigo1;
    }




    
}
