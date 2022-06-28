package week4.exception3.myexceptions;

public class MyException extends Exception {

// TODO 右击Generate，Constructor，自动生成
    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(String message, Throwable cause) {
        super(message, cause);
    }

    public MyException(Throwable cause) {
        super(cause);
    }//引起异常的原因
}
