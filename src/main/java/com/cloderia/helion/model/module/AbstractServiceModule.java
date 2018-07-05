/**
 * 
 */
package com.cloderia.helion.model.module;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Edward Banfa
 *
 */
@XmlRootElement(name="module")
public abstract class AbstractServiceModule extends AbstractModule implements ServiceModule {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.module.Module#getType()
	 */
	@Override
	public String getType() {
		return "service";
	}

}
