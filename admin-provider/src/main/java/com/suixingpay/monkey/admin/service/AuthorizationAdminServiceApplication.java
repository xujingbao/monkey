/**
 *
 */
package com.suixingpay.monkey.admin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 */
@SpringBootApplication
@ImportResource(value = {"classpath:authorization_admin_service/admin-service-context.xml"})
public class AuthorizationAdminServiceApplication {

    private static LinkedBlockingDeque<Boolean> run = new LinkedBlockingDeque<Boolean>();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

        SpringApplication springApplication = new SpringApplication(AuthorizationAdminServiceApplication.class);

        springApplication.run(args);

        while (run.take()) {
        }
    }

    /**
     * Stop.
     */
    static void stop() {
        run.add(false);
    }

}
