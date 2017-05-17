package com.bsuir.translateService.security;

import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Олег Пятко on 17.05.2017.
 */
@Service
public class GetTokenService {
    @Autowired
    private UserService userService;

    private String SECRET_KEY = "secret";

    public String getToken(String username, String password) throws Exception {
        if (username == null || password == null)
            return null;
        UserEntity user = userService.findByLogin(username);
        Map<String, Object> tokenData = new HashMap<>();
        if (password.equals(user.getPasswordHash()))
        {
            try
            {
                tokenData.put("id", "" + user.getIdUser());
                tokenData.put("role", (user.getRole()).getValue());
                tokenData.put("email", user.getEmail());
                tokenData.put("login", user.getLogin());
                String token = Jwts.builder()
                        .setHeaderParam("typ", "JWT")
                        .setClaims(tokenData)
                        .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                        .compact();
                return token;
            }
            catch (Exception e)
            {
                throw new Exception("Authentication error");
            }
        }
        else
        {
            return null;
        }
    }

    public String getEmailFromToken(String token)
    {
        Claims claims;
        claims = (Claims) Jwts.parser().setSigningKey(SECRET_KEY).parse(token).getBody();
        String email = claims.get("email", String.class);
        return email;
    }

    public int getIdFromToken(String token)
    {
        Claims claims;
        claims = (Claims) Jwts.parser().setSigningKey(SECRET_KEY).parse(token).getBody();
        String  string_id = claims.get("id", String .class);
        int id = Integer.parseInt(string_id);
        return id;
    }

    public String getLoginFromToken(String token){
        Claims claims;
        claims = (Claims)Jwts.parser().setSigningKey(SECRET_KEY).parse(token).getBody();
        String login = claims.get("login", String.class);
        return login;
    }
}
