/*
 * *******************************************************************
 * Copyright (c) 2018 Isofh.com to present.
 * All rights reserved.
 *
 * Author: tuanld
 * ******************************************************************
 *
 */

package com.ldt.common.util;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.ldt.common.annotation.AnnotationExclusionStrategy;
import com.ldt.common.constant.AppConst;
import com.ldt.common.convertor.LocalDateJsonConverter;
import com.ldt.common.convertor.LocalDateTimeJsonConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class GsonUtils {

    /**
     * Convert String to Object
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> T toObject(String json, Class<T> cls) {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter())
            .registerTypeAdapter(LocalDate.class, new LocalDateJsonConverter())
            .create().fromJson(json, cls);
    }

    /**
     * Convert String to Object
     *
     * @param json
     * @param cls
     * @return
     */
    public static <T> T toObject(JsonElement json, Class<T> cls) {
        return new GsonBuilder()
            .setDateFormat(AppConst.DATE_TIME_FORMAT)
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter())
            .create()
            .fromJson(json, cls);
    }

    /**
     * Convert Object to String using Json
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter())
            .setPrettyPrinting()
            .setExclusionStrategies(new AnnotationExclusionStrategy())
            .create()
            .toJson(obj);
    }

    /**
     * Convert Object to String using Json Pretty Printing
     *
     * @param obj
     * @return
     */
    public static String toStringCompact(Object obj) {
        return new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeJsonConverter())
            .setPrettyPrinting()
            .setExclusionStrategies(new AnnotationExclusionStrategy())
            .create()
            .toJson(obj);
    }
}
