package learn.ddd.domain;

public enum StaffRole {


    BARISTA("바리스타"),
    CASHIER("캐셔");

    private final String description;


    StaffRole(String description) {
        this.description = description;
    }
}
