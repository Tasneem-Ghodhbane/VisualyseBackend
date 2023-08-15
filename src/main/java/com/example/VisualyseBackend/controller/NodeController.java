package com.example.VisualyseBackend.controller;

import com.example.VisualyseBackend.model.MyNode;
import com.example.VisualyseBackend.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/nodes")
public class NodeController {
    @Autowired
    private NodeService nodeService;
    @GetMapping()
    public List<MyNode> findAll(){

        return this.nodeService.findAll();
    }

    @PostMapping
    public MyNode createNode(@RequestBody MyNode myNode){
        nodeService.createNode(new MyNode(myNode.getName(), myNode.getType()));
        return myNode;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.DELETE)
    public void deleteNode(@PathVariable("name") String name) {
        nodeService.deleteNodeByName(name);
    }
}
