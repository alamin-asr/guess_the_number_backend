package com.alamin.dice_game_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameResponse {
    private Boolean correct;
    private int rolledNumber;
    private int userGuess;
    private String message;

}
