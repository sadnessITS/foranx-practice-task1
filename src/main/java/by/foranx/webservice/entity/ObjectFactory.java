package by.foranx.webservice.entity;

import jakarta.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {
    public ObjectFactory() {
    }
    public Payment createPayment() {
        return new Payment();
    }
    public Payment.AnsAuthPay createPaymentAnsAuthPay() {
        return new Payment.AnsAuthPay();
    }
    public GetPaymentRequest createGetPaymentRequest() {
        return new GetPaymentRequest();
    }
    public GetPaymentResponse createGetPaymentResponse() {
        return new GetPaymentResponse();
    }
    public Response createResponse() {
        return new Response();
    }
    public Payment.AnsAuthPay.AdditionInfo createPaymentAnsAuthPayAdditionInfo() {
        return new Payment.AnsAuthPay.AdditionInfo();
    }

}
