package by.foranx.webservice.entity;

import jakarta.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "response"
})
@XmlRootElement(name = "getPaymentResponse")
public class GetPaymentResponse {

    @XmlElement(name = "Response", required = true)
    protected Response response;

    public Response getResponse() {
        return response;
    }

    public void setResponse(Response value) {
        this.response = value;
    }

}
