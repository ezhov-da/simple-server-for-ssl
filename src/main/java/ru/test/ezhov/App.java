package ru.test.ezhov;

import static spark.Spark.*;

/**
 * Это самое простое приложение предназначенное для получения SSL сертификата от Let’s Encrypt
 * https://zerossl.com/
 * Для импорта сертификата используется keystore-explorer
 */
public class App {
    public static void main(String[] args) {
        port(8080);
        System.out.println(System.getProperty("user.home"));
        staticFiles.externalLocation(System.getProperty("user.home") + "/public/webroot");
        get("/test", (request, response) -> "text");
    }
}
