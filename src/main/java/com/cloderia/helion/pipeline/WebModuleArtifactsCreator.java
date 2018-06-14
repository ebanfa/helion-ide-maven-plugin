/**
 * 
 */
package com.cloderia.helion.pipeline;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.model.Application;
import com.cloderia.helion.model.Module;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.ModuleDirectoryUtil;
import com.cloderia.helion.util.ModuleUtil;
import com.cloderia.helion.util.TemplateUtil;

/**
 * @author adrian
 *
 */
public class WebModuleArtifactsCreator extends AbstractPipelineItem {

	private static Logger logger = LoggerFactory.getLogger(WebModuleArtifactsCreator.class);
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) throws HelionException {
		Application application = context.getApplication();
		// Only process web modules
		application.getModules().stream().map(module -> {
			if(ModuleUtil.isWebModule(module))
				return this.process(module, context);
			return module;
		}).collect(Collectors.toList());
		return context;
	}

	private Module process(Module module, PipelineContext context) {
		logger.debug("Generating module web.xml and jbossweb.xml for module" + module.getId());
		try {
			// Generate WEB.XML and JBOSSWEB.XML
			TemplateUtil.generateArtifact(context, module, IDEConstants.WEB_XML_TMPL_FTL, 
					IDEConstants.WEB_XML, ModuleDirectoryUtil.getModuleWebInfDir(module, context));
			// Generate 
			TemplateUtil.generateArtifact(context, module, IDEConstants.JBOSS_WEB_XML_TMPL_FTL, 
					IDEConstants.JBOSS_WEB_XML, ModuleDirectoryUtil.getModuleWebInfDir(module, context));
		} catch (HelionException e) {
			logger.error(e.getMessage(), e);
		}
		return module;
	}

}
