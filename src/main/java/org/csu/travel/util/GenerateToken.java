package org.csu.travel.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.csu.travel.domain.Account;

import java.util.Date;

public class GenerateToken {
    public static String getToken(Account account) {
        String token = "";
        token= JWT.create()
                .withKeyId(account.getUsername())
                .withIssuer("www.ikertimes.com")
                .withIssuedAt(new Date())
                .withJWTId("jwt.ikertimes.com")
                .withClaim("session_key", account.getSessionKey())
                .withAudience(account.getUsername())
                .sign(Algorithm.HMAC256(account.getPassword()));
        return token;
    }
}
