package fr.miage.statsservice.controller;

import fr.miage.statsservice.service.StatsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(value = "Stats Management System")
@RestController
@RequestMapping(value = "/")
@RequiredArgsConstructor
public class StatsController {

    private final StatsService statsService;

    @ApiOperation(value = "Get team stats by team ID")
    @GetMapping(value = "/team-stats/{id}")
    public Object getTeamStats(@PathVariable(value = "id") int id) {
        return statsService.getTeamStats(id);
    }

    @ApiOperation(value = "Get player stats by player ID")
    @GetMapping(value = "/player-stats/{id}")
    public Object getPlayerStats(@PathVariable(value = "id") int id) {
        return statsService.getPlayerStats(id);
    }
}
