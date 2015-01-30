package com.vini.demo.taskmanager.util;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RequestConverterTest {

    RequestConverter requestConverter;

    @Before
    public void setup() {
        requestConverter  = new RequestConverter();
    }


    @Test
    public void shouldReturnNullForNullInput() {
        String input = null;
        String converted = requestConverter.convert(String.class, input);
        assertEquals(null, converted);
    }
    @Test
    public void shouldEncodeSpaceAndNewLine() {
        String input = "Test\n\rTest";
        String converted = requestConverter.convert(String.class, input);
        assertEquals("Test%0A%0DTest", converted);
    }

    @Test
    public void shouldRemoveUnsafeKeyWords() {
        String input = "<script>$_function(){alert();}/</script>";
        String converted = requestConverter.convert(String.class, input);
        assertEquals("(){();}", converted);
    }

}