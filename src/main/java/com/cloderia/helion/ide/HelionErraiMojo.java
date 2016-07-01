/**
 * 
 */
package com.cloderia.helion.ide;

import org.apache.maven.plugins.annotations.Mojo;

import com.cloderia.helion.ide.app.Application;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.builder.BuildService;
import com.cloderia.helion.ide.builder.BuilderConfig;
import com.cloderia.helion.ide.builder.errai.ErraiEndPointBuilder;
import com.cloderia.helion.ide.builder.errai.ErraiEntityPageBuilder;
import com.cloderia.helion.ide.builder.errai.ErraiEntityViewBuilder;
import com.cloderia.helion.ide.builder.errai.ErraiModelBuilder;
import com.cloderia.helion.ide.builder.errai.ErraiServiceBuilder;
import com.cloderia.helion.ide.util.IDEUtils;
import com.cloderia.helion.ide.util.PropertyUtils;

/**
 * @author adrian
 *
 */
@Mojo(name="errai")
public class HelionErraiMojo extends AbstractHelionMojo implements BuildService {
    
	
	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.AbstractHelionMojo#execute(com.cloderia.helion.ide.app.Application)
	 */
	public void execute(Application application) {
		buiderConfig = initBulderConfig();
		buiderConfig.setApplicationBuilder(this);
		IDEUtils.createDirectoryIfNeeded(buiderConfig.getTargetDir());
		configuration = IDEUtils.loadApplicationConfiguration(application);
		doBuild(buiderConfig);
	}
	
	/**
	 * @param application
	 */
	public void doBuild(BuilderConfig config) {
		for (Module module : application.getModules()) {
			config.setModule(module);
			module = PropertyUtils.inspectEntityFields(module);
			module = PropertyUtils.inspectRelatedChildEntities(module);

			this.generateViews(config, module);
			this.generateServices(config, module);
			this.generateEntities(config, module);
			this.generateEndPoints(config, module);
		}
	}

	/**
	 * @param config
	 * @param module
	 */
	private void generateViews(BuilderConfig config, Module module) {
		new ErraiEntityViewBuilder().build(config, module);
		new ErraiEntityPageBuilder().build(config, module);
	}
	
	/**
	 * @param config
	 * @param module
	 */
	private void generateEntities(BuilderConfig config, Module module) {
		new ErraiModelBuilder().build(config, module);
	}
	
	/**
	 * @param config
	 * @param module
	 */
	private void generateServices(BuilderConfig config, Module module) {
		new ErraiServiceBuilder().build(config, module);
	}
	
	/**
	 * @param config
	 * @param module
	 */
	private void generateEndPoints(BuilderConfig config, Module module) {
		new ErraiEndPointBuilder().build(config, module);
	}

}
