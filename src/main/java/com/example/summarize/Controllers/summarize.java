package com.example.summarize.Controllers;

import com.example.summarize.Model.Summary;
import com.example.summarize.Model.SummaryTranscripts;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.openai.models.responses.ResponseCreateParams;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/summarize")
@Tag(name = "Summarize", description = "just a summarize transcripts")
public class summarize {

    private final OpenAIClient client = OpenAIOkHttpClient.fromEnv();

    @Operation(
            summary = "Create a new Summarizze",
            description = "Registers a new lead with their contact details and reason for signing up."
    )
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            required = true,
            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                    examples = @ExampleObject(
                            name = "Sample lead",
                            value = "{\"transcript\": \"Jane Doe\",\"openaimodel\": \"gpt-4o-mini\"}"
                    ))
    )




    @PostMapping
    public ResponseEntity<?> createsummary(@RequestBody Map<String,String> body){
        String transcript = body.get("transcripts");
        String openaimodel = body.get("openaimodel");

        String prompt = """
                Analyze the following transcript and provide:
                1. A concise summary (2-3 sentences)
                2. Overall sentiment: Positive / Neutral / Negative
                3. Key topics discussed

                Transcript:
                """ + transcript;

        ResponseCreateParams params = ResponseCreateParams.builder()
                .input(prompt)
                .model(openaimodel)
                .build();

        var response = client.responses().create(params);

        String resultText = response.output().get(0)
                .asMessage()
                .content().get(0)
                .asOutputText()
                .text();



        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "model", openaimodel,
                "result", resultText
        ));
    }

    @GetMapping
    public List<SummaryTranscripts> getSummarize(){
        List<SummaryTranscripts> summarize = List.of();
        return summarize;
    }





}
