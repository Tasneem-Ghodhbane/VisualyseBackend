package com.example.VisualyseBackend.repository;

import com.example.VisualyseBackend.model.MyCall;
import com.example.VisualyseBackend.model.MyNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import java.util.List;

public interface SharedRepository extends Neo4jRepository<MyNode,String> {

    @Query("MATCH (start:MyNode)-[r]->(end:MyNode) "+
            "RETURN r.id AS id , "+
            "r.callType AS callType , "+
            "r.startPoint AS startPoint , "+
            "r.endPoint AS endPoint , "+
            "r.API AS API , "+
            "r.topic AS topic , "+
            "r.eventProduced AS eventProduced , "+
            "r.description AS description "

    )
    List<MyCall> findAllRelationships();

    @Query("MATCH (start:MyNode), (end:MyNode) " +
            "WHERE start.name = $startPoint AND end.name = $endPoint " +
            "CREATE (start)-[r:Calls]->(end) " +
            "SET r.id = ID(r), r.callType = $callType, r.startPoint = $startPoint, r.endPoint = $endPoint, " +
            "r.API = $API, r.topic = $topic, r.eventProduced = $eventProduced, r.description = $description " +
            "RETURN r.id AS id , "+
            "r.callType AS callType , "+
            "r.startPoint AS startPoint , "+
            "r.endPoint AS endPoint , "+
            "r.API AS API , "+
            "r.topic AS topic , "+
            "r.eventProduced AS eventProduced , "+
            "r.description AS description ")
    MyCall createRelationship(String startPoint, String endPoint, String callType, String API,
                            String topic, String eventProduced, String description);

    @Query("MATCH ()-[c:Calls]->() " +
            "WHERE c.id = $id " +
            "DELETE c")
    void deleteCallById(Long id);

    @Query("MATCH ()-[c:Calls]->() " +
            "DELETE c")
    void deleteAllCalls();

    @Query("MATCH (start:MyNode)-[r:Calls]->(end:MyNode) " +
            "WHERE r.id = $id " +
            "SET r.callType = $callType, r.API = $API, r.topic = $topic, " +
            "r.eventProduced = $eventProduced, r.description = $description " +
            "RETURN r.id AS id , "+
            "r.callType AS callType , "+
            "r.API AS API , "+
            "r.topic AS topic , "+
            "r.eventProduced AS eventProduced , "+
            "r.description AS description "
    )
    MyCall updateCall(Long id, String callType, String API, String topic,
                      String eventProduced, String description);

}
