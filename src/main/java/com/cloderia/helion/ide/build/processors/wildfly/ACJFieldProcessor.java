/**
 * 
 */
package com.cloderia.helion.ide.build.processors.wildfly;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.Entity;
import com.cloderia.helion.ide.artifacts.FieldData;
import com.cloderia.helion.ide.artifacts.Module;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.IDEUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class ACJFieldProcessor extends AbstractBuildProcessorDecorator {

	private static final String A4_ENTITY_DATA_OBJ_TMPL_FTL = "entities/${entity}.ftl";

	/**
	 * @param processor
	 */
	public ACJFieldProcessor(BuildProcessor<BuildContext> processor) {
		super(processor);
	}
	
	@Override
	protected BuildContext decorate(BuildContext context) {
		// The target 'components' directory
		for(Module moduleData: context.getApplication().getModules()) {
			for(Entity entity : moduleData.getEntities()) {
				System.out.println(">>>>>>>>>>>>>>>" + entity.getTableName());
				for(FieldData field : entity.getFields()) {
					System.out.println(">>>>>>>>>>>>>>>" + field.getName());
					field.setJavaName(StringUtil.columnNameToJavaFieldName(field.getName()));
				}
			}
		}
		return context;
	}

}
