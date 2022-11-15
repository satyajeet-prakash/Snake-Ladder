package cap.tech.project.snakeladder.service;

import cap.tech.project.snakeladder.controller.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl  implements GameService{

    @Autowired
    private Game game;
    @Override
    public ResponseEntity<?> gameLogic(Integer count) {
        if(!"STARTED".equalsIgnoreCase(game.getStatus()))
            return new ResponseEntity<>("Game is not started, Please start the game.", HttpStatus.BAD_REQUEST);
        if(count < 0 || count > 6)
            return new ResponseEntity<>("Dice Count should be in range [0-6]", HttpStatus.BAD_REQUEST);
        if(game.getPosition() + count == 100) {
            game.setStatus("COMPLETED");
            game.setPosition(0);
            return new ResponseEntity<>("Winner", HttpStatus.OK);
        }
        if(game.getPosition() + count < 100) {
            int current = game.getPosition() + count;
            if(game.getSnake().containsKey(current)) {
                game.setPosition(game.getSnake().get(current));
            } else if(game.getLadder().containsKey(current)) {
                game.setPosition(game.getLadder().get(current));
            } else {
                game.setPosition(current);
            }
        }
        return new ResponseEntity<>("Current Position: " + game.getPosition(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> startGame(String postMsg) {
        String msg = postMsg.replaceAll("\"", "");
        if(msg.equalsIgnoreCase("START")) {
            game.setStatus("STARTED");
            game.setPosition(0);
            return ResponseEntity.ok("READY");
        }
        return ResponseEntity.ok("DID NOT GET REQUIRED START REQUEST YET.");
    }
}
