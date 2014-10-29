package ro.teamnet.hello;

import org.apache.log4j.Logger;

/**
 * Created by Miha on 10/29/2014.
 */
public class HelloWorld {
    static final Logger logger = Logger.getLogger(HelloWorld.class.getName());

    public void sayHello(){
        System.out.println("Hello World!");
        logger.debug("DEBUG -> Enters in sayHello() method from HelloWorld");
        logger.info("INFO -> Enters in returnHelloKey from HelloWorld");
    }

    public String returnHelloKey(){
        return "HelloKey";
    }

    public static void main(String[] args) {
        HelloWorld helloworld = new HelloWorld();
        helloworld.sayHello();
    }
}
