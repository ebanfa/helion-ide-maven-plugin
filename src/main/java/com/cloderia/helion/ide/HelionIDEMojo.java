/**
 * 
 */
package com.cloderia.helion.ide;

import java.util.List;

import org.apache.maven.plugins.annotations.Mojo;

import com.cloderia.helion.ide.build.BuildContext;
import com.cloderia.helion.ide.build.HelionIDEBuildPipeline;
import com.cloderia.helion.ide.build.processors.BuildProcessor;
import com.cloderia.helion.ide.util.IDEUtil;

/**
 * @author adrian
 *
 */
@Mojo(name="helion")
public class HelionIDEMojo extends AbstractIDEMojo {

	
	@Override
	public void execute(BuildContext buildContext) throws IDEException {
		build(buildContext);
	}

	/**
	 * @param buildContext
	 */
	protected void build(BuildContext buildContext) {
		List<BuildProcessor<BuildContext>> processors = IDEUtil.getBuildProcessors(buildContext);
		HelionIDEBuildPipeline pipeline = new HelionIDEBuildPipeline(processors);
		pipeline.build(buildContext);
	}
	
}
