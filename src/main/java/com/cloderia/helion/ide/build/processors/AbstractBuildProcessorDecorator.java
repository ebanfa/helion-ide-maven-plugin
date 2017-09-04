/**
 * 
 */
package com.cloderia.helion.ide.build.processors;

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
	protected AbstractBuildProcessorDecorator(BuildProcessor<BuildContext> processor){
		this.processor = processor;
	}
	
	/**
	 * @param context
	 * @return
	 */
	protected BuildContext doBuild(BuildContext context) {
		return processor.build(decorate(context));
	}

	protected abstract BuildContext decorate(BuildContext context);
}
