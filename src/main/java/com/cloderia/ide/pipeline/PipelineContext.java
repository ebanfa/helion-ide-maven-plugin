/**
 * 
 */
package com.cloderia.ide.pipeline;

import javax.xml.bind.annotation.XmlTransient;

import com.cloderia.helion.BuildContext;
import com.cloderia.ide.application.Application;
import com.cloderia.ide.config.PipelineContextConfig;

/**
 * @author Edward Banfa
 */
public class PipelineContext extends AbstractBuildContext implements BuildContext {
	
	/** Application data */
	private Application application;
	
	public PipelineContext(PipelineContextConfig contextConfig) {
		super(contextConfig);
	}
	
	/**
	 * @return the application
	 */
	public Application getApplication() {
		return application;
	}

	/**
	 * @param application the application to set
	 */
	@XmlTransient
	public void setApplication(Application application) {
		this.application = application;
	}

}
