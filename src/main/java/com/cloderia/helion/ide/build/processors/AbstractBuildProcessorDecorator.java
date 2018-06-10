/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.build.BuildContext;

/**
 * @author adrian
 *
 */
public abstract class AbstractBuildProcessorDecorator extends AbstractBuildProcessor<BuildContext> {

	protected BuildProcessor<BuildContext> processor;

	/**
	 * @param processor
	 */
	public AbstractBuildProcessorDecorator(BuildProcessor<BuildContext> processor) {
		this.processor = processor;
	}

	/**
	 * @param context
	 * @return
	 */
	protected BuildContext doBuild(BuildContext context) {
		try {
			return processor.build(decorate(context));
		} catch (IDEException e) {
			e.printStackTrace();
		}
		return context;
	}

	protected abstract BuildContext decorate(BuildContext context) throws IDEException ;

}
