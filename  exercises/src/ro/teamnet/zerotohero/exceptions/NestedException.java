package ro.teamnet.zerotohero.exceptions;

public class NestedException {
    public void main(String[] args) throws Exception {
        try {
            new Exception("test");
        } catch (Exception e) {
            e.printStackTrace();
            throw new MyException(e);
        }

    }
}
