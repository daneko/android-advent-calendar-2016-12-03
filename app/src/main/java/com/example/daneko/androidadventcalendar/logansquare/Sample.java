package com.example.daneko.androidadventcalendar.logansquare;

import android.support.annotation.VisibleForTesting;

import com.bluelinelabs.logansquare.annotation.JsonField;
import com.bluelinelabs.logansquare.annotation.JsonObject;

import java.util.List;

/**
 */
@JsonObject(fieldDetectionPolicy = JsonObject.FieldDetectionPolicy.NONPRIVATE_FIELDS)
public final class Sample {

    @JsonField(name = "response")
    List<KeyValue> list;

    Sample() {

    }

    @VisibleForTesting
    Sample(List<KeyValue> list) {
        this.list = list;
    }

    static class KeyValue {
        String key;
        String value;

        KeyValue(String key, String value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof KeyValue)) return false;

            KeyValue keyValue = (KeyValue) o;

            if (key != null ? !key.equals(keyValue.key) : keyValue.key != null) return false;
            return value != null ? value.equals(keyValue.value) : keyValue.value == null;

        }

        @Override
        public int hashCode() {
            int result = key != null ? key.hashCode() : 0;
            result = 31 * result + (value != null ? value.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "KeyValue{" +
                    "key='" + key + '\'' +
                    ", value='" + value + '\'' +
                    '}';
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sample)) return false;

        Sample sample = (Sample) o;

        return list != null ? list.equals(sample.list) : sample.list == null;

    }

    @Override
    public int hashCode() {
        return list != null ? list.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Sample{" +
                "list=" + list +
                '}';
    }
}
