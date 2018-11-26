package restaurant;

import logger.src.logger.Logger;

public class Display {
    private Logger logger;

    public Display(Logger logger){
        this.logger = logger;
    }

    public void title()
    {
        logger.log("Welcome in Bagel&Klo management system !");
    }

    public void ask()
    {
        logger.log("What do you want to do ?");
    }

    public void successOperation()
    {
        logger.log("Successfull Operation !");
    }

    public void failedOperation(String error){
        logger.log("Operation failed : " + error);
    }

    public void show(String text)
    {
        logger.log(text);
    }

    public void showHelp()
    {

    }


}
