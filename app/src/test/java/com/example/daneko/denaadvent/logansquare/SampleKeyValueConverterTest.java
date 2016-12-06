package com.example.daneko.androidadventcalendar.logansquare;

import com.bluelinelabs.logansquare.LoganSquare;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 */
public class SampleKeyValueConverterTest {

    @Test
    public void test想定したJsonが正しくParseされる() throws IOException {
        LoganSquare.registerTypeConverter(Sample.KeyValue.class, new SampleKeyValueConverter());

        final String json = "{\n" +
                "  \"response\" : [\n" +
                "    {\"key_a\": \"value1\"},\n" +
                "    {\"key_b\": \"value2\"},\n" +
                "    {\"key_c\": \"value3\"},\n" +
                "    {\"key_a\": \"value4\"},\n" +
                "    {\"key_b\": \"value5\"},\n" +
                "    {\"key_c\": \"value6\"}\n" +
                "  ]\n" +
                "}";

        final Sample actual = LoganSquare.parse(json, Sample.class);
        final Sample expect = new Sample(Arrays.asList(
                new Sample.KeyValue("key_a", "value1"),
                new Sample.KeyValue("key_b", "value2"),
                new Sample.KeyValue("key_c", "value3"),
                new Sample.KeyValue("key_a", "value4"),
                new Sample.KeyValue("key_b", "value5"),
                new Sample.KeyValue("key_c", "value6")
        ));

        assertThat(actual).isEqualTo(expect);

    }

}
