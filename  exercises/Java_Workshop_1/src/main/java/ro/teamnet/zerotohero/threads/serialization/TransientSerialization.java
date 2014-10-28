package ro.teamnet.zerotohero.threads.serialization;
import java.beans.Transient;
import java.io.*;


public class TransientSerialization {
    public static void main(String [] args){
        USPresident usPresident = new USPresident("Barack Obama", "2009 to --", "56th term");
        System.out.println(usPresident);

        try (ObjectOutputStream oos = new ObjectOutputStream(new
                FileOutputStream("USPresident.data"))){   oos.writeObject(usPresident);
        }
        catch(FileNotFoundException fnfe) {
            System.err.println("cannot create a file with the given file name ");
        } catch(IOException ioe) {
            System.err.println("an I/O error occurred while processing the file");
        }
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("USPresident.data"))){
            Object obj = ois.readObject();
            if(obj != null && obj instanceof USPresident){
                USPresident presidentOfUS = (USPresident)obj;
                System.out.println(presidentOfUS);
            }
        }catch(FileNotFoundException fnfe) {
            System.err.println("cannot create a file with the given file name ");
        } catch(IOException ioe) {
            System.err.println("an I/O error occurred while processing the file");
        } catch(ClassNotFoundException cnfe) {
            System.err.println("cannot recognize the class of the object - is the file corrupted?");
        }

    }
}
