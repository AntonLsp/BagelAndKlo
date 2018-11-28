package logger;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ContextualLogger implements Logger{
    private String callerClass;
    private Logger delegateLogger;

    public ContextualLogger(String callerClass,Logger delagateLogger){
        this.callerClass = callerClass;
        this.delegateLogger = delagateLogger;
    }

    @Override
    public void info(String category, String message) {
        SimpleDateFormat logFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm.ss.SSS");
        delegateLogger.info(category,logFormat.format(new Date())+" "+ callerClass + " | " + message);
    }

    @Override
    public void error(String category, String message) {
        SimpleDateFormat logFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm.ss.SSS");
        delegateLogger.error(category,logFormat.format(new Date())+" "+ callerClass + " | " + message);
    }
}

