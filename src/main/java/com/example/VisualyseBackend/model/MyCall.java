package com.example.VisualyseBackend.model;

import org.springframework.data.annotation.Id;

public class MyCall {


    private Long id;

    private String callType;
    private String startPoint;
    private String endPoint;
    private String API;
    private String topic;
    private String eventProduced;
    private String description;

    public MyCall(Long id, String callType, String startPoint, String endPoint, String API, String topic, String eventProduced, String description){
        this.id = id;
        this.callType = callType;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.API = API;
        this.topic = topic;
        this.eventProduced = eventProduced;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(String startPoint) {
        this.startPoint = startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAPI() {
        return API;
    }

    public void setAPI(String API) {
        this.API = API;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getEventProduced() {
        return eventProduced;
    }

    public void setEventProduced(String eventProduced) {
        this.eventProduced = eventProduced;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
