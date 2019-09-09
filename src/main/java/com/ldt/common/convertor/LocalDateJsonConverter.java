package com.ldt.common.convertor;

import com.google.gson.*;
import com.ldt.common.constant.AppConst;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateJsonConverter implements JsonSerializer<LocalDate>,JsonDeserializer<LocalDate> {

    private static DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(AppConst.DATE_FORMAT);

    public JsonElement serialize(LocalDate localDate, Type type, JsonSerializationContext jsonSerializationContext) {
        return new JsonPrimitive(localDate.format(dateFormatter));
    }

    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        return LocalDate.parse(json.getAsString(),dateFormatter);

    }
}