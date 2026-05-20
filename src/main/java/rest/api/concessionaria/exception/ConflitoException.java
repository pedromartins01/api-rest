package rest.api.concessionaria.exception;

public class ConflitoException extends RuntimeException{

    public ConflitoException(String mensagem) {
        super(mensagem);
    }
}