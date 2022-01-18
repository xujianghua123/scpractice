package com.util.config;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

/**
 * @Description
 * @Author xjh
 * @Date: 2021/12/8 19:59
 */
@Configuration
public class MongoDBConfig {

    private static final String serverAddress = "42.192.6.87";
    private static final int port = 27017;


    /**
     * 非认证方式连接
     *
     * @return
     */
    @Bean
    public static MongoDatabase getConn(){
        MongoClient mongoClient = new MongoClient(serverAddress, port);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        return mongoDatabase;
    }

    /**
     * 通过认证连接
     *
     * @return
     */
    @Bean
    public static MongoDatabase getConnByAuth(){

        MongoCredential scramSha1Credential = MongoCredential.createScramSha1Credential(
                "admin",
                "admin",
                "123456".toCharArray());
        List<MongoCredential> mongoCredentials = Arrays.asList(scramSha1Credential);

        ServerAddress serverAddress = new ServerAddress(MongoDBConfig.serverAddress, port);
        List<ServerAddress> serverAddresses = Arrays.asList(serverAddress);

        MongoClient mongoClient = new MongoClient(serverAddress, mongoCredentials);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("test");
        return mongoDatabase;
    }
}
