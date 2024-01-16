package fr.miage.teamservice.model;

import lombok.Getter;
import lombok.Setter;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Details about a team")
@Getter
@Setter
public class TeamModel {

    @ApiModelProperty(notes = "The unique ID of the team")
    private int id;

    @ApiModelProperty(notes = "The name of the team")
    private String name;

    @ApiModelProperty(notes = "The location of the team")
    private String location;

    @ApiModelProperty(notes = "The number of victories of the team")
    private int victoryCount;
}

