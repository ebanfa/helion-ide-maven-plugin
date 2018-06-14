/**
 * 
 */
package com.cloderia.helion.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

import com.cloderia.helion.HelionException;
import com.cloderia.helion.model.Artifact;
import com.cloderia.helion.pipeline.PipelineContext;

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
 * @author Edward Banfa
 *
 */
public class TemplateUtil {

	public static Configuration configuration;

	
	/**
	 * Generates a file based on a FreeMarker template.
	 * 
	 * @param context
	 * @param data
	 * @param templateFile
	 * @param outputFile
	 * @param outputDirectory
	 * @throws HelionException
	 */
	public static void generateArtifact(PipelineContext context, Artifact data, 
			String templateFile, String outputFile, String outputDirectory) throws HelionException  {
		try {
			if (configuration == null)
				configuration = loadFMConfiguration(context);

			Map<String, Object> root = new HashMap<String, Object>();
			root.put(data.getArtifactType(), data);
			root.put("applicationRef", context.getApplication());

			FileUtil.createDirectoryIfNeeded(outputDirectory);
			Template template = configuration.getTemplate(templateFile);
			template.process(root, new OutputStreamWriter(new FileOutputStream(outputDirectory.concat(outputFile))));

		} catch (IOException e) {
			throw new HelionException(e);
		} catch (TemplateException e) {
			throw new HelionException(e);
		}
	}

	/**
	 * @param context
	 * @return
	 * @throws IOException
	 */
	public static Configuration loadFMConfiguration(PipelineContext context) throws IOException {
		configuration = new Configuration();
		configuration.setDefaultEncoding("UTF-8");
		configuration.setObjectWrapper(new DefaultObjectWrapper());
		configuration.setIncompatibleImprovements(new Version(2, 3, 20));
		configuration.setTemplateLoader(new MultiTemplateLoader(getTemplateLoaders(context)));
		configuration.setTemplateExceptionHandler(TemplateExceptionHandler.HTML_DEBUG_HANDLER);
		return configuration;
	}

	/**
	 * @param context
	 * @return
	 * @throws IOException
	 */
	public static TemplateLoader[] getTemplateLoaders(PipelineContext context) throws IOException {
		int idx = 0;
		TemplateLoader[] loaders = new TemplateLoader[context.getTemplateDir().size()];
		for (String templateDir : context.getTemplateDir())
			loaders[idx++] = new FileTemplateLoader(new File(templateDir));
		return loaders;
	}

}
