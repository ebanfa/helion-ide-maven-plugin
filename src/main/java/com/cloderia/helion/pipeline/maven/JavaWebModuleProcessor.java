/**
 * 
 */
package com.cloderia.helion.pipeline.maven;

import java.util.List;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.module.JavaWebModule;
import com.cloderia.helion.model.module.Module;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.AbstractModuleProcessor;
import com.cloderia.helion.pipeline.util.MavenUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.TemplateUtil;

/**
 * @author Edward Banfa
 *
 */
public class JavaWebModuleProcessor extends AbstractModuleProcessor {


	@Override
	protected Class<JavaWebModule> getModuleClass() {
		return JavaWebModule.class;
	}

	@Override
	public Module processDataModule(Module module, PipelineContext context) throws HelionException {
		this.generateWebModuleConfiguration(module, context);
		return module;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractModuleProcessor#getModules(com.cloderia.helion.model.application.Application, com.cloderia.helion.model.pipeline.PipelineContext)
	 */
	@Override
	protected List<JavaWebModule> getModules(Application application, PipelineContext context) {
		return application.getWebModules();
	}

	/**
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	private void generateWebModuleConfiguration(Module module, PipelineContext context) throws HelionException {
		// Generate WEB.XML and JBOSSWEB.XML
		String webInfDir = MavenUtil.getModuleWebInfDir(module, context);
		TemplateUtil.generateArtifact(context, module, IDEConstants.WEB_XML_TMPL_FTL, IDEConstants.WEB_XML,	webInfDir);
		TemplateUtil.generateArtifact(context, module, IDEConstants.JBOSS_WEB_XML_TMPL_FTL, IDEConstants.JBOSS_WEB_XML,	webInfDir);
	}
	

}
