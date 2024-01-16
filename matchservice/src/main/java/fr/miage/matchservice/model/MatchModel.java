package fr.miage.matchservice.model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@ApiModel(description = "Details about a match")
@Getter
@Setter
public class MatchModel {

    @ApiModelProperty(notes = "The unique ID of the match")
    private int id;

    @ApiModelProperty(notes = "The ID of the team playing as the home team")
    private int teamIdTo;

    @ApiModelProperty(notes = "The ID of the team playing as the away team")
    private int teamIdFrom;

    @ApiModelProperty(notes = "The location where the match is played")
    private String location;

    @ApiModelProperty(notes = "The date of the match")
    private LocalDate date;
}

