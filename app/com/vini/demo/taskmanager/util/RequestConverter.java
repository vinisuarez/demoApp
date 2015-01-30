package com.vini.demo.taskmanager.util;

import org.apache.commons.beanutils.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class RequestConverter implements Converter {

    private static final Logger LOG = LoggerFactory.getLogger(RequestConverter.class);

    @SuppressWarnings("unchecked")
    @Override
    public <T> T convert(Class<T> tClass, Object value) {
        String valueString = (String) value;
        if (valueString == null) {
            return null;
        } else if (valueString.contains("\r") || valueString.contains("\n")) {
            try {
                valueString = URLEncoder.encode(valueString, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                LOG.error("Error when converting input field ", e);
            }
        }
        return(T) removeUnsafeKeyWords(valueString);
    }

    private String removeUnsafeKeyWords(String value){
        return value.replaceAll("<", "")
                .replaceAll(">", "")
                .replaceAll("\\$" ,"")
                .replaceAll("_", "")
                .replaceAll("/", "")
                .replaceAll("\\+", " ")
                .replaceAll("script", "")
                .replaceAll("function", "")
                .replaceAll("alert", "");
    }
}
