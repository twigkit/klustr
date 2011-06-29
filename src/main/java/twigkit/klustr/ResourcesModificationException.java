package twigkit.klustr;

public class ResourcesModificationException extends Exception {

	public ResourcesModificationException() {
		super("Resources cannot be modified");
	}

	public ResourcesModificationException(String message) {
		super(message);
	}

	public ResourcesModificationException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public ResourcesModificationException(final Throwable cause) {
		super(cause);
	}
}
