package ro.teamnet.hello2;

import ro.teamnet.hello.*;

public class HelloWorldExtend {

    public HelloWorldExtend() {
    }

    public void extendSayHello(){
        HelloWorld helloWorld = new HelloWorld();
        helloWorld.sayHello();
        System.out.println("The new Hello World");
    }

    public static void main(String[] args) {


        new HelloWorldExtend().extendSayHello();
    }

}
