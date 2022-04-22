package com.zeabix.userprofile.config;

import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;

@SuppressWarnings("unused")
@Configuration
public class MongoConfig {

    @Value("${persistent.mongodb.connection}")
    private String connectionUrl;

    @Value(("${persistent.mongodb.dbname}"))
    private String dbName;

    @Bean
    public ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory(){
        return new SimpleReactiveMongoDatabaseFactory(
                MongoClients.create(connectionUrl), dbName
        );
    }

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate(){
        return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory());
    }
}
