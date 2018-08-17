package top.zexus.common.pojo.dto;

import javax.validation.constraints.NotNull;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 16:18 2018/7/30
 */
public class LoginDto {
    @NotNull
    private String username;
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
