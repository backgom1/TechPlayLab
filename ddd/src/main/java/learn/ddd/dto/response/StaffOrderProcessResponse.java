package learn.ddd.dto.response;

import lombok.Getter;

@Getter
public class StaffOrderProcessResponse {

    private String message;

    public StaffOrderProcessResponse(String message) {
        this.message = message;
    }
}
