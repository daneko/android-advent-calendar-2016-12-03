package com.example.daneko.androidadventcalendar.logansquare;

import com.bluelinelabs.logansquare.typeconverters.TypeConverter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

/**
 */
public final class SampleKeyValueConverter implements TypeConverter<Sample.KeyValue> {

    @Override
    public Sample.KeyValue parse(JsonParser jsonParser) throws IOException {
        if (jsonParser.getCurrentToken() == JsonToken.START_OBJECT) {
            jsonParser.nextToken();
            final Sample.KeyValue instance = parseField(jsonParser);
            jsonParser.skipChildren();
            while (jsonParser.getCurrentToken() != JsonToken.END_OBJECT) {
                jsonParser.nextToken();
            }
            return instance;
        }
        return null;
    }


    Sample.KeyValue parseField(JsonParser jsonParser) throws IOException {
        final String fieldName = jsonParser.getCurrentName();
        jsonParser.nextToken();
        final String value = jsonParser.getValueAsString();
        return new Sample.KeyValue(fieldName, value);
    }

    @Override
    public void serialize(Sample.KeyValue object, String fieldName, boolean writeFieldNameForObject, JsonGenerator jsonGenerator) throws IOException {
        throw new RuntimeException("not impl");
    }
}
