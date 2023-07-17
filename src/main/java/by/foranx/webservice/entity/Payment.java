package by.foranx.webservice.entity;

import by.foranx.webservice.repository.ErrorsRepository;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Payment", propOrder = {
    "ansAuthPay"
})
public class Payment {

    @XmlElement(name = "AnsAuthPay", required = true)
    protected AnsAuthPay ansAuthPay;
    public AnsAuthPay getAnsAuthPay() {
        return ansAuthPay;
    }
    public void setAnsAuthPay(AnsAuthPay value) {
        this.ansAuthPay = value;
    }

    public Response validate() {
        ErrorsRepository errorsRepository = new ErrorsRepository();
        try {
            List<Payment.AnsAuthPay.AdditionInfo> additionInfos = new ArrayList<>(this.getAnsAuthPay().getAdditionInfo());
            if (additionInfos.size() < 4) return errorsRepository.findError(5);

            for (Payment.AnsAuthPay.AdditionInfo info : additionInfos) {
                switch (info.getPNameID()) {
                    case "RcvFio0":
                        if (info.getPValue() == null || info.getPValue().isBlank())
                            return errorsRepository.findError(1);
                        break;
                    case "RcvAddress0":
                        if (info.getPValue() == null || info.getPValue().isBlank())
                            return errorsRepository.findError(2);
                        break;
                    case "RcvIban0":
                        if (info.getPValue() == null || info.getPValue().isBlank())
                            return errorsRepository.findError(3);
                        if (!info.getPValue().startsWith("KZ"))
                            return errorsRepository.findError(8);
                        break;
                    case "Cur0":
                        if (info.getPValue() == null || info.getPValue().isBlank())
                            return errorsRepository.findError(4);
                        break;
                    default:
                        return errorsRepository.findError(6);
                }
            }
            return errorsRepository.findError(0);
        }
        catch (Exception e) {
            return errorsRepository.findError(7);
        }
    }
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "additionInfo"
    })
    public static class AnsAuthPay {

        @XmlElement(name = "AdditionInfo", required = true)
        protected List<AdditionInfo> additionInfo;
        public List<AdditionInfo> getAdditionInfo() {
            if (additionInfo == null) {
                additionInfo = new ArrayList<AdditionInfo>();
            }
            return this.additionInfo;
        }

        public void setAdditionInfo(List<AdditionInfo> value) {
            this.additionInfo = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "pNameID",
            "pValue"
        })
        public static class AdditionInfo {

            @XmlElement(name = "PNameID", required = true)
            protected String pNameID;
            @XmlElement(name = "PValue", required = true)
            protected String pValue;
            public String getPNameID() {
                return pNameID;
            }
            public void setPNameID(String value) {
                this.pNameID = value;
            }
            public String getPValue() {
                return pValue;
            }

            public void setPValue(String value) {
                if (this.pNameID.equals("RcvIban0"))
                    assert value.matches("^KZ.*") : "IBAN must starts with KZ!";
                this.pValue = value;
            }
        }
    }
}
