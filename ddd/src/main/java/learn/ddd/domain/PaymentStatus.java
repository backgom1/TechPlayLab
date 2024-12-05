package learn.ddd.domain;

public enum PaymentStatus {

    PAID("결제 완료"),
    UNPAID("결제 미완료");

    private final String description;


    PaymentStatus(String description) {
        this.description = description;
    }
}
