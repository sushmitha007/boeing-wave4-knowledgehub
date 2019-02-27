package com.stackroute.service;

import com.stackroute.domain.AnalysisResult;
import com.stackroute.nlpService.NlpService;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public interface AnalyticService {
    public String getNounSentence();

    public String getVerbSentence();

    public AnalysisResult getAnalysisResult();

    public ArrayList<String> getConceptNames();

    public void setConceptNames(ArrayList<String> conceptNames);
}
