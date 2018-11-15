package logger.src.logger;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class ContextualLogger implements Logger {

    private Logger delegateLogger;
    private Object callerClass;
    private final DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public ContextualLogger(Logger delegateLogger, Object callerClass){
        this.delegateLogger = delegateLogger;
        this.callerClass = callerClass;
    }

    @Override
    public void log(String message)
    {
        delegateLogger.log( sdf.format( new Date() ) + " " + callerClass + " " + message );
    }

}
