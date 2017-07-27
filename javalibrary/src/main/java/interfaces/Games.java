package interfaces;

/**
 * 9.9 接口与工厂
 * Created by shao on 17-7-28.
 */

interface Game {
    boolean move();
}

interface GameFactory {
    Game getGame();
}

//checkers 西洋跳棋
class Checkers implements Game {
    private int moves = 0;//开始未走一步
    private static  final int  MOVES = 3;
    @Override
    public boolean move() {
        System.out.println("checker move" + moves);
        return ++moves != MOVES; //返回true
    }
}

class CheckersFactory implements GameFactory {
    @Override
    public Game getGame() {
        return new Checkers();
    }
}

//国际象棋
class Chess implements Game {
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("chess move" + moves);
        return ++moves != MOVES;//返回true
    }
}

class ChessFactory implements GameFactory {

    @Override
    public Game getGame() {
        return new Chess();
    }
}


public class Games {

    public static void main(String[] args) {
        playGame(new CheckersFactory());
        playGame(new ChessFactory());
    }

    private static void playGame(GameFactory factory) {
        Game game = factory.getGame();//真正返回的是Checkers
        while (game.move())
            ;
    }
}
