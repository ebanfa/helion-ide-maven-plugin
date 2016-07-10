/**
 * 
 */
package com.cloderia.helion.ide.builder;

import java.util.ArrayList;
import java.util.List;

import com.cloderia.helion.ide.configuration.BuildConfiguration;

/**
 * @author adrian
 *
 */
public class ArtifactBuilderFactory {
	
	private static String builderPackage = "";
	
	public static List<ArtifactBuilder> getArtifactBuilders(BuildConfiguration buildConfiguration) {
		List<ArtifactBuilder> builders = new ArrayList<ArtifactBuilder>();
		for(String builderName: buildConfiguration.getBuilder()) {
			try {
				builders.add((ArtifactBuilder) Class.forName(builderName).newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return builders;
	}

}
