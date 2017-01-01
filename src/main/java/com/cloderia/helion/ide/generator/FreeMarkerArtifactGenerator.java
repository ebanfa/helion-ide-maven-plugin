/**
 * 
 */
package com.cloderia.helion.ide.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import com.cloderia.helion.ide.configuration.BuildConfiguration;
import com.cloderia.helion.ide.util.IDEException;
import com.cloderia.helion.ide.util.IDEUtils;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.cache.TemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

/**
 * @author adrian
 *
 */
public class FreeMarkerArtifactGenerator implements ArtifactGenerator {
	
	private Configuration configuration;
	
	
	/**
	 * @param buildConfiguration
	 * @return
	 * @throws IDEException
	 */
	public Configuration loadFMConfiguration(BuildConfiguration buildConfiguration) throws IDEException {
		try {
			configuration = new Configuration();
			int count = 0;
			TemplateLoader[] loaders = new TemplateLoader[buildConfiguration.getTemplateDir().size()];
			for (String templateDir : buildConfiguration.getTemplateDir()) {
				loaders[count] = new FileTemplateLoader(new File(templateDir));
				count++;
			}
			configuration.setDefaultEncoding("UTF-8");
			configuration.setObjectWrapper(new DefaultObjectWrapper());
			configuration.setIncompatibleImprovements(new Version(2, 3, 20));
			configuration.setTemplateLoader(new MultiTemplateLoader(loaders));
			configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
			return configuration;
		} catch (IOException e) {
			throw new IDEException(e.getMessage());
		}
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.generator.ArtifactGenerator#generateArtifact(com.cloderia.helion.ide.generator.ArtifactGeneratorData)
	 */
	public void generateArtifact(BuildConfiguration buildConfiguration, ArtifactGeneratorData artifactGeneratorData) throws IDEException {
		try {
			if(configuration == null) 
				configuration = this.loadFMConfiguration(buildConfiguration);
			
			Map<String, Object> root = new HashMap<String, Object>();
			if(artifactGeneratorData.getData() != null)
				root.put(artifactGeneratorData.getData().getArtifactDataType(), artifactGeneratorData.getData());
			// This is for templates the need a reference to the application object
			root.put("applicationRef", buildConfiguration.getApplication());
			IDEUtils.createDirectoryIfNeeded(artifactGeneratorData.getOutputDir());
			Template template = configuration.getTemplate(artifactGeneratorData.getInputFile());
			FileOutputStream outputStream = new FileOutputStream(
					artifactGeneratorData.getOutputDir().concat(artifactGeneratorData.getOutputFile()));
			
			template.process(root, new OutputStreamWriter(outputStream));
			
		} catch (IOException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		} catch (TemplateException e) {
			e.printStackTrace();
			throw new IDEException(e.getMessage());
		}
	}

}
