package ro.teamnet.hello;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by George on 10/29/2014.
 */
public class HelloWorldTest {

    /**
     * Junit test for SayHello from class HelloWorld
     */
    @Test
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    /**
     * Junit test for ReturnHelloKey from class HelloWorld
     */
    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloKey());

       assert helloWorld.returnHelloKey().equals("HelloKey");
    }

    @Test
    public void testVerify(){
        HelloWorld helloWorld = new HelloWorld();
        Assert.assertTrue(helloWorld.verify());
    }
}
