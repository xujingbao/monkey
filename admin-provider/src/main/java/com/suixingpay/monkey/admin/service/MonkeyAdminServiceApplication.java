package com.suixingpay.monkey.admin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created By Evan Xu
 */
@SpringBootApplication
@ImportResource(value = {"classpath:admin-service-context.xml"})
public class MonkeyAdminServiceApplication {

    private static LinkedBlockingDeque<Boolean> run = new LinkedBlockingDeque<Boolean>();

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {

        SpringApplication springApplication = new SpringApplication(MonkeyAdminServiceApplication.class);

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
