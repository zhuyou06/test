package com.cubc.util;

import com.cubc.constant.MessageConst;
import com.cubc.error.CubcException;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;

@Slf4j
public class JsonUtil {

    private static final ObjectMapper mapper;
    private static final Logger LOG = LoggerFactory.getLogger(JsonUtil.class);

    static {
        mapper = new ObjectMapper();
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
        mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    /**
     * 物件轉json
     * @param obj 物件
     * @return
     * @throws JsonProcessingException
     * @throws Exception
     */
    public static String objectToJson(Object obj) {
        String jsonStr;
        try {
            jsonStr = mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            log.error("JsonProcessingException :", e);
            throw new CubcException(MessageConst.RtnCode.M9999);
        }
        return jsonStr;
    }
}
