package org.sofkau.email.models;

public class Email {
    private String value;
    private Boolean isSended;

    public Email(String value, Boolean isSended) {
        this.value = value;
        this.isSended = isSended;
    }

    public Email(String value) {
        this.value = value;
        this.isSended = false;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Boolean getSended() {
        return isSended;
    }

    public void setSended(Boolean sended) {
        isSended = sended;
    }

    @Override
    public String toString() {
        return "Email{" +
                "value='" + value + '\'' +
                ", isSended=" + isSended +
                '}';
    }
}
