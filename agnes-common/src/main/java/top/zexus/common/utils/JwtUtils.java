package top.zexus.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.zexus.common.constants.CommonConstants;
import top.zexus.common.pojo.UserToken;

import java.util.Date;

/**
 * @author Zexus
 */
public class JwtUtils {
    public static String generateToken(UserToken userToken, int expire) throws Exception {
        String token = Jwts.builder()
                .setSubject(userToken.getUsername())
                .setId(userToken.getUserId())
                .claim(CommonConstants.CONTEXT_USER_ID, userToken.getUserId())
                .setExpiration(new Date(System.currentTimeMillis()+expire))
                .signWith(SignatureAlgorithm.HS256,CommonConstants.JWT_PRIVATE_KEY)
                .compact();
        System.out.println("------------生成token-------:" + token);
        return token;
    }


    public static String getInfoFromToken(String token) throws Exception{
        String returnValue = "";
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(CommonConstants.JWT_PRIVATE_KEY)
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println("-------SubjectId--------:" + claims.get(CommonConstants.CONTEXT_USER_ID));
            System.out.println("-------Subject--------:" + claims.getSubject());
            System.out.println("解析token成功");
            returnValue = claims.toString();
        }catch (Exception e){
            throw new Exception("过期登录");
//            e.printStackTrace();
        }
        finally {
            return returnValue;
        }
    }
}
