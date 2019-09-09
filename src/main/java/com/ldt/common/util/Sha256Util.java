package com.ldt.common.util;

import org.apache.commons.codec.digest.DigestUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Sha256Util {
    public static String toSha256(String text) {
        return DigestUtils.sha256Hex(text);
    }

    public static String sign(String key, String value) throws NoSuchAlgorithmException {
        final Charset charSet = StandardCharsets.US_ASCII;
        final Mac sha256HMAC = Mac.getInstance("HmacSHA256");

        final SecretKeySpec secretKey = new SecretKeySpec(charSet.encode(key).array(), "HmacSHA256");
        try {
            sha256HMAC.init(secretKey);
            final byte[] macData = sha256HMAC.doFinal(charSet.encode(value).array());
            StringBuilder result = new StringBuilder();
            for (final byte element : macData) {
                result.append(Integer.toString((element & 0xff) + 0x100, 16).substring(1));
            }
            return result.toString();
        } catch (InvalidKeyException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
