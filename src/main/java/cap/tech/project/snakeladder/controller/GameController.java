package cap.tech.project.snakeladder.controller;

import cap.tech.project.snakeladder.service.GameService;
import cap.tech.project.snakeladder.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
	@Autowired
	private GameServiceImpl gameService;
	
	@RequestMapping(value = "/game")
	public ResponseEntity<?> getStarted(@RequestBody String postMsg) {
			return gameService.startGame(postMsg);
	}

	@RequestMapping(value = "/game/progress")
	public ResponseEntity<?> inProgressGame(@RequestBody String count) {
		try {
			return gameService.gameLogic(Integer.parseInt(count));
		} catch(Exception e) {
			return new ResponseEntity<>("Please enter correct input.", HttpStatus.BAD_REQUEST);
		}
	}

}
