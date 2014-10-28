package ro.teamnet.zerotohero.serializare;

import java.io.*;

/**
 * Created by Buli on 28.10.2014.
 */
public class TestStudent {

    public static void main(String[] Args){

        Student newStudent = new Student(1,"Vlad", "Bulimac");

        try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("student.data"))){
            os.writeObject(newStudent);
        }
        catch(FileNotFoundException fnfe){
            System.err.println("cannot create a file with the given file name ");
        }
        catch(IOException ioe){
            System.err.println("IO Error");
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("student.data"))){
            Object obj = ois.readObject();
            if(obj != null && obj instanceof Student) {
                Student newStud = (Student) obj;
                System.out.println(newStud);
            }
        }
        catch(FileNotFoundException fnfe){
            System.err.println("cannot read a file with the given file name ");
        }
        catch(ClassNotFoundException cnfe){
            System.err.println("cannot recognize the class of the object - is the file corrupted?");
        }
        catch(IOException ioe){
            System.err.println("an I/O error occurred while processing the file");
        }

    }

}
