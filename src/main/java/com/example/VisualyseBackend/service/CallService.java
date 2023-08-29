package com.example.VisualyseBackend.service;

import com.example.VisualyseBackend.model.MyCall;
import com.example.VisualyseBackend.repository.SharedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CallService {

    @Autowired
    private SharedRepository sharedRepository;

    public List<MyCall> getAllRelationships() {
        return sharedRepository.findAllRelationships();
    }

    public MyCall createCall(String startPoint, String endPoint, String callType, String API,
                             String topic, String eventProduced, String description){
        return sharedRepository.createRelationship(startPoint, endPoint, callType, API, topic, eventProduced, description);
    }

    public void deleteCallById(Long id){
        sharedRepository.deleteCallById(id);
    }

    public void deleteAll() {
        sharedRepository.deleteAllCalls();
    }

    public MyCall updateCall(Long id, String callType, String API,
                           String topic, String eventProduced, String description){
      return   sharedRepository.updateCall(id,callType, API, topic, eventProduced, description);}
}
