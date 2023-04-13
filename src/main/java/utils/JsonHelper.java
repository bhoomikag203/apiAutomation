package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class JsonHelper {

    public static Object getObject(String jsonString, Class toClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(jsonString, toClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getJsonObject(String fileName) {
        return new org.json.JSONObject(getFileContentsAsString(fileName));
    }

    private String getFileContentsAsString(String fileName) {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        return getFileContentsAsString(inputStream);
    }


    private String getFileContentsAsString(InputStream stream) {
        List<String> lines = Arrays.asList();
        try {
            lines = IOUtils.readLines(stream, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return StringUtils.join(lines, "");
    }
}
