/**
 * 
 */
package com.cloderia.helion.ide.builder.errai;

import com.cloderia.helion.ide.app.Entity;
import com.cloderia.helion.ide.app.Module;
import com.cloderia.helion.ide.builder.BuilderConfig;
import com.cloderia.helion.ide.builder.EntityBuilder;
import com.cloderia.helion.ide.util.IDEConstants;
import com.cloderia.helion.ide.util.IDEUtils;

/**
 * @author adrian
 *
 */
public class ErraiServiceBuilder implements EntityBuilder {

	private static final String INTERFACE_DIR = IDEConstants.JAVA_DIR + "com/cloderia/helion/client/shared/service/";
	private static final String IMPLEMENTATION_DIR = IDEConstants.JAVA_DIR + "com/cloderia/helion/server/service/";

	
	public void build(BuilderConfig config, Module module) {
		for (Entity entity : module.getEntities()) {
			config.setEntity(entity);
			build(config, entity);
		}
	}

	
	public void build(BuilderConfig config, Entity entity) {
		doBuildServiceInterface(config, entity);
		doBuildServiceImplementation(config, entity);

	}

	private void doBuildServiceInterface(BuilderConfig config, Entity entity) {
		config.setOutputDir(INTERFACE_DIR);
		config.setInputFile("services/errai/interface.ftl");
		config.setOutputFile(entity.getName() + "Service.java");
		
		if(entity.getApiTemplate() != null) config.setInputFile(entity.getApiTemplate());
		IDEUtils.generateArtifact(config);
	}

	private void doBuildServiceImplementation(BuilderConfig config, Entity entity) {
		config.setOutputDir(IMPLEMENTATION_DIR);
		config.setInputFile("services/errai/implementation.ftl");
		config.setOutputFile(entity.getName() + "ServiceImpl.java");
		
		if(entity.getApiImplTemplate() != null) config.setInputFile(entity.getApiImplTemplate());
		IDEUtils.generateArtifact(config);
	}

}
