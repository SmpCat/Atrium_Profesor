package com.atrium.hibernate;



/**
 * Provincias entity. @author MyEclipse Persistence Tools
 */

public class Provincias  implements java.io.Serializable {


    // Fields    

     private Byte codigoProvincia;
     private String provincia;


    // Constructors

    /** default constructor */
    public Provincias() {
    }

    
    /** full constructor */
    public Provincias(Byte codigoProvincia, String provincia) {
        this.codigoProvincia = codigoProvincia;
        this.provincia = provincia;
    }

   
    // Property accessors

    public Byte getCodigoProvincia() {
        return this.codigoProvincia;
    }
    
    public void setCodigoProvincia(Byte codigoProvincia) {
        this.codigoProvincia = codigoProvincia;
    }

    public String getProvincia() {
        return this.provincia;
    }
    
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
   








}