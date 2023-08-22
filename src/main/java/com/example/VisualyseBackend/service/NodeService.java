package com.example.VisualyseBackend.service;

import com.example.VisualyseBackend.model.MyNode;
import com.example.VisualyseBackend.repository.SharedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NodeService {

   @Autowired
    private SharedRepository sharedRepository;

    public List<MyNode> findAll(){
        return this.sharedRepository.findAll();
    }


    public MyNode createNode(MyNode myNode){
        return this.sharedRepository.save(myNode);
    }

    public Optional<MyNode> getMyNode(String name) {
        return sharedRepository.findById(name);
    }

    public void deleteNodeByName(String name) {
        sharedRepository.deleteById(name);
    }

    public void deleteAll() {
        sharedRepository.deleteAll();
    }

}

