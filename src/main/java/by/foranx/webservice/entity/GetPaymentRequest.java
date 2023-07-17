package by.foranx.webservice.entity;

import jakarta.xml.bind.annotation.*;
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "payment"
})
@XmlRootElement(name = "getPaymentRequest")
public class GetPaymentRequest {

    @XmlElement(name = "Payment", required = true)
    protected Payment payment;

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment value) {
        this.payment = value;
    }

}
