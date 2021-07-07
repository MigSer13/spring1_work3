package ru.geekbrains.market.services;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;

@Component
public class MySessionFactory {
    private SessionFactory sessionFactory;
    private String pathToConfig;

    public MySessionFactory(String pathToConfig) {
        this.pathToConfig = pathToConfig;
        sessionFactory = new Configuration()
                .configure(pathToConfig).buildSessionFactory();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
