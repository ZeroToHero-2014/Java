package ro.teamnet.hello;

import org.apache.log4j.Logger;

/**
 * A Simple class for displaying a HelloWorld message and return a HelloWorld Key
 */
public class HelloWorld {

    static final Logger logger = Logger.getLogger(HelloWorld.class.getName());

    public HelloWorld() {
    }


    /**
     * method for saying hello
     */
    public void sayHello(){
        System.out.println("Hello World!");
    }

    /**
     * method for returning a key
     * @return - The HelloWorld key
     */
    public String returnHelloKey(){
        logger.debug("Enter in returnHelloKey from HelloWorld");
        return "HelloKey";
    }
}
