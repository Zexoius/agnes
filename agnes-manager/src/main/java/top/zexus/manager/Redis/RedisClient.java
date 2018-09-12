package top.zexus.manager.Redis;

import java.util.List;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:48 2018/9/8
 */
public interface RedisClient {
    void set(String key, String value);

    String get(String key);

    boolean exists(String key);

    boolean expire(String key, int seconds);

    void hset(String key, String field, String value);

    Object hget(String key, String field);

    Long hdel(String key, String... field);

    boolean hexists(String key, String field);

    List<Object> hvals(String key);

    void del(String key);
}
