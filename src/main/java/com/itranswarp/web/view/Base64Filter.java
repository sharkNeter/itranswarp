package com.itranswarp.web.view;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.pebbletemplates.pebble.error.PebbleException;
import io.pebbletemplates.pebble.template.EvaluationContext;
import io.pebbletemplates.pebble.template.PebbleTemplate;

@Component
public class Base64Filter extends AbstractFilter {

    @Override
    public String getName() {
        return "base64";
    }

    @Override
    public Object apply(Object input, Map<String, Object> args, PebbleTemplate self, EvaluationContext context, int lineNumber) throws PebbleException {
        if (input == null) {
            return "";
        }
        String s = input.toString();
        return Base64.getEncoder().encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

}
