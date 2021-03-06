package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;

@NodeEntity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Concept {
    // This Concept Json will take all the concepts present in Neo4j graph
    @Id
    private int Id;
    private String name;
    private String parent_id;
    private String relation;
    private String type;
    private String context;
    private String classType;
}
