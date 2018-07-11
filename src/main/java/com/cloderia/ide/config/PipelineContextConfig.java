/**
 * 
 */
package com.cloderia.ide.config;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Edward Banfa
 *
 */
@XmlRootElement(name="context")
public class PipelineContextConfig extends AbstractContextConfig {
	
	/** Build pipeline */
	private List<PipelineItemConfig> pipelineItems;
	
	/**
	 * @return the pipelineItems
	 */
	public List<PipelineItemConfig> getPipelineItems() {
		return pipelineItems;
	}

	/**
	 * @param pipelineItems the pipelineItems to set
	 */
	@XmlElement(name="pipelineItem")
	@XmlElementWrapper(name="pipeline")
	public void setPipelineItems(List<PipelineItemConfig> pipelineItems) {
		this.pipelineItems = pipelineItems;
	}

}
