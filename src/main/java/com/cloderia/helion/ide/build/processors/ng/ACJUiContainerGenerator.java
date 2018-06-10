/**
 * 
 */
package com.cloderia.helion.ide.build.processors.ng;

import com.cloderia.helion.ide.IDEException;
import com.cloderia.helion.ide.artifacts.ContainerData;
import com.cloderia.helion.ide.artifacts.Entity;
import com.cloderia.helion.ide.artifacts.Module;
import com.cloderia.helion.ide.artifacts.UiConfig;
import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.processors.AbstractBuildProcessorDecorator;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.build.processors.wildfly.ACJProjectDirectoryBuilder;
import com.cloderia.helion.ide.util.FileUtil;
import com.cloderia.helion.ide.util.IDEUtil;
import com.cloderia.helion.ide.util.StringUtil;

/**
 * @author adrian
 *
 */
public class ACJUiContainerGenerator extends AbstractBuildProcessorDecorator {

	private static final String CONTAINER_COMPONENT_TMPL_FTL = "ui/container/container-component-ts.ftl";
	private static final String CONTAINER_COMPONENT_HTML_TMPL_FTL = "ui/container/container-component-html.ftl";
	private static final String CONTAINER_COMPONENT_CONTROLLER_TMPL_FTL = "ui/container/container-controller-ts.ftl";
	
	private static final String WIDGET_COMPONENT_TMPL_FTL = "ui/widget/widget-component-ts.ftl";
	private static final String WIDGET_COMPONENT_HTML_TMPL_FTL = "ui/widget/widget-component-html.ftl";
	private static final String WIDGET_COMPONENT_CONTROLLER_TMPL_FTL = "ui/widget/widget-controller-ts.ftl";
	
	/**
	 * @param processor
	 */
	public ACJUiContainerGenerator(BuildProcessor<BuildContext> processor){
		super(processor);
	}

	@Override
	protected BuildContext decorate(BuildContext context) {
		// The target 'components' directory
		/*UiConfig  config = context.getApplication().getUiConfig();
		String containerTargetDir = context.getTargetDir().concat(ACJProjectDirectoryBuilder.JAVA_SERVICE_PERSISTENCE_DIR);
		String widgetTargetDir = context.getTargetDir().concat(ACJProjectDirectoryBuilder.JAVA_SERVICE_IMPL_PERSISTENCE_DIR);
		// Loop through module down to entities and for each entity generate its artefacts
		for (ContainerData containerData : config.getContainerDatas()) {
				try {
					System.out.println(">>>>>>>>>>>>>>>" + containerData.getName());
					String containerComponentFileName = containerData.getId().concat(".container.ts");
					String containerTemplateFileName = containerData.getId().concat(".container.html");
					String containerControllerFileName = containerData.getId().concat(".controller.ts");

					String widgetComponentFileName = containerData.getId().concat(".widget.ts");
					String widgetTemplateFileName = containerData.getId().concat(".widget.html");
					String widgetControllerFileName = containerData.getId().concat(".widget.controller.ts");
					
					IDEUtil.generateArtifact(context, containerData, CONTAINER_COMPONENT_TMPL_FTL, containerComponentFileName, containerTargetDir);
					IDEUtil.generateArtifact(context, containerData, CONTAINER_COMPONENT_HTML_TMPL_FTL, containerTemplateFileName, containerTargetDir);
					IDEUtil.generateArtifact(context, containerData, CONTAINER_COMPONENT_CONTROLLER_TMPL_FTL, containerControllerFileName, containerTargetDir);
					
					IDEUtil.generateArtifact(context, containerData, WIDGET_COMPONENT_TMPL_FTL, widgetComponentFileName, widgetTargetDir);
					IDEUtil.generateArtifact(context, containerData, WIDGET_COMPONENT_HTML_TMPL_FTL, widgetTemplateFileName, widgetTargetDir);
					IDEUtil.generateArtifact(context, containerData, WIDGET_COMPONENT_CONTROLLER_TMPL_FTL, widgetControllerFileName, widgetTargetDir);
				} catch (IDEException e) {
					e.printStackTrace();
				}
		}*/
		return context;
	}

}
