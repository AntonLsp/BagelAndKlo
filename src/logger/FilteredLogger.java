package logger;

import java.util.function.Predicate;

public class FilteredLogger implements Logger{

    private Logger delegate;
    private Predicate<String> condition;


    public FilteredLogger(Logger delegate, Predicate<String> condition){
        this.condition=condition;
        this.delegate=delegate;
    }

    @Override
    public void info(String category, String message){
        if (condition.test(message)){
            delegate.info(category,message);
        }
    }

    @Override
    public void error(String category, String message) {
        if (condition.test(message)){
            delegate.error(category,message);
        }
    }
}

