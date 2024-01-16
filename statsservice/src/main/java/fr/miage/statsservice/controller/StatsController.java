package fr.miage.statsservice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api(value = "Stats Management System")
@RestController
@RequestMapping(value = "/")
public class StatsController {

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "Get team stats by team ID")
    @GetMapping(value = "/team-stats/{id}")
    public Object getTeamStats(@PathVariable(value = "id") int id) {
        return this.restTemplate.exchange("http://127.0.0.1:8080/teams/{id}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, id).getBody();
    }

    @ApiOperation(value = "Get player stats by player ID")
    @GetMapping(value = "/player-stats/{id}")
    public Object getPlayerStats(@PathVariable(value = "id") int id) {
        return this.restTemplate.exchange("http://127.0.0.1:8888/players/{id}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {
                }, id).getBody();
    }
}
