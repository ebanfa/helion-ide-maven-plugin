/**
 * 
 */
package com.cloderia.helion.util;

import java.util.List;

import com.cloderia.helion.model.Application;
import com.cloderia.helion.model.Entity;
import com.cloderia.helion.model.FieldData;
import com.cloderia.helion.model.Module;

/**
 * @author adrian
 *
 */
public class ArtifactUtil {
	
	/**
	 * @param application
	 * @return
	 */
	public static void preProcess(Application application) {
		List<Module> modules = application.getModules();
		Module[] modulesArray = modules.toArray(new Module[0]);
		for (int i = 0; i < modulesArray.length; i++) {
			System.out.println(">>>>>>>>>>>>>>>>>>>" + modulesArray[i].getName());
			preProcessModule(modulesArray[i]);
		}
	}

	/**
	 * @param module
	 */
	private static void preProcessModule(Module module) {
		for (Entity entity : module.getEntities()) {
			preProcessEntity(entity, module);
		}
	}
	
	/**
	 * @param entity
	 * @param module
	 */
	private static void preProcessEntity(Entity entity, Module module){
		for (FieldData field : entity.getFields()) {
			preProcessField(field);
		}
		entity.setModule(module);
	}

	/**
	 * @param field
	 */
	private static void preProcessField(FieldData field) {
		if(field.isValidateRequired()){}
		//field.setJavaName(StringUtils.columnNameToJavaFieldName(field.getName()));
		if(field.getName().equals("name")) field.setSize("75");
		else if(field.getName().equals("entity_code")) field.setSize("35");
		else if(field.getSize().equals("large")) field.setSize("255");
		else if(field.getSize().equals("medium")) field.setSize("35");
	}
}
