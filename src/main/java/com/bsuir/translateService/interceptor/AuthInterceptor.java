package com.bsuir.translateService.interceptor;

import com.bsuir.translateService.entity.UserEntity;
import com.bsuir.translateService.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.SignatureException;

/**
 * Created by Олег Пятко on 16.05.2017.
 */
@CrossOrigin
@Scope("AuthInterceptor")
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private UserService userService;
    @Value("${jwt.secret}")
    private String SECRET;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (request.getMethod().equals("OPTIONS")) return true;

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            response.sendError(401);
            return false;
        }
        String token = authHeader.substring(7); // The part after "Bearer "

        Claims claims = null;
        claims = Jwts.parser().setSigningKey(SECRET)
                .parseClaimsJws(token).getBody();
        int userId = Integer.parseInt(claims.getSubject());
        UserEntity user = userService.findById(userId);
        if(user == null) {
            return false;
        }
        request.setAttribute("user", user);

        return claims != null;
    }
}