
package com.atrium.servicio.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "sumarResponse", namespace = "http://servicio.atrium.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sumarResponse", namespace = "http://servicio.atrium.com/")
public class SumarResponse {

    @XmlElement(name = "return", namespace = "")
    private Integer _return;

    /**
     * 
     * @return
     *     returns Integer
     */
    public Integer getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Integer _return) {
        this._return = _return;
    }

}
