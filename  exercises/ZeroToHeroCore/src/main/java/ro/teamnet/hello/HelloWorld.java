package ro.teamnet.hello;

import org.apache.log4j.Logger;

/**
 * Created by danielp on 10/28/2014.
 */
public class HelloWorld {

    static final Logger logger = Logger.getLogger(HelloWorld.class.getName());
    public static final String SOME="";

    public HelloWorld() {
    }

    public void sayHello(){
        System.out.println("Hello World!");
    }

    public String returnHelloKey(){
        logger.debug("Enter in returnHelloKey from HelloWorld");
        return "HelloKey";
    }
}
