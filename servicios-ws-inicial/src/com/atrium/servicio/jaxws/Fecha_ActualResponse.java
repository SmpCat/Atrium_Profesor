
package com.atrium.servicio.jaxws;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "fecha_ActualResponse", namespace = "http://servicio.atrium.com/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fecha_ActualResponse", namespace = "http://servicio.atrium.com/")
public class Fecha_ActualResponse {

    @XmlElement(name = "return", namespace = "")
    private Date _return;

    /**
     * 
     * @return
     *     returns Date
     */
    public Date getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(Date _return) {
        this._return = _return;
    }

}
