package com.example.VisualyseBackend.controller;

import com.example.VisualyseBackend.model.MyCall;
import com.example.VisualyseBackend.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/calls")
public class CallController {

    @Autowired
    private CallService callService;

    @GetMapping()
    public List<MyCall> getMyCalls(){
        return  this.callService.getAllRelationships();
    }

    @PostMapping()
    public  MyCall addMyCall(@RequestPart String startPoint, @RequestPart String endPoint,@RequestPart String callType,@RequestPart String API, @RequestPart
                             String topic,@RequestPart String eventProduced, @RequestPart String description){
        return this.callService.createCall(startPoint, endPoint, callType, API, topic, eventProduced, description);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteNode(@PathVariable("id") Long id) {
        callService.deleteCallById(id);
    }
}
