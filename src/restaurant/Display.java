package restaurant;

import logger.Logger;

public class Display {
    private Logger logger;

    public Display(Logger logger){
        this.logger = logger;
    }

    public void title()
    {
        logger.info("PROGRAM","Welcome in Bagel&Klo management system !");
    }

    public void incorrectIntegerInput(){
        logger.error("OUTPUT","Please enter an integer (Example : 3).");
    }

    public void incorrectFloatInput(){
        logger.error("OUTPUT","Please enter a decimal number (Example : 3,2).");
    }

    public void successOperation()
    {
        logger.info("PROGRAM","Successfull Operation !");
    }

    public void failedOperation(String error){
        logger.info("PROGRAM","Operation failed : " + error);
    }

    public void show(String text)
    {
        logger.info("OUTPUT",text);
    }

    public void productFound()
    {
        logger.info("PROGRAM","Product found !");
    }


}
