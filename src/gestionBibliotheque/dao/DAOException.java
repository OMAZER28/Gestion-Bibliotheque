package gestionBibliotheque.dao;

public class DAOException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public DAOException() {
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(String message,Throwable cause) {
        super(message,cause);
    }
    
    @Override
    public String getMessage(){
    	return super.getMessage() + super.getCause();
    }

}

