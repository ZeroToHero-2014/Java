package ro.teamnet.hello;

import org.junit.Test;

/**
 * Created by user on 10/28/2014.
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
        assert helloWorld.returnHelloKey().equals("HelloKey");
        System.out.println("From Test: " + helloWorld.returnHelloKey());
    }




}
