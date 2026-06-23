package com.example.summarize.Service;

import com.example.summarize.Model.Summary;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.responses.Response;
import com.openai.models.responses.ResponseCreateParams;

public class SummaryService {

    public String generateSummarize(Summary summary){
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();
        String prompt = String.valueOf(summary);
        ResponseCreateParams params = ResponseCreateParams.builder()
                .model(ChatModel.GPT_5_2)
                .prompt()
                .build();

        Response response = client.responses().create(params);
    }
}
