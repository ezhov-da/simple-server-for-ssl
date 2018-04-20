package ru.test.ezhov;

import static spark.Spark.*;

/**
 * Это самое простое приложение предназначенное для получения SSL сертификата от Let’s Encrypt
 * https://zerossl.com/
 * Для импорта сертификата используется keystore-explorer
 */
public class App {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("USE ARGUMENT PORT...");
            System.out.println("EXIT");
            return;
        }
        int port = Integer.parseInt(args[0]);
        System.out.println("PORT: " + port);
        port(port);
        String userHome = System.getProperty("user.home");
        System.out.println("SERVER START");
        System.out.println("USER HOME: " + userHome);
        String directoryWebRoot = userHome + "/public/webroot";
        System.out.println("DIRECTORY WEB ROOT: " + directoryWebRoot);
        System.out.println("FOR TEST PATH: " + "/test");
        System.out.println();
        staticFiles.externalLocation(directoryWebRoot);
        get("/test", (request, response) -> "text");
    }
}
