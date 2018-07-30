package com.mogateway.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018-03-30.
 */
@Component
public class IntegerConverterConfig implements Converter<String, Integer> {
    @Override
    public Integer convert(String s) {
        if (s.isEmpty()) {
            return null;
        }
        return Integer.parseInt(s);
    }
}
