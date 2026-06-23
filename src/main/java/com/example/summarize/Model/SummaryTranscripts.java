package com.example.summarize.Model;

import com.example.summarize.Store.SummarizeStore;

public class SummaryTranscripts {

    private long id;
    private String transcripts;
    private String openaimodel;
    private String summarytranscripts;

    public SummaryTranscripts(){};

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTranscripts() {
        return transcripts;
    }

    public void setTranscripts(String transcripts) {
        this.transcripts = transcripts;
    }

    public String getOpenaimodel() {
        return openaimodel;
    }

    public void setOpenaimodel(String openaimodel) {
        this.openaimodel = openaimodel;
    }

    public String getSummarytranscripts() {
        return summarytranscripts;
    }

    public void setSummarytranscripts(String summarytranscripts) {
        this.summarytranscripts = summarytranscripts;
    }
}
