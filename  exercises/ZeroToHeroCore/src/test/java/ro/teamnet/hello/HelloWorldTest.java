package ro.teamnet.hello;

import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by danielp on 10/28/2014.
 */

public class HelloWorldTest {

    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloKey());
    }

}
