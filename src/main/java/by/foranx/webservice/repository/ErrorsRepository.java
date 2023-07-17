package by.foranx.webservice.repository;


import by.foranx.webservice.entity.Response;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ErrorsRepository {
    private static final Map<Integer, Response> errors = new HashMap<>();

    @PostConstruct
    public void initData() {
        Response error0 = new Response();
        Response error1 = new Response();
        Response error2 = new Response();
        Response error3 = new Response();
        Response error4 = new Response();
        Response error5 = new Response();
        Response error6 = new Response();
        Response error7 = new Response();
        Response error8 = new Response();

        error0.setError(0);
        error0.setMSG("OK!");

        error1.setError(1);
        error1.setMSG("Empty name!");

        error2.setError(2);
        error2.setMSG("Empty address!");

        error3.setError(3);
        error3.setMSG("Empty IBAN!");

        error4.setError(4);
        error4.setMSG("Empty cur!");

        error5.setError(5);
        error5.setMSG("Each field must be filled in.");

        error6.setError(6);
        error6.setMSG("Unknown PNameID. May be: RcvFio0, RcvAddress0, RcvIban0 or Cur0");

        error7.setError(7);
        error7.setMSG("Wrong Request structure!");

        error8.setError(8);
        error8.setMSG("IBAN must start with KZ!");

        errors.put(0, error0);
        errors.put(1, error1);
        errors.put(2, error2);
        errors.put(3, error3);
        errors.put(4, error4);
        errors.put(5, error5);
        errors.put(6, error6);
        errors.put(7, error7);
        errors.put(8, error8);
    }

    public Response findError(int error) {
        assert errors.containsKey(error) : "Error with code like that does not exists!";
        return errors.get(error);
    }
}