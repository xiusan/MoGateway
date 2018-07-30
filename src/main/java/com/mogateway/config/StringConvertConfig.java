package com.mogateway.config;

import org.springframework.core.convert.converter.Converter;

/**
 * Created by Administrator on 2018-04-04.
 */
public class StringConvertConfig implements Converter<String, String> {
    @Override
    public String convert(String s) {
        if (s.isEmpty()) {
            return "-";
        } else {
            return s;
        }
    }
}
