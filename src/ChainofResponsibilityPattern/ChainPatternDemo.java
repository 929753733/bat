package ChainofResponsibilityPattern;

/**
 * @author lvyue
 * @since 2021/1/30
 */
public class ChainPatternDemo {

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new DebugLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();
        loggerChain.logMessage(AbstractLogger.INFO, "This is an info information.");
        System.out.println("========================");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug information.");
        System.out.println("========================");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }
}
