package com.example.myalvin.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.List;

@Slf4j
public class StringListConvertor implements AttributeConverter<List<String>, String> {

    private static final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
            .configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, false);


    @Override
    public String convertToDatabaseColumn(List<String> attribute) {
        try {
            return mapper.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            log.debug("StringListConverter.convertToDatabaseColumn exception occur attribute: {}", attribute.toString());
            throw new BusinessLogicException(ExceptionCode.UNABLE_TO_CONVERT_LIST_TO_STRING);
        }
    }


    @Override
    public List<String> convertToEntityAttribute(String dbData) {
        try {
            return mapper.readValue(dbData, List.class);
        } catch (IOException e) {
            log.debug("StringListConverter.convertToEntityAttribute exception occur dbData: {}", dbData);
            throw new BusinessLogicException(ExceptionCode.UNABLE_TO_CONVERT_STRING_TO_LIST);
        }
    }
}