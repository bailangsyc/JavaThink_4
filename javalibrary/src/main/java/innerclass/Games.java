package innerclass;

/**
 * 10.6.1 再访工厂方法
 * 通过匿名类来改进Games类
 *
 * 在第九章中最后提到：在设计中优先使用的时类，而不是接口，如果在设计中需要某个接口，必须要了解他们，否则，不到
 * 迫不得已，不要将接口放到设计中。接口会增加代码逻辑的复杂性。
 * Created by root on 17-9-16.
 */

/**
 * 接口Game 定义一个move（），返回值boolean
 * 接口工厂GameFactory 定义一个方法getGame 返回一个Game
 * <p>
 * checker类（棋手） 实现了Game接口（具有move的能力）  并且有一个静态的工厂用来产生Checker实例
 * <p>
 * chess类（棋） 也实现了Game接口（具有被move的功能）  同样具有一个静态的工厂用来产生chess实例
 */


// 接口Game 定义一个move（），返回值boolean
interface Game {
    boolean move();
}

// 接口工厂GameFactory 定义一个方法getGame 返回一个Game
interface GameFactory {
    Game getGame();
}

// checker类（棋手） 实现了Game接口（具有move的能力）  并且有一个静态的工厂用来产生Checker实例
class Checker implements Game {
    //构造是私有的
    private Checker() {
    }
    private int moves = 0;
    private static final int MOVES = 4;

    @Override
    public boolean move() {
        System.out.println("Checker moves :" + moves);
        return ++moves != MOVES ;
    }

    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Checker();
        }
    };


}


// chess类（棋） 也实现了Game接口（具有被move的功能）  同样具有一个静态的工厂用来产生chess实例
class Chess implements Game {
    private Chess(){}
    private int moves = 0;
    private static final int MOVES = 4;


    @Override
    public boolean move() {
        System.out.println("Chess moves:" + moves);
        return  ++moves != MOVES;
    }

    public static GameFactory factory = new GameFactory() {
        @Override
        public Game getGame() {
            return new Chess();
        }
    };
}



public class Games {
    public static void playGame(GameFactory factory) {
        Game game = factory.getGame();
        while (game.move()) {
            ;//不做任何操作
        }

    }

    public static void main(String[] args) {
        Games.playGame(Checker.factory);
        playGame(Chess.factory);
    }
}
