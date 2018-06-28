/**
 * 
 */
package com.cloderia.helion.ide.pipeline.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.model.web.WebModule;
import com.cloderia.helion.ide.model.web.WebService;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.StringUtil;
import com.cloderia.helion.pipeline.PipelineContext;

/**
 * @author Edward Banfa
 *
 */
public class WebModuleArtifactsUtil {
	
	private static Logger logger = LoggerFactory.getLogger(WebModuleArtifactsUtil.class);

	/**
	 * @param context
	 * @param module
	 * @return
	 * @throws HelionException
	 */
	public static void generateWebModuleArtifacts(Module module, PipelineContext context) throws HelionException {
		WebModule webModule = module.getWebModule();
		if(webModule.getHasServices()) {
			generateWSApplicationJavaSources(module, context);
			generateWSJavaSources(module, context);
		}
		generateWebModuleConfiguration(module, context);
	}
	
	/**
	 * @param module
	 * @param context
	 * @throws HelionException 
	 */
	private static void generateWSApplicationJavaSources(Module module, PipelineContext context) throws HelionException {
		String moduleDir = ModuleUtil.getPackageDir(module, context);
		String templateFile = getRsApplicationTemplateFile(module.getWebModule());
		
		String wsAppSourceFileName = module.getClassName().concat("RSApplication.java");
		TemplateUtil.generateArtifact(context, module, templateFile, wsAppSourceFileName,	moduleDir);
	}

	/**
	 * @param module
	 * @param context
	 * @throws HelionException 
	 */
	private static void generateWSJavaSources(Module module, PipelineContext context) throws HelionException {
		WebModule webModule = module.getWebModule();
		String moduleDir = ModuleUtil.getPackageDir(module, context);
		
		for(WebService webService: webModule.getWebServices()) {
			String wsServiceSourceFileName = webService.getId().concat(".java");
			TemplateUtil.generateArtifact(context, webService, getWSServiceTemplateFile(webService), wsServiceSourceFileName, moduleDir);
		}
	}

	/**
	 * @param module
	 * @param context
	 * @throws HelionException
	 */
	private static void generateWebModuleConfiguration(Module module, PipelineContext context) throws HelionException {
		// Generate WEB.XML and JBOSSWEB.XML
		String webInfDir = WebModuleUtil.getModuleWebInfDir(module, context);
		TemplateUtil.generateArtifact(context, module, IDEConstants.WEB_XML_TMPL_FTL, IDEConstants.WEB_XML,	webInfDir);
		TemplateUtil.generateArtifact(context, module, IDEConstants.JBOSS_WEB_XML_TMPL_FTL, IDEConstants.JBOSS_WEB_XML,	webInfDir);
	}
	
	
	/**
	 * @param webModule
	 * @return
	 */
	private static String getRsApplicationTemplateFile(WebModule webModule) {
		if(webModule.getArtifactConfig() != null) {
			if(StringUtil.isValidString(webModule.getArtifactConfig().getRsApplicationTemplateFile()))
				return webModule.getArtifactConfig().getRsApplicationTemplateFile();
		}
		return IDEConstants.WEB_MODULE_RS_APPL_TMPL_FTL;
	}
	
	private static String getWSServiceTemplateFile(WebService webService) {
		if(webService.getArtifactConfig() != null) {
			if(StringUtil.isValidString(webService.getArtifactConfig().getTemplateFile()))
				return webService.getArtifactConfig().getTemplateFile();
		}
		return IDEConstants.WEB_MODULE_RS_APPL_TMPL_FTL;
	}
}
