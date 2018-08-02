/**
 * 
 */
package com.cloderia.helion.application.config;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.ConfigurationUtil;
import com.cloderia.helion.util.IDEConstants;

/**
 * @author Edward Banfa
 *
 */
public class XMLConfigurationReader implements ConfigurationReader {

	/* (non-Javadoc)
	 * @see com.cloderia.helion.application.ConfigurationReader#readConfiguration(com.cloderia.ide.config.ArtifactConfig)
	 */
	@Override
	public Artifact readConfiguration(Artifact artifactConfig) throws HelionException {
		String applicationConfigFile =  
				ArtifactConfigUtil.getConfigParameterValue(IDEConstants.CONFIG_READER_FILE_PARAM, artifactConfig);
		return ConfigurationUtil.readArtifact(applicationConfigFile);
	}

}
