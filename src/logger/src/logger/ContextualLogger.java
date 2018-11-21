package logger.src.logger;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.Date;

public class ContextualLogger implements Logger{
    private String callerClass;
    private Logger delagateLogger;

    public ContextualLogger(String callerClass,Logger delagateLogger){
        this.callerClass = callerClass;
        this.delagateLogger = delagateLogger;
    }

    @Override
    public void log(String message) {
        SimpleDateFormat logFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm.ss.SSS");
        delagateLogger.log(logFormat.format(new Date())+""+ callerClass + " |        " + message);
    }
}

