package learn.ddd.dto.response;

import lombok.Getter;

@Getter
public class PaidPaymentResponse {
    //TODO : 추후에 Staff에게 전달하는 id값이 필요할듯!
    private String message;

    public PaidPaymentResponse(String message) {
        this.message = message;
    }

}
