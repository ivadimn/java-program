package model;

public class Answer {
    private boolean value;
    private String title;

    public Answer(String title, boolean value) {
        this.title = title;
        this.value = value;
    }

    public boolean isValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }
}
