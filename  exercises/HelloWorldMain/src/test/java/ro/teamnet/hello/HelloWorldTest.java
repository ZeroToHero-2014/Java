package ro.teamnet.hello;

import org.junit.Test;

/**
 * Created by Miha on 10/29/2014.
 */
public class HelloWorldTest {
    @Test  //specific ca respectiva metoda e un test unitar, pt a fi luat in seama de Maven
    public void testSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }

    @Test
    public void testReturnHelloKey(){
        HelloWorld helloWorld = new HelloWorld();
        System.out.println("From Test: " + helloWorld.returnHelloKey());
        assert helloWorld.returnHelloKey().equals("HelloKey");//pp ca prima parte e egala cu partea a 2-a; daca e adevarat, e ok testul
    }

}
