/**
 * 
 */
package com.cloderia.helion.application.build;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;

/**
 * @author Edward Banfa
 *
 */
public class ApplicationBuilderFactory {
	
	public static ApplicationBuilder getBuilderInstance(Artifact artifact) throws HelionException {
		try {
			String builderClass = ArtifactConfigUtil.getConfigParameterValue(IDEConstants.APPLICATION_BUILDER_CLASS_PARAM, artifact);
			return (ApplicationBuilder) Class.forName(builderClass).newInstance();
			
		} catch (ClassNotFoundException e) {
			throw new HelionRuntimeException(e);
		} catch (InstantiationException e) {
			throw new HelionRuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new HelionRuntimeException(e);
		}
	}
}
