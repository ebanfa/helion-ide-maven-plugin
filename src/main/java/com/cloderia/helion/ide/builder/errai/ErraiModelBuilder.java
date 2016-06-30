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
public class ErraiModelBuilder implements EntityBuilder {
;

	
	public void build(BuilderConfig config, Module module) {
		for (Entity entity : module.getEntities()) {
			config.setEntity(entity);
			build(config, entity);
		}
	}

	
	public void build(BuilderConfig config, Entity entity) {
		doBuildEntities(config, entity);
		doBuildEntityOps(config, entity);
	}

	/**
	 * @param config
	 * @param entity
	 */
	private void doBuildEntities(BuilderConfig config, Entity entity) {
		config.setOutputDir(IDEConstants.MODEL_DIR);
		config.setInputFile("entities/errai/entity.ftl");
		config.setOutputFile(entity.getName() + ".java");
		IDEUtils.generateArtifact(config);
	}

	/**
	 * @param config
	 * @param entity
	 */
	private void doBuildEntityOps(BuilderConfig config, Entity entity) {
		config.setOutputDir(IDEConstants.OPS_DIR);
		config.setInputFile("entities/errai/entity-ops.ftl");
		config.setOutputFile(entity.getName() + "Operation.java");
		IDEUtils.generateArtifact(config);
	}

}
