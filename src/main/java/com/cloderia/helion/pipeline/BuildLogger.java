/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.cloderia.helion.exception.PipelineException;
import com.cloderia.ide.config.PipelineItemConfig;
import com.cloderia.ide.pipeline.AbstractPipelineItem;
import com.cloderia.ide.pipeline.PipelineContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author adrian
 *
 */
public class BuildLogger extends AbstractPipelineItem {

	public BuildLogger(PipelineItemConfig config) {
		super(config);
	}

	@Override
	protected PipelineContext doExecute(PipelineContext context)  {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(context);
            System.out.println(json);
        } catch (JsonProcessingException e) {
        	throw new PipelineException(e);
        }
		return context;
	}

}
