package cap.tech.project.snakeladder.controller;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class Game {
    private int position;
    private String status;

    private Map<Integer, Integer> ladder;
    private Map<Integer, Integer> snake;

    public Game() {
        ladder = new HashMap<>();
        snake = new HashMap<>();
        initialiseLadder(ladder);
        initialiseSnake(snake);
    }

    private void initialiseSnake(Map<Integer, Integer> snake) {
        snake.put(99,63);
        snake.put(59,17);
        snake.put(93,36);
        snake.put(32,10);
        snake.put(42,19);
        snake.put(76,49);
    }

    private void initialiseLadder(Map<Integer, Integer> ladder) {
        ladder.put(3,44);
        ladder.put(21,61);
        ladder.put(51,67);
        ladder.put(9,31);
        ladder.put(72,91);
        ladder.put(28,84);
        ladder.put(79, 95);
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Map<Integer, Integer> getLadder() {
        return ladder;
    }

    public Map<Integer, Integer> getSnake() {
        return snake;
    }
}
