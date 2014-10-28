package ro.teamnet.zerotohero.imut;

/**
 * Created by Dumitru on 27.10.2014.
 */
public class Test {

    public static void main(String[] args) {
        Immutable im = Immutable.createInstance(1, "Valoarea unu!");
        System.out.println(im);
        System.out.println("---------------");
        tryModification(im.getVariable(), im.getString());
        System.out.println(im);
    }

    private static void tryModification(int var, String str) {
        var = 2;
        str = "Valoarea doi!";
    }
}
