/**
 * 
 */
package com.cloderia.helion;

import java.util.List;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.model.pipeline.Pipeline;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.model.pipeline.PipelineItem;
import com.cloderia.helion.model.pipeline.HelionPipeline;
import com.cloderia.helion.pipeline.util.PipelineUtil;

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
	
	/**
	 * @param buildContext
	 */
	protected void doExecute(PipelineContext buildContext) throws HelionException {
		logger.info("------------------------------------------------------------------------");
		logger.info("                  HELION APPLICATION GENERATOR MOJO                     ");
		logger.info("------------------------------------------------------------------------");
		List<PipelineItem> items = PipelineUtil.getPipelineItems(buildContext);
		Pipeline pipeline = new HelionPipeline(items);
		pipeline.execute(buildContext);
	}
	
}
