
package com.atrium.servicio.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sumar", namespace = "http://servicio.atrium.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumar", namespace = "http://servicio.atrium.com/", propOrder = {
    "arg0",
    "arg1"
})
public class Sumar {

    @XmlElement(name = "arg0", namespace = "")
    private Integer arg0;
    @XmlElement(name = "arg1", namespace = "")
    private Integer arg1;

    /**
     * 
     * @return
     *     returns Integer
     */
    public Integer getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(Integer arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns Integer
     */
    public Integer getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(Integer arg1) {
        this.arg1 = arg1;
    }

}
