/**
 * 
 */
package com.cloderia.helion.pipeline.maven;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.exception.HelionException;
import com.cloderia.helion.exception.PipelineException;
import com.cloderia.helion.model.application.Application;
import com.cloderia.helion.model.module.Module;
import com.cloderia.helion.model.pipeline.AbstractPipelineItem;
import com.cloderia.helion.model.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.util.MavenUtil;
import com.cloderia.helion.util.IDEConstants;
import com.cloderia.helion.util.ResourcesUtil;
import com.cloderia.helion.util.TemplateUtil;

/**
 * This pipeline item generates artifacts for the application's
 * parent maven project.
 * 
 * @author adrian
 */
public class MavenProjectProcessor extends AbstractPipelineItem {
	private static Logger logger = LoggerFactory.getLogger(MavenProjectProcessor.class);
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		try {
			Application application = context.getApplication();
			createRootProjectArtifacts(application, context);
			createChildProjectsArtifacts(application, application.getSharedModules(), context);
			createChildProjectsArtifacts(application, application.getDataModules(), context);
			createChildProjectsArtifacts(application, application.getServiceModules(), context);
			createChildProjectsArtifacts(application, application.getWebModules(), context);
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
		return context;
	}
	
	/**
	 * @param artifact
	 * @param targetDir
	 * @param pomTemplate
	 * @param readMeTemplate
	 * @param isParentModule
	 * @param context
	 * @throws HelionException
	 */
	public void createRootProjectArtifacts(Application application, PipelineContext context) throws HelionException {
		String targetDir = context.getTargetDir();
		MavenUtil.createMavenProjectFileSystem(targetDir, true, null);
		TemplateUtil.generateArtifact(context, application, IDEConstants.APPLICATION_POM_TMPL_FTL, IDEConstants.POM_XML_FILE_NAME, targetDir);
		TemplateUtil.generateArtifact(context, application, IDEConstants.APPLICATION_README_TMPL_FTL, IDEConstants.README_MD_FILE_NAME, targetDir);
	}
	
	/**
	 * @param application
	 * @param children
	 * @param context
	 * @throws HelionException
	 */
	public <T extends Module> void createChildProjectsArtifacts(Application application, List<T> children, PipelineContext context) throws HelionException{
		children.stream().map(module -> {
			createChildProjectArtifacts(application, module, context);
			return module;
		}).collect(Collectors.toList());
	}
	
	/**
	 * @param application
	 * @param child
	 * @param context
	 */
	public static void createChildProjectArtifacts(Application application, Module child, PipelineContext context) {
		try {
			String targetDir = MavenUtil.getProjectDir(child, context);
			String packageDir = MavenUtil.getJavaPackageDir(child, context);
			
			MavenUtil.createMavenProjectFileSystem(targetDir, false, packageDir);
			MavenUtil.createMavenWebProjectFileSystem(child, context);
			
			TemplateUtil.generateArtifact(context, child, TemplateUtil.getModulePomTemplateFile(child), IDEConstants.POM_XML_FILE_NAME, targetDir);
			TemplateUtil.generateArtifact(context, child, IDEConstants.MODULE_README_TMPL_FTL, IDEConstants.README_MD_FILE_NAME, targetDir);
		} catch (HelionException e) {
			throw new PipelineException(e);
		}
	}
	

}
