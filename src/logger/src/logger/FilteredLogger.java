package logger.src.logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger{

    private Logger delagate;
    private Predicate<String> condition;


    public FilteredLogger(Logger delegate, Predicate<String> condition){
        this.condition=condition;
        this.delagate=delegate;
    }

    @Override
    public void log(String message) {
        if (condition.test(message)){
            delagate.log(message);
        }
    }
}

