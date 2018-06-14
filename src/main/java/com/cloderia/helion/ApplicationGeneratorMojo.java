/**
 * 
 */
package com.cloderia.helion;

import java.util.List;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.pipeline.Pipeline;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineImpl;
import com.cloderia.helion.pipeline.PipelineItem;
import com.cloderia.helion.util.IDEUtil;

/**
 * This class represents a Maven goal
 * Life cycle is a sequence of named phases.
 * Phases executes sequentially. Executing a phase means executes all previous phases.
 * Plugin is a collection of goals also called MOJO (Maven Old Java Object).
 * Analogy : Plugin is a class and goals are methods within the class
 * 
 * @author adrian
 */
@Mojo(name="generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class ApplicationGeneratorMojo extends AbstractHelionMojo {

	private static Logger logger = LoggerFactory.getLogger(ApplicationGeneratorMojo.class);
	
	@Override
	public void execute(PipelineContext buildContext) throws HelionException {
		logger.info("------------------------------------------------------------------------");
		logger.info("HELION IDE");
		logger.info("------------------------------------------------------------------------");
		doExecute(buildContext);
	}

	/**
	 * @param buildContext
	 */
	protected void doExecute(PipelineContext buildContext) {
		List<PipelineItem> items = IDEUtil.getBuildProcessors(buildContext);
		Pipeline pipeline = new PipelineImpl(items);
		pipeline.execute(buildContext);
	}
	
}
