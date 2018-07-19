package designpatterns.chainofresponsibility;

public abstract class AbstractLogger {
    public static final int INFO = 1;
    public static final int DEBUG = 2;
    public static final int ERROR =3;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger logger){
        this.nextLogger = logger;
    }

    public void logMessage(int level, String message){
        if( this.level <= level ){
            write(message);
        }
        if( nextLogger != null){
            nextLogger.logMessage(level,message);
        }
    }

    protected abstract void write(String message);
}