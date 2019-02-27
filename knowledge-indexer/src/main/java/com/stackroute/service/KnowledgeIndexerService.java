package com.stackroute.service;

import com.stackroute.model.Concept;
import com.stackroute.model.Knowledge;
import com.stackroute.repository.ConceptRepository;
import com.stackroute.repository.KnowledgeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeIndexerService {
     private ConceptRepository conceptRepository;
     private KnowledgeRepository knowledgeRepository;

     @Autowired
     public KnowledgeIndexerService(ConceptRepository conceptRepository, KnowledgeRepository knowledgeRepository){
          this.conceptRepository=conceptRepository;
          this.knowledgeRepository=knowledgeRepository;
     }

     //method to save knowledge nodes to neo4j
     public void saveKnowledgeToDb(Knowledge knowledge) {
          knowledgeRepository.save(knowledge);
     }

     //method to add relationship between ontology nodes and knowledge nodes
     public void addRelationship(String concept, String paragraphId, String intentLevel,double confidenceScore)
     {
          if(intentLevel.equals("knowledge"))
               knowledgeRepository.insertKnowledgeRelationship(concept,paragraphId,intentLevel,confidenceScore);

          else if(intentLevel.equals("comprehension"))
               knowledgeRepository.insertComprehensionRelationship(concept,paragraphId,intentLevel,confidenceScore);

          else if(intentLevel.equals("application"))
               knowledgeRepository.insertApplicationRelationship(concept,paragraphId,intentLevel,confidenceScore);

          else if(intentLevel.equals("analysis"))
               knowledgeRepository.insertAnalysisRelationship(concept,paragraphId,intentLevel,confidenceScore);

          else if(intentLevel.equals("synthesis"))
               knowledgeRepository.insertSynthesisRelationship(concept,paragraphId,intentLevel,confidenceScore);

          else if(intentLevel.equals("evaluation"))
               knowledgeRepository.insertEvaluationRelationship(concept,paragraphId,intentLevel,confidenceScore);
     }
}
