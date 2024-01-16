package fr.miage.playerservice.controller;

import fr.miage.playerservice.model.PlayerModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/")
@Api(value = "Player Management System")
public class PlayerController {
    List<PlayerModel> playerList = new ArrayList<>();
    PlayerController(){
        PlayerModel p1 = new PlayerModel();
        p1.setId(1);
        p1.setTeamId(1);
        p1.setLastName("Atal");
        p1.setName("Youcef");
        p1.setJerseyNumber(2);

        PlayerModel p2 = new PlayerModel();
        p2.setId(2);
        p2.setTeamId(1);
        p2.setLastName("Atal");
        p2.setName("Youcef");
        p2.setJerseyNumber(2);

        PlayerModel p3 = new PlayerModel();
        p3.setId(3);
        p3.setTeamId(1);
        p3.setLastName("Atal");
        p3.setName("Youcef");
        p3.setJerseyNumber(2);

        PlayerModel p4 = new PlayerModel();
        p4.setId(4);
        p4.setTeamId(1);
        p4.setLastName("Maolida");
        p4.setName("Myziane");
        p4.setJerseyNumber(11);

        PlayerModel p5 = new PlayerModel();
        p5.setId(5);
        p5.setTeamId(1);
        p5.setLastName("Thuram-Ulien");
        p5.setName("Marcus");
        p5.setJerseyNumber(29);

// Joueur 6
        PlayerModel p6 = new PlayerModel();
        p6.setId(6);
        p6.setTeamId(3);
        p6.setLastName("Aouchiche");
        p6.setName("Adil");
        p6.setJerseyNumber(17);

// Joueur 7
        PlayerModel p7 = new PlayerModel();
        p7.setId(7);
        p7.setTeamId(3);
        p7.setLastName("Moukoudi");
        p7.setName("Harold");
        p7.setJerseyNumber(5);

// Joueur 8
        PlayerModel p8 = new PlayerModel();
        p8.setId(8);
        p8.setTeamId(3);
        p8.setLastName("Camara");
        p8.setName("Mahdi");
        p8.setJerseyNumber(6);

// Joueur 9
        PlayerModel p9 = new PlayerModel();
        p9.setId(9);
        p9.setTeamId(3);
        p9.setLastName("Moueffek");
        p9.setName("Lucas");
        p9.setJerseyNumber(27);

// Joueur 10
        PlayerModel p10 = new PlayerModel();
        p10.setId(10);
        p10.setTeamId(3);
        p10.setLastName("Abi");
        p10.setName("Charles");
        p10.setJerseyNumber(7);

        // Joueur 11
        PlayerModel p11 = new PlayerModel();
        p11.setId(11);
        p11.setTeamId(2);
        p11.setLastName("Depay");
        p11.setName("Memphis");
        p11.setJerseyNumber(10);

// Joueur 12
        PlayerModel p12 = new PlayerModel();
        p12.setId(12);
        p12.setTeamId(2);
        p12.setLastName("Aouar");
        p12.setName("Houssem");
        p12.setJerseyNumber(8);

// Joueur 13
        PlayerModel p13 = new PlayerModel();
        p13.setId(13);
        p13.setTeamId(2);
        p13.setLastName("Dubois");
        p13.setName("Léo");
        p13.setJerseyNumber(14);

// Joueur 14
        PlayerModel p14 = new PlayerModel();
        p14.setId(14);
        p14.setTeamId(2);
        p14.setLastName("Kadewere");
        p14.setName("Tinotenda");
        p14.setJerseyNumber(22);

// Joueur 15
        PlayerModel p15 = new PlayerModel();
        p15.setId(15);
        p15.setTeamId(2);
        p15.setLastName("Paqueta");
        p15.setName("Lucas");
        p15.setJerseyNumber(17);


        playerList.add(p1);
        playerList.add(p2);
        playerList.add(p3);
        playerList.add(p4);
        playerList.add(p5);
        playerList.add(p6);
        playerList.add(p7);
        playerList.add(p8);
        playerList.add(p9);
        playerList.add(p10);
        playerList.add(p11);
        playerList.add(p12);
        playerList.add(p13);
        playerList.add(p14);
        playerList.add(p15);
    }

    @GetMapping(value = "/players/{id}")
    @ApiOperation(value = "Get a player by their ID")
    public PlayerModel getTeam(@PathVariable(value = "id") int id){
        return playerList.stream()
                .filter(team -> team.getId() == id)
                .findAny()
                .orElse(null);
    }

    @PostMapping(value = "/players")
    @ApiOperation(value = "Add a new player")
    public PlayerModel addTeam(@RequestBody PlayerModel newTeam){
        playerList.add(newTeam);
        return newTeam;
    }

    @PutMapping(value = "/players/{id}")
    @ApiOperation(value = "Update a player by their ID")
    public PlayerModel updateTeam(@RequestBody PlayerModel playerUpdated, @PathVariable(value = "id") int id) {
        // Recherche de l'équipe avec l'ID spécifié
        Optional<PlayerModel> playerToUpdate = playerList.stream()
                .filter(team -> team.getId() == id)
                .findFirst();

        // Si l'équipe avec l'ID spécifié est trouvée, mettre à jour ses informations
        playerToUpdate.ifPresent(player -> {
            player.setTeamId(playerUpdated.getTeamId());
            player.setName(playerUpdated.getName());
            player.setLastName(playerUpdated.getLastName());
            player.setJerseyNumber(playerUpdated.getJerseyNumber());
        });

        return playerUpdated;
    }

    @DeleteMapping(value = "players/{id}")
    @ApiOperation(value = "Delete a player by their ID")
    public List<PlayerModel> deleteTeam(@PathVariable(value = "id") int id) {
        // Supprimer l'équipe avec l'ID spécifié
        playerList.removeIf(team -> team.getId() == id);

        return playerList;
    }
}
