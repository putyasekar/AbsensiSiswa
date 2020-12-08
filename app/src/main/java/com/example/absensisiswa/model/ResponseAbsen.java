package com.example.absensisiswa.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseAbsen {

    @SerializedName("person")
    private List<PersonItem> person;

    @SerializedName("error")
    private boolean error;

    @SerializedName("status")
    private int status;

    public ResponseAbsen() {

    }

    public void setPerson(List<PersonItem> person) {
        this.person = person;
    }

    public List<PersonItem> getPerson() {
        return person;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}
