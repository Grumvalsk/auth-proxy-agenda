package com.grumvalsky.authagenda.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtUtil {


        private static final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256); // Chiave segreta generata in modo sicuro
        private static final long EXPIRATION_TIME = 864_000_000; // 10 giorni in millisecondi

        public static String generateToken(String username) {
            Date now = new Date();
            Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

            return Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(now)
                    .setExpiration(expiryDate)
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();
        }

}
