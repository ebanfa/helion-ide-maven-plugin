/**
 * 
 */
package com.cloderia.helion.model.module;

/**
 * @author Edward Banfa
 *
 */
public abstract class AbstractSharedModule extends AbstractModule implements SharedModule {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.module.Module#getType()
	 */
	@Override
	public String getType() {
		return "shared";
	}

}
