package top.zexus.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import top.zexus.common.constants.CommonConstants;
import top.zexus.common.pojo.UserToken;

import java.util.Date;

/**
 * @Author: Zexus
 * @Description:
 * @Date: Created in 20:11 2018/7/22
 */
public class JwtUtiles {
    public static String generateToken(UserToken userToken, int expire) {
        String token = Jwts.builder()
                .setSubject(userToken.getUsername())
                .claim(CommonConstants.CONTEXT_USER_ID, userToken.getUserId())
                .claim(CommonConstants.CONTEXT_USERNAME, userToken.getUsername())
                .claim(CommonConstants.RENEW_TIME, new Date(System.currentTimeMillis() + expire / 2))
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .signWith(SignatureAlgorithm.HS256, CommonConstants.JWT_PRIVATE_KEY)
                .compact();
        return token;
    }

    public static UserToken getInfoFromToken(String token) throws Exception {
        Claims claims = Jwts.parser()
                .setSigningKey(CommonConstants.JWT_PRIVATE_KEY).parseClaimsJws(token)
                .getBody();
        return new UserToken(claims.get(CommonConstants.CONTEXT_USER_ID).toString(),claims.get(CommonConstants.CONTEXT_USERNAME).toString());
    }
}
