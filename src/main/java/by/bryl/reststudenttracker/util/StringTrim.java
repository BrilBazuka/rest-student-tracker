package by.bryl.reststudenttracker.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.IOException;

/**
 * Util class for trimming leading and trailing whitespaces from JSON string
 *
 * @author Andrew Bryl
 */

public class StringTrim extends SimpleModule {

    public StringTrim() {
        addDeserializer(String.class, new StdScalarDeserializer<String>(String.class) {
            @Override
            public String deserialize(JsonParser jsonParser, DeserializationContext ctx) throws IOException {
                final String stringValue = jsonParser.getValueAsString();
                return stringValue.trim();
            }
        });
    }
}
