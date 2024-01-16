package fr.miage.playerservice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Details about a player")
public class PlayerModel {
    @ApiModelProperty(notes = "The unique ID of the player")
    private int id;

    @ApiModelProperty(notes = "The ID of the team to which the player belongs")
    private int teamId;

    @ApiModelProperty(notes = "The first name of the player")
    private String name;

    @ApiModelProperty(notes = "The last name of the player")
    private String lastName;

    @ApiModelProperty(notes = "The jersey number of the player")
    private int jerseyNumber;
}
