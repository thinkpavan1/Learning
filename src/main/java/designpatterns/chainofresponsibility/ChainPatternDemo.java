package designpatterns.chainofresponsibility;

public class ChainPatternDemo {
    public static void main(String[] args) {
        AbstractLogger logger = getLogger();
        logger.logMessage(AbstractLogger.ERROR,"Error message");
        logger.logMessage(AbstractLogger.DEBUG,"Debug message");
        logger.logMessage(AbstractLogger.INFO,"Info message");

    }

    private static AbstractLogger getLogger() {
        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger infoLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(infoLogger);
        return errorLogger;
    }
}
