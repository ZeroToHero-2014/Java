package ro.teamnet.hello;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by Buli on 29.10.2014.
 */
public class HelloWorld {

    static final Logger logger = Logger.getLogger(HelloWorld.class.getName());

    public void sayHello(){
        int i=0;
        System.out.println("Hello World!");
        logger.debug("DEBUG->Enters in sayHello() method from HelloWorld");
        logger.info("INFO->Enters in sayHello() method from HelloWorld");
    }

    public String returnHelloKey(){
        return "Hello Key";
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();

        helloWorld.sayHello();
    }

}
