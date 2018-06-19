/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.pipeline.util.TemplateUtil;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * This pipeline item generates artifacts for the application's
 * parent maven project.
 * 
 * @author adrian
 */
public class ApplicationArtifactsGenerator extends AbstractPipelineItem {
	
	private static Logger logger = LoggerFactory.getLogger(ApplicationArtifactsGenerator.class);

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		String targetDir = context.getTargetDir();
		Application application = context.getApplication();
		try {
			// Generate the parent POM and README
			logger.debug("Generating parent pom and readme file");
			TemplateUtil.generateArtifact(context, application, IDEConstants.APPLICATION_POM_TMPL_FTL, IDEConstants.MODULE_POM_XML, targetDir);
			TemplateUtil.generateArtifact(context, application, IDEConstants.APPLICATION_README_TMPL_FTL, IDEConstants.MODULE_README_MD, targetDir);
			
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}

}
