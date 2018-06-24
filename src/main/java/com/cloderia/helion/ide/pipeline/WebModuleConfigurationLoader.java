/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.ide.model.Application;
import com.cloderia.helion.ide.model.Module;
import com.cloderia.helion.ide.model.ModuleConfig;
import com.cloderia.helion.ide.pipeline.util.ConfigurationUtil;
import com.cloderia.helion.ide.pipeline.util.ModuleUtil;
import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;

/**
 * @author Edward Banfa
 *
 */
public class WebModuleConfigurationLoader extends AbstractPipelineItem {

	private static Logger logger = LoggerFactory.getLogger(WebModuleConfigurationLoader.class);
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.pipeline.AbstractPipelineItem#doExecute(com.cloderia.helion.pipeline.PipelineContext)
	 */
	@Override
	protected PipelineContext doExecute(PipelineContext context) {

		Application application = context.getApplication();
		// For each module generates its mandatory artifacts
		application.getModules()
			.stream()
			.map(module -> {
				return loadWebModuleData(module, context);
		}).collect(Collectors.toList());
		return context;
	}

	/**
	 * @param module
	 * @param context
	 * @return
	 */
	private Module loadWebModuleData(Module module, PipelineContext context) {
		if(!ModuleUtil.isWebModule(module)) return module;
		try {
			Optional<ModuleConfig> extraConfig = Optional.of(module.getExtraConfig()); 
			Optional<String> webConfigFileOpt = Optional.of(extraConfig.get().getWebConfigFile());
			module.setWebModule(ConfigurationUtil.loadWebModule(webConfigFileOpt.get(), context));
			return module;
		} catch (HelionException e) {
			throw new PipelineException(e);
		} catch (NullPointerException e) {
			throw new HelionRuntimeException("Web module configuration not found for web module " + module.getId(), e);
		}
	}

}
