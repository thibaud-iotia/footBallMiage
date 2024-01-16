package fr.miage.statsservice.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@Service
public class StatsService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "callStatsServiceFallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMillisecond", value = "1000")})
    public Object getTeamStats(int id) {
        return this.restTemplate.exchange("http://127.0.0.1:8080/teams/{id}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, id).getBody();
    }

    @HystrixCommand(fallbackMethod = "callStatsServiceFallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMillisecond", value = "1000")})
    public Object getPlayerStats(int id) {
        return this.restTemplate.exchange("http://127.0.0.1:8888/players/{id}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, id).getBody();
    }

    private String callStatsServiceFallBack(int id) {
        System.out.println("Student Service is down!!! fallback route enabled...");
        return "CIRCUIT BREAKER ENABLED!!!No Response From Stats Service at this moment. Service will be back shortly - " + new Date();
    }
}