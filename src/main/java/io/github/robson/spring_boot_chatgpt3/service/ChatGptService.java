package io.github.robson.spring_boot_chatgpt3.service;

import com.theokanning.openai.OpenAiService;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.completion.CompletionResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatGptService {

    @Value("${key}")
    private String key;

    public String getResponse(String question){
        try{
            OpenAiService openAI = new OpenAiService(key);
            CompletionRequest request = CompletionRequest.builder()
                    .prompt(question)
                    .model("text-davinci-003")
                    .maxTokens(2048)
                    .echo(true)
                    .build();
            CompletionResult response = openAI.createCompletion(request);
            return response.getChoices().get(0).getText();
        }catch (Exception e){
            return "Erro ao se conectar ao modelo ChatGPT, espere alguns segundos!!";
        }
    }
}
