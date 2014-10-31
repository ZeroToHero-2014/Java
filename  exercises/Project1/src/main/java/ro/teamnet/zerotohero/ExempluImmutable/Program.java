package ro.teamnet.zerotohero.ExempluImmutable;

/**
 * Created by Mihai on 10/31/2014.
 */
public class Program {

    public static void main(String[] args) {

        ClasaImmutable ob = new ClasaImmutable(10,20,30);

        System.out.println(ob); //ClasaImmutable{a=10, b=20, c=30}

        //Daca vrem sa-l modificam pe ob atunci se poate realiza doar prin crearea unui obiect nou



/*
        System.out.println(ob.Aduna(100));//ClasaImmutable{a=110, b=120, c=130}

        System.out.println(ob);//ClasaImmutable{a=10, b=20, c=30}

        ob = ob.Aduna(100);

        System.out.println(ob);//ClasaImmutable{a=110, b=120, c=130}

*/
    }
}
