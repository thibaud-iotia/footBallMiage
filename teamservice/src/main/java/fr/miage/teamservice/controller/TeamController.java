package fr.miage.teamservice.controller;

import fr.miage.teamservice.model.TeamModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Api(value = "Football team service")
@RestController
@RequestMapping(value = "/")
public class TeamController {
    List<TeamModel> teamModelList = new ArrayList<>();
    TeamController(){
        TeamModel t1 = new TeamModel();
        t1.setId(1);
        t1.setLocation("Nice");
        t1.setName("OGC");
        t1.setVictoryCount(2);

        TeamModel t2 = new TeamModel();
        t2.setId(2);
        t2.setLocation("Lyon");
        t2.setName("OL");
        t2.setVictoryCount(5);

        TeamModel t3 = new TeamModel();
        t3.setId(3);
        t3.setLocation("Saint Etienne");
        t3.setName("ASSE");
        t3.setVictoryCount(4);

        teamModelList.add(t1);
        teamModelList.add(t2);
        teamModelList.add(t3);

    }

    @ApiOperation(value = "Get a team by its ID")
    @GetMapping(value = "/teams/{id}")
    public TeamModel getTeam(@PathVariable(value = "id") int id){
        return teamModelList.stream()
                .filter(team -> team.getId() == id)
                .findAny()
                .orElse(null);
    }

    @ApiOperation(value = "Add a new team")
    @PostMapping(value = "/teams")
    public TeamModel addTeam(@RequestBody TeamModel newTeam){
        teamModelList.add(newTeam);
        return newTeam;
    }

    @ApiOperation(value = "Update a team by its ID")
    @PutMapping(value = "/teams/{id}")
    public TeamModel updateTeam(@RequestBody TeamModel updatedTeam, @PathVariable(value = "id") int id) {
        // Recherche de l'équipe avec l'ID spécifié
        Optional<TeamModel> teamToUpdate = teamModelList.stream()
                .filter(team -> team.getId() == id)
                .findFirst();

        // Si l'équipe avec l'ID spécifié est trouvée, mettre à jour ses informations
        teamToUpdate.ifPresent(team -> {
            team.setName(updatedTeam.getName());
            team.setLocation(updatedTeam.getLocation());
            team.setVictoryCount(updatedTeam.getVictoryCount());
        });

        return updatedTeam;
    }

    @ApiOperation(value = "Delete a team by its ID")
    @DeleteMapping(value = "teams/{id}")
    public List<TeamModel> deleteTeam(@PathVariable(value = "id") int id) {
        // Supprimer l'équipe avec l'ID spécifié
        teamModelList.removeIf(team -> team.getId() == id);

        return teamModelList;
    }
}
