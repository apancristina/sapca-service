package com.apan.sapca.controller;

import com.apan.sapca.service.model.Game;
import com.apan.sapca.service.model.Player;
import com.apan.sapca.service.model.Team;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by apanc on 2/28/2016.
 */
@Controller
public class GameController {

    private static List<Game> games;

    static{
        games= populateDummyGames();
    }

    private static List<Game> populateDummyGames() {

        List<Game> games = new ArrayList<>();
        Game game = new Game();
        game.setId(1);
        Player player1 = new Player();
        player1.setName("Cris");
        Player player2 = new Player();
        player2.setName("Sql");
        Team team = new Team();
        team.setId(1);
        team.setName("The roosters");
        team.setPlayers(newArrayList(player1, player2));
        game.setTeams(newArrayList(team));
        games.add(game);
        return games;
    }


    //-------------------Retrieve All Games--------------------------------------------------------

    @RequestMapping(value = "/game", method = RequestMethod.GET)
    public ResponseEntity<List<Game>> listAllGames() {
        if (games.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(games, HttpStatus.OK);
    }


    //-------------------Retrieve Single Game--------------------------------------------------------

    @RequestMapping(value = "/game/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Game> getGame(@PathVariable("id") long id) {
        System.out.println("Fetching Game with id " + id);
        Game game = findById(id);
        if (game == null) {
            System.out.println("Game with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    private Game findById(final long id) {
        return games.stream()
                .filter(game -> game.getId() == id)
                .findAny()
                .orElse(null);
    }


    //-------------------Create a Game--------------------------------------------------------

    @RequestMapping(value = "/game/", method = RequestMethod.POST)
    public ResponseEntity<Void> createGame(@RequestBody Game game,    UriComponentsBuilder ucBuilder) {
/*
        System.out.println("Creating Game " + game.getId());

        if (gameService.isGameExist(game)) {
            System.out.println("A Game with name " + game.getName() + " already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

        gameService.saveGame(game);
*/

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/game/{id}").buildAndExpand(game.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a Game --------------------------------------------------------

    @RequestMapping(value = "/game/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Game> updateGame(@PathVariable("id") long id, @RequestBody Game game) {
/*
        System.out.println("Updating Game " + id);

        Game currentGame = gameService.findById(id);

        if (currentGame==null) {
            System.out.println("Game with id " + id + " not found");
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }

        currentGame.setName(game.getName());
        currentGame.setAge(game.getAge());
        currentGame.setSalary(game.getSalary());

        gameService.updateGame(currentGame);
*/
        return new ResponseEntity<>(game, HttpStatus.OK);
    }

    //------------------- Delete a Game --------------------------------------------------------

    @RequestMapping(value = "/game/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Game> deleteGame(@PathVariable("id") long id) {
        /*System.out.println("Fetching & Deleting Game with id " + id);

        Game game = gameService.findById(id);
        if (game == null) {
            System.out.println("Unable to delete. Game with id " + id + " not found");
            return new ResponseEntity<Game>(HttpStatus.NOT_FOUND);
        }

        gameService.deleteGameById(id);*/
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    //------------------- Delete All Games --------------------------------------------------------

    @RequestMapping(value = "/game/", method = RequestMethod.DELETE)
    public ResponseEntity<Game> deleteAllGames() {
     /*   System.out.println("Deleting All Games");

        gameService.deleteAllGames();*/
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

