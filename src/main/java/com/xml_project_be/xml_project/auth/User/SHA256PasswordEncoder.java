package com.xml_project_be.xml_project.auth.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SHA256PasswordEncoder {

    public static String encodePassword(String rawPassword) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedHash = digest.digest(rawPassword.getBytes());
            return Base64.getEncoder().encodeToString(encodedHash); // Возвращаем строку в Base64 для удобства хранения
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Ошибка хэширования", e);
        }
    }

    public static boolean matches(String rawPassword, String encodedPassword) {
        return encodedPassword.equals(encodePassword(rawPassword));
    }
}