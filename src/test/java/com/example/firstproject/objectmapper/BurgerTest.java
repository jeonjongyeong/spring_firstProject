package com.example.firstproject.objectmapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BurgerTest {

    @Test
    public void 자바_객체를_JSON으로_변환() throws JsonProcessingException {
        // 준비
        ObjectMapper objectMapper = new ObjectMapper();
        List<String> ingredients = Arrays.asList("소고기 패티, 양상추");
        Burger burger = new Burger("데리버거", 5000, ingredients);

        // 수행
        String json = objectMapper.writeValueAsString(burger);

        // 예상
        String expected = "{\"name\":\"데리버거\",\"price\":5000,\"ingredients\":[\"소고기 패티, 양상추\"]}";

        // 검증
        assertEquals(expected, json);
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
    }

    @Test
    public void JSON을_자바_객체로_변환() throws JsonProcessingException {
        // 준비
        ObjectMapper objectMapper = new ObjectMapper();
//        String json = "{\"name\":\"데리버거\",\"price\":5000,\"ingredients\":[\"소고기 패티, 양상추\"]}";

        ObjectNode objectNode = objectMapper.createObjectNode();
        objectNode.put("name", "데리버거");
        objectNode.put("price", "5000");

        ArrayNode arrayNode = objectMapper.createArrayNode();
        arrayNode.add("소고기 패티");
        arrayNode.add("양상추");

        objectNode.set("ingredients", arrayNode);
        String json = objectNode.toString();


        // 수행
        Burger burger = objectMapper.readValue(json, Burger.class);


        // 예상
        List<String> ingredients = Arrays.asList("소고기 패티, 양상추");
        Burger expected = new Burger("데리버거", 5000, ingredients);

        // 검증
        assertEquals(expected.toString(), burger.toString());
        JsonNode jsonNode = objectMapper.readTree(json);
        System.out.println(jsonNode.toPrettyString());
        System.out.println(burger.toString());
    }

}