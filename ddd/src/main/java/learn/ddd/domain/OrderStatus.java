package learn.ddd.domain;

public enum OrderStatus {

    PENDING("주문 생성 후 결제가 완료되지 않은 상태"),
    PROGRESS("결제가 완료되고 음료 준비가 진행 중인 상태"),
    READY("음료 준비가 완료된 상태"),
    COMPLETED("고객이 음료를 픽업한 상태");

    private final String description;


    OrderStatus(String description) {
        this.description = description;
    }
}
