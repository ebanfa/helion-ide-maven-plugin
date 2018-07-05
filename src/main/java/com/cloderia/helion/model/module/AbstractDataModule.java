/**
 * 
 */
package com.cloderia.helion.model.module;

/**
 * Represents a abstract data module. A data module is an application
 * module that deals with the low level details of data storage/management.
 * 
 * @author Edward Banfa
 */
public abstract class AbstractDataModule extends AbstractModule implements DataModule {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.module.Module#getType()
	 */
	@Override
	public String getType() {
		return "persistence";
	}

}
