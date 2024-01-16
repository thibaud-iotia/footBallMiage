package fr.miage.matchservice.controller;

import fr.miage.matchservice.model.MatchModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Api(value = "Match Management System")
@RestController
@RequestMapping(value = "/")
public class MatchController {

    List<MatchModel> matchModelList = new ArrayList<>();

    MatchController() {
        MatchModel m1 = new MatchModel();
        m1.setId(1);
        m1.setTeamIdTo(1);
        m1.setTeamIdFrom(2);
        m1.setLocation("Nice");
        m1.setDate(LocalDate.parse("2023-02-02"));

        MatchModel m2 = new MatchModel();
        m2.setId(2);
        m2.setTeamIdTo(4);
        m2.setTeamIdFrom(5);
        m2.setLocation("Lyon");
        m2.setDate(LocalDate.parse("2023-02-02"));

        matchModelList.add(m1);
        matchModelList.add(m2);
    }

    @ApiOperation(value = "Get a match by its ID")
    @GetMapping(value = "/matches/{id}")
    public MatchModel getMatch(@PathVariable(value = "id") int id) {
        return matchModelList.stream()
                .filter(match -> match.getId() == id)
                .findAny()
                .orElse(null);
    }

    @ApiOperation(value = "Add a new match")
    @PostMapping(value = "/matches")
    public MatchModel addMatch(@RequestBody MatchModel newMatch) {
        matchModelList.add(newMatch);
        return newMatch;
    }

    @ApiOperation(value = "Update a match by its ID")
    @PutMapping(value = "/matches/{id}")
    public MatchModel updateMatch(@RequestBody MatchModel matchUpdated, @PathVariable(value = "id") int id) {
        // Recherche du match avec l'ID spécifié
        Optional<MatchModel> matchToUpdate = matchModelList.stream()
                .filter(match -> match.getId() == id)
                .findFirst();

        // Mise à jour des informations du match
        matchToUpdate.ifPresent(match -> {
            match.setTeamIdFrom(matchUpdated.getTeamIdFrom());
            match.setTeamIdTo(matchUpdated.getTeamIdTo());
            match.setDate(matchUpdated.getDate());
            match.setLocation(matchUpdated.getLocation());
        });

        return matchUpdated;
    }

    @ApiOperation(value = "Delete a match by its ID")
    @DeleteMapping(value = "matches/{id}")
    public List<MatchModel> deleteMatch(@PathVariable(value = "id") int id) {
        // Supprimer le match avec l'ID spécifié
        matchModelList.removeIf(match -> match.getId() == id);

        return matchModelList;
    }
}
