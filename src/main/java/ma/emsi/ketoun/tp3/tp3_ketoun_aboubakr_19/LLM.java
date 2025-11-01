package ma.emsi.ketoun.tp3.tp3_ketoun_aboubakr_19;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
public class LLM {
    String systemRole;
    GuideTouristique assistant;
    ChatMemory memory;


    public LLM(){

        String llmKey = System.getenv("GEMINI_Key");
        if (llmKey == null) {
            System.err.println("No Key!");
            return;
        }
        ChatModel model = GoogleAiGeminiChatModel.builder()
                .apiKey(llmKey)
                .modelName("gemini-2.5-flash")
                .temperature(0.3)
                .build();

        this.memory = MessageWindowChatMemory.withMaxMessages(10);
        this.assistant = AiServices.builder(GuideTouristique.class)
                .chatModel(model)
                .chatMemory(memory)
                .build();
    }

    public String PoserQuestion(String question) {
        try {
            return assistant.chat(question);
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }

    }

}

