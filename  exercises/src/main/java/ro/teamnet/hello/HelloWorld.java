package ro.teamnet.hello;

/**
 * Created by andrei.dobre on 29.10.2014.
 */
public class HelloWorld {

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
        return "HelloKey";
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
    }


}
