package com.alamin.dice_game_backend.controller;

import com.alamin.dice_game_backend.dto.GameResponse;
import com.alamin.dice_game_backend.dto.PlayerRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*") //allow dev server
public class DiceGameController {
    private final Random random=new Random();
    boolean correct;
    String msg;

    @GetMapping("/health")
    public ResponseEntity<String> health(){
        return ResponseEntity.ok("OK");
    }
    @PostMapping("/v1/guess")
    public ResponseEntity<GameResponse> guess(@RequestBody PlayerRequest request){
        int playerGuess=request.getGuess();
        int rolledNumber=random.nextInt(6) + 1;

        if (playerGuess< 1 || playerGuess>6){
            return ResponseEntity.badRequest().build();
        }
        if(playerGuess==rolledNumber){
           msg="Correct! The dice rolled "+ rolledNumber+"!";
           correct=true;

        }else {
            msg= "Wrong! You guessed " + playerGuess+ " but the dice rolled " + rolledNumber ;
            correct=false;
        }
        return ResponseEntity.ok(new GameResponse(correct,rolledNumber,playerGuess,msg));

    }

}
