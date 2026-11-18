public class ServidorOfflineException extends RuntimeException {
    public ServidorOfflineException(String msg) {
        super(msg);
    }
}

//Essa classe representa um erro que acontece quando tentamos alocar um container em um servidor desligado. 25201495-2