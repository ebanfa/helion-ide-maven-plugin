/**
 * 
 */
package com.cloderia.helion.application.config;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.HelionRuntimeException;
import com.cloderia.helion.config.Artifact;
import com.cloderia.helion.util.ArtifactConfigUtil;
import com.cloderia.helion.util.IDEConstants;

/**
 * @author Edward Banfa
 *
 */
public class ConfigurationReaderFactory {


	public static ConfigurationReader getReader(Artifact config) throws HelionException {
		try {
			String configReaderClass = ArtifactConfigUtil.getConfigParameterValue(IDEConstants.CONFIG_READER_CLASS_PARAM, config);
			return (ConfigurationReader) Class.forName(configReaderClass).newInstance();
			
		} catch (ClassNotFoundException e) {
			throw new HelionRuntimeException(e);
		} catch (InstantiationException e) {
			throw new HelionRuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new HelionRuntimeException(e);
		}
	}
}
