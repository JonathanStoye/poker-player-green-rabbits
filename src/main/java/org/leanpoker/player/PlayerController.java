package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import java.util.Map;

@Controller()
public class PlayerController {

    ObjectMapper mapper = new ObjectMapper();

    @Get(produces = MediaType.TEXT_PLAIN)
    public String doGet() {
        return "Java player is running";
    }

    @Post(produces = MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String doPost(@Body Map<String, String> body) throws JsonProcessingException {

        String action = body.get("action");
        String gameState = body.get("game_state");

        if ("bet_request".equals(action)) {
            String s = String.valueOf(BetService.betRequest(mapper.readTree(gameState)));
            System.out.println("Our return: "+ s);
            return s;
        }
        if ("showdown".equals(action)) {
            BetService.showdown(mapper.readTree(gameState));
        }
        if ("version".equals(action)) {
            return BetService.VERSION;
        }

        return "";
    }

}
