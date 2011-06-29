package twigkit.klustr.strategy;

import twigkit.klustr.Cluster;
import twigkit.klustr.ResourcesModificationException;

/**
 *
 */
public interface Strategy<T> {

	public void setResources(T... resources) throws ResourcesModificationException;

	public T next();

	public void reset();
	
}
