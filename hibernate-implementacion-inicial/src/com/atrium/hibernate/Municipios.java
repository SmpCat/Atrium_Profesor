package com.atrium.hibernate;



/**
 * Municipios entity. @author MyEclipse Persistence Tools
 */

public class Municipios  implements java.io.Serializable {


    // Fields    

     private MunicipiosId id;
     private String municipio;


    // Constructors

    /** default constructor */
    public Municipios() {
    }

    
    /** full constructor */
    public Municipios(MunicipiosId id, String municipio) {
        this.id = id;
        this.municipio = municipio;
    }

   
    // Property accessors

    public MunicipiosId getId() {
        return this.id;
    }
    
    public void setId(MunicipiosId id) {
        this.id = id;
    }

    public String getMunicipio() {
        return this.municipio;
    }
    
    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }
   








}