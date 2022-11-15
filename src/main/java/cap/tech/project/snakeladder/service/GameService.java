package cap.tech.project.snakeladder.service;

import org.springframework.http.ResponseEntity;

public interface GameService {
    ResponseEntity<?> gameLogic(Integer count);

    ResponseEntity<?> startGame(String msg);
}
