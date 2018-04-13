package com.kuyucak.projects.sessionsample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SessionsampleApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(SessionsampleApplication.class, args);
    }
}
