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

    public void incorrectIntegerInput(){
        logger.log("Please enter an integer (Example : 3).");
    }

    public void incorrectFloatInput(){
        logger.log("Please enter a decimal number (Example : 3,2).");
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

    public void productFound()
    {
        logger.log("Product found !");
    }


}
