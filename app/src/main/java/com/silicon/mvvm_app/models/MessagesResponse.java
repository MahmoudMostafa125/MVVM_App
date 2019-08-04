package com.silicon.mvvm_app.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MessagesResponse {
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("messages")
    @Expose
    private Messages messages;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Messages getMessages() {
        return messages;
    }

    public void setMessages(Messages messages) {
        this.messages = messages;
    }

}
