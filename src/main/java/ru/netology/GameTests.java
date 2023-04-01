package ru.netology;
import org.junit.jupiter.api.Assertions;

import org.junit.Test;

public class GameTests {
    @Test
    public void firstPlayerWinTest() {
        Game game = new Game();
        Player player1 = new Player(1, "Oleg", 40);
        Player player2 = new Player(2, "Dima", 10);
        game.register(player1);
        game.register(player2);
        int actual = game.round("Oleg", "Dima");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void secondPlayerWinTest() {
        Game game = new Game();
        Player player1 = new Player(1, "Oleg", 40);
        Player player2 = new Player(2, "Dima", 100);
        game.register(player1);
        game.register(player2);
        int actual = game.round("Oleg", "Dima");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void drawInTheGame() {
        Game game = new Game();
        Player player1 = new Player(1, "Oleg", 50);
        Player player2 = new Player(2, "Dima", 50);
        game.register(player1);
        game.register(player2);
        int actual = game.round("Oleg", "Dima");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void firstPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Oleg", 40);
        Player player2 = new Player(2, "Dima", 10);
        game.register(player1);
        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Gena", "Dima")
                );

    }

    @Test
    public void secondPlayerNotRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Oleg", 40);
        Player player2 = new Player(2, "Dima", 10);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Oleg", "Andrey")
        );
    }
    @Test
    public void noPlayerRegistered() {
        Game game = new Game();
        Player player1 = new Player(1, "Oleg", 40);
        Player player2 = new Player(2, "Dima", 10);
        game.register(player1);
        game.register(player2);
        Assertions.assertThrows(NotRegisteredException.class,
                () -> game.round("Gena", "Andrey")
        );
    }
}
