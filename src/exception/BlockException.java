package exception;

public class BlockException extends Exception {

	public String msg;

	@Override
	public String getMessage() {
		return msg;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 5532814461436379915L;

	public BlockException() {
	}

	public BlockException(String msg) {
		this.msg = msg;
	}

}
