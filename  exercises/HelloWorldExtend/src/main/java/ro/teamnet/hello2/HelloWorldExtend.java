package ro.teamnet.hello2;
import ro.teamnet.hello.HelloWorld;
/**
 * Created by user on 10/29/2014.
 */
public class HelloWorldExtend {
    public HelloWorldExtend(){

    }

    public void extendSayHello(){
        HelloWorld helloWorld=new HelloWorld();
        helloWorld.sayHello();

    }

    public static void main(String[] args){
        HelloWorldExtend helloWorld = new HelloWorldExtend();
        helloWorld.extendSayHello();
    }
}
