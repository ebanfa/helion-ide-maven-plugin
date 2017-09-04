/**
 * 
 */
package com.cloderia.helion.ide;

/**
 * @author adrian
 *
 */
public interface ObjectFactory<T> {

	public T getInstance(String name);
}
