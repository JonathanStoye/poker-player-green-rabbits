package org.leanpoker.player.raw;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class ReadGameStateTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void should() throws IOException {

        File nextFile = new File(ReadGameStateTest.class.getResource("game1-r1.json").getFile());

        GameStateRaw gameRequestRaw = objectMapper.readValue(nextFile, GameStateRaw.class);

        System.out.println(gameRequestRaw);

    }
}
