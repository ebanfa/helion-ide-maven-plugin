/**
 * 
 */
package com.cloderia.helion.ide.util;

import com.cloderia.helion.ide.artifact.Application;
import com.cloderia.helion.ide.artifact.ArtifactData;
import com.cloderia.helion.ide.artifact.Entity;
import com.cloderia.helion.ide.artifact.Module;
import com.cloderia.helion.ide.artifact.RelatedEntity;
import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.generator.ArtifactGenerator;
import com.cloderia.helion.ide.generator.ArtifactGeneratorData;

/**
 * @author adrian
 *
 */
public class BuilderUtils {
	
	/**
	 * @param buildConfiguration
	 * @throws IDEException
	 */
	public static void generateArtifact(BuildConfiguration buildConfiguration, ArtifactData artifactData,
			String inputFile, String outputFile, String outputDirectory) throws IDEException {
		ArtifactGeneratorData generatorData = new ArtifactGeneratorData(artifactData, inputFile, outputFile, outputDirectory);
		ArtifactGenerator artifactGenerator = buildConfiguration.getArtifactGenerator();
		artifactGenerator.generateArtifact(buildConfiguration, generatorData);
	}

	
	/**
	 * @param name
	 * @param application
	 * @return
	 */
	public static Entity findEntityInApplication(String name, Application application){
		for(Module module: application.getModules()){
			for(Entity entity: module.getEntities()){
				if(entity.getName().equals(name)){
					return entity;
				}
			}
		}
		return null;
	}

	/**
	 * @param buildConfiguration
	 * @param entity
	 * @throws IDEException
	 */
	public static void processRelatedUIEntityRelationship(BuildConfiguration buildConfiguration, Entity entity)
			throws IDEException {
		Application application = buildConfiguration.getApplication();
		for(RelatedEntity relatedEntity: entity.getRelatedEntity()){
			BuilderUtils.findEntityInApplication(relatedEntity.getName(), application);
		}
	}
}
