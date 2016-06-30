/**
 * 
 */
package com.cloderia.helion.ide.builder;

import com.cloderia.helion.ide.app.Application;

import freemarker.template.Configuration;

/**
 * @author adrian
 *
 */
public interface BuildService {
	
	public void execute(Application application);
	
	public Application getApplication();
	
	public Configuration getConfiguration();

}
