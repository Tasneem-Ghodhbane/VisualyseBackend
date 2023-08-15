package com.example.VisualyseBackend.repository;

import com.example.VisualyseBackend.model.MyNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface SharedRepository extends Neo4jRepository<MyNode,String> {
}
