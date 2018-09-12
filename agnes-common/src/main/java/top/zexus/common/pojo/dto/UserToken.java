package top.zexus.common.pojo.dto;

import java.io.Serializable;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 20:12 2018/7/22
 */
public class UserToken implements Serializable {
    private static final long serialVersionUID = 1L;

    private String userId;
    private String username;

    public UserToken(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "UserToken{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                '}';
    }
}
