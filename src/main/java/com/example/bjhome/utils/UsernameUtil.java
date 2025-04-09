package com.example.bjhome.utils;

import java.util.Random;

public class UsernameUtil {

    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBERS = "0123456789";
    private static final Random random = new Random();

    public static String generateRandomUsername() {
        StringBuilder username = new StringBuilder();

        // 生成3-5个随机字母作为前缀
        int prefixLength = 3 + random.nextInt(3);
        for (int i = 0; i < prefixLength; i++) {
            username.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }

        // 生成2-4个随机数字作为后缀
        int suffixLength = 2 + random.nextInt(3);
        for (int i = 0; i < suffixLength; i++) {
            username.append(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        }

        return username.toString();
    }

}
