package json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.TimeZone;

/**
 * Json工具
 * @author wuwenqi04
 */

public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        /**jackson*/
        OBJECT_MAPPER = new ObjectMapper();
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setTimeZone(TimeZone.getTimeZone("GMT+8"));

    }

    /**
     * 对象转json
     *
     * @param object
     * @return
     */
    public static String toJsonString(Object object) {
        try {
            return OBJECT_MAPPER.writeValueAsString(object);
        } catch (Exception e) {
            throw new JsonException("json序列化异常.Object=" + object, e);
        }
    }

    /**
     * 对象反序列化
     *
     * @param json
     * @param targetClass
     * @param <T>
     * @return
     */

    public static <T> T parseObject(String json, Class<T> targetClass) {
        try {
            return OBJECT_MAPPER.readValue(json, targetClass);
        } catch (Exception e) {
            throw new JsonException(String.format("json反序列异常.Json=%s,class=%s", json, targetClass.getCanonicalName()), e);
        }
    }

    public static <T> T[] parseArray(String json, final Class<?> elementClass) {
        try {
            return OBJECT_MAPPER.readValue(json, new TypeReference<T[]>() {
                @Override
                public Type getType() {
                    return Array.newInstance(elementClass, 0).getClass();
                }
            });
        } catch (Exception e) {
            throw new JsonException(String.format("json数组反序列异常.Json=%s,class=%s", json, elementClass.getCanonicalName()), e);
        }
    }
}
