package com.flexhamp.jwtserver.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Encoders;

import javax.crypto.SecretKey;

public class GenerateKeys {

    public static void main(String[] args) {
        System.out.println(generateKey());
        System.out.println(generateKey());
    }

    private static String generateKey() {
        final SecretKey secretKey = Jwts.SIG.HS512.key().build();
        return Encoders.BASE64.encode(secretKey.getEncoded());
    }

}