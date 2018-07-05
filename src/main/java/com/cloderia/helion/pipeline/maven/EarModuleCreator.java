/**
 * 
 */
package com.cloderia.helion.pipeline.maven;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.PipelineException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.pipeline.AbstractPipelineItem;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.util.FileUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.StringUtil;
import com.cloderia.helion.util.TemplateUtil;

/**
 * @author Edward Banfa
 *
 */
public class EarModuleCreator extends AbstractPipelineItem {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.model.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.model.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		try {
			Application application = context.getApplication();
			String earModuleName = application.getId().concat("-ear");
			String targetDir = context.getTargetDir().concat(StringUtil.trailingSlashIt(earModuleName));
			
			FileUtil.createDirectoryIfNeeded(targetDir);
			TemplateUtil.generateArtifact(context, application, IDEConstants.APPLICATION_EAR_POM_TMPL_FTL, IDEConstants.POM_XML_FILE_NAME, targetDir);
			TemplateUtil.generateArtifact(context, application, IDEConstants.APPLICATION_EAR_README_TMPL_FTL, IDEConstants.README_MD_FILE_NAME, targetDir);
			
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}

}
