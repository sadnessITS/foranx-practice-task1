package by.foranx.webservice.endpoint;

import by.foranx.webservice.entity.GetPaymentRequest;
import by.foranx.webservice.entity.GetPaymentResponse;
import by.foranx.webservice.entity.Payment;
import by.foranx.webservice.repository.ErrorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class ErrorsEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";
    private ErrorsRepository errorsRepository;

    @Autowired
    public ErrorsEndpoint(ErrorsRepository errorsRepository) {
        this.errorsRepository = errorsRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPaymentRequest")
    @ResponsePayload
    public GetPaymentResponse getPaymentResponse(@RequestPayload GetPaymentRequest request) {
        GetPaymentResponse response = new GetPaymentResponse();
        try {
            Payment requestPayment = request.getPayment();
            response.setResponse(requestPayment.validate());
            return response;
        }
        catch (Exception e) {
            response.setResponse(errorsRepository.findError(7));
            return response;
        }
    }
}