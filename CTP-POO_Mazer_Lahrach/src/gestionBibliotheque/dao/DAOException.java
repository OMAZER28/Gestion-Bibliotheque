package gestionBibliotheque.dao;

/** Class qui permet la gestion des exception d'acc�e au base de donn�es
@author 	lahrach omar, mazer omar
@version 	juin 2020
*/

public class DAOException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/** un constructeur qui ne fait rien */
	public DAOException() {
    }
	
	/** un constructeur qui prend en param�tre un message � afficher
	 * @param message une cha�ne de caract�re
	 */
    public DAOException(String message) {
        super(message);
    }
    
    /** un constructeur qui prend en param�tre un message et un raison
     * @param message une cha�ne de caract�res
     * @param cause Throwable
     */
    public DAOException(String message,Throwable cause) {
        super(message,cause);
    }
    
    /** M�thode getMessage() permet d'afficher un message claire pour l'exception
    @return un message
    */
    @Override
    public String getMessage(){
    	return super.getMessage() + super.getCause();
    }

}

