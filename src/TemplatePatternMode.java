/**
 * 模板模式。
 *
 * @author lvyue
 * @since 2021/1/26
 */
public class TemplatePatternMode {
    public static void main(String[] args) {
        Game game = new Cricket();
        game.initialize();
        game.startPlay();
        game.endPlay();
    }
}

abstract class Game {
    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    public final void play() {
        initialize();
        startPlay();
        endPlay();
    }
}

class Cricket extends Game {

    @Override
    void initialize() {
        System.out.println("Cricket Game Finished!");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket Game Initialized! Start playing.");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket Game Started. Enjoy the game!");
    }
}
