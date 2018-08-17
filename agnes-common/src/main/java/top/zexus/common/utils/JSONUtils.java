package top.zexus.common.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 10:36 2018/7/23
 */
public class JSONUtils {

    public static String beanToJSON(Object object) {
        if (object != null) {
            return JSON.toJSONString(object);
        } else {
            return null;
        }
    }

    public static String beanToJSON(Object object, String dataFormatString) {
        if (object != null) {
            if (StringUtils.isEmpty(dataFormatString)) {
                return JSONObject.toJSONString(object);
            }
            return JSON.toJSONStringWithDateFormat(object, dataFormatString);
        } else {
            return null;
        }
    }

    public static Object jsonToBean(String json, Object clas) {
        if (StringUtils.isEmpty(json) || clas == null) {
            return null;
        }
        return JSON.parseObject(json, clas.getClass());
    }

    @SuppressWarnings("unchecked")
    public static Map<String, Object> jsonToMap(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JSON.parseObject(json, Map.class);
    }

    public static String stringToJSON(String key, String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>(16);
        map.put(key, value);
        return beanToJSON(map, null);
    }
}
