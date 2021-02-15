package ChainofResponsibilityPattern;

/**
 * @author lvyue
 * @since 2021/1/30
 */
public class ConsoleLogger extends AbstractLogger {
    public ConsoleLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Info::Logger: " + message);
    }
}
