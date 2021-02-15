package ChainofResponsibilityPattern;

/**
 * @author lvyue
 * @since 2021/1/30
 */
public class ErrorLogger extends AbstractLogger {
    public ErrorLogger(int level){
        this.level = level;
    }

    @Override
    protected void write(String message) {
        System.out.println("Error::Logger: " + message);
    }
}
