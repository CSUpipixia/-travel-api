package org.csu.travel.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.csu.travel.annotation.Authorize;
import org.csu.travel.domain.Account;
import org.csu.travel.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Autowired
    private AccountService accountService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {

        //如果不是映射到方法直接通过
        if(!(object instanceof HandlerMethod)) { return true; }

        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        if (method.isAnnotationPresent(Authorize.class)) {
            Authorize userLoginToken = method.getAnnotation(Authorize.class);
            if (userLoginToken.required()) {

                String token = request.getHeader("authorization");// 从 http 请求头中取出 token

                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // 获取 token 中的 user id
                String userId;
                try {
                    // 获取 userid
                    userId = JWT.decode(token).getKeyId();
                    // 添加request参数，用于传递userid
                    request.setAttribute("currentUser", userId);
                    // 根据userId 查询用户信息
                    Account account = accountService.getAccount(userId);
                    if (account == null) {
                        throw new RuntimeException("用户不存在，请重新登录");
                    }

                    try {
                        String session_key = JWT.decode(token).getClaim("session_key").as(String.class);
                        // 添加request参数，用于传递userid
                        request.setAttribute("sessionKey", session_key);
                    }
                    catch (Exception e){
                    }

                    // 验证 密码
                    JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(account.getPassword())).build();
                    try {
                        jwtVerifier.verify(token);
                    } catch (JWTVerificationException e) {
                        throw new RuntimeException("401");
                    }
                } catch (JWTDecodeException j) {
                    throw new RuntimeException("401");
                }

                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    //拦截器：请求之后：afterCompletion
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

}
