package learn.ddd.domain;

public enum DrinkSize {

    SMALL("작은 사이즈"),
    MEDIUM("중간 사이즈"),
    LARGE("큰 사이즈");

    private final String description;


    DrinkSize(String description) {
        this.description = description;
    }
}
