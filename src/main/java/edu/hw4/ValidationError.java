package edu.hw4;

@SuppressWarnings("MultipleStringLiterals")
public enum ValidationError {
    NULL_NAME("name"),
    EMPTY_NAME("name"),
    NULL_TYPE("type"),
    NULL_SEX("sex"),
    NEGATIVE_AGE("age"),
    NEGATIVE_HEIGHT("height"),
    NEGATIVE_WEIGHT("weight");
    private final String title;

    ValidationError(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
