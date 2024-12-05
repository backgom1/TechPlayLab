package learn.ddd.domain;

public enum PaymentMethod {

    CARD("카드"),
    CASH("현금"),
    APP("앱 결제");

    private final String description;

    PaymentMethod(String description) {
        this.description = description;
    }
}
