package com.example.summarize.Model;

public class Summary {

    private long id;
    private String transcripts;
    private String openaimodel;
    private String summarize;


    public Summary() {}

    public Summary(Long id, String transcripts,String openaimodel,String summarize){
        this.id = id;
        this.transcripts = transcripts;
        this.openaimodel= openaimodel;
        this.summarize = summarize;
    }

    public String getSummarize() {
        return summarize;
    }

    public void setSummarize(String summarize) {
        this.summarize = summarize;
    }

    public long getId() {
        return id;
    }

    public String getOpenaimodel() {
        return openaimodel;
    }

    public void setOpenaimodel(String openaimodel) {
        this.openaimodel = openaimodel;
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
}
