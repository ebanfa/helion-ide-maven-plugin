/**
 * 
 */
package com.cloderia.helion.pipeline.maven;

import java.util.List;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.module.EjbSharedModule;
import com.cloderia.helion.model.module.Module;
import com.cloderia.helion.model.module.SharedModule;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.AbstractModuleProcessor;
import com.cloderia.helion.pipeline.util.MavenUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.TemplateUtil;

/**
 * @author Edward Banfa
 *
 */
public class EjbSharedModuleProcessor extends AbstractModuleProcessor {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractModuleProcessor#getModuleClass()
	 */
	@Override
	protected Class<EjbSharedModule> getModuleClass() {
		return EjbSharedModule.class;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractModuleProcessor#processDataModule(com.cloderia.helion.model.module.Module, com.cloderia.helion.model.pipeline.PipelineContext)
	 */
	@Override
	public Module processDataModule(Module module, PipelineContext context) throws HelionException {
		String targetDir = MavenUtil.getProjectDir(module, context);
		TemplateUtil.generateArtifact(context, module, TemplateUtil.getModulePomTemplateFile(module), IDEConstants.POM_XML_FILE_NAME, targetDir);
		return module;
	}

	@Override
	protected List<SharedModule> getModules(Application application, PipelineContext context) {
		return application.getSharedModules();
	}


}
