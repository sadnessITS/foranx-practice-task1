package by.foranx.webservice.entity;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Response", propOrder = {
    "error",
    "msg"
})
public class Response {
    @XmlElement(name = "Error")
    protected int error;
    @XmlElement(name = "MSG", required = true)
    protected String msg;
    public int getError() {
        return error;
    }
    public void setError(int value) {
        this.error = value;
    }
    public String getMSG() {
        return msg;
    }
    public void setMSG(String value) {
        this.msg = value;
    }
}
