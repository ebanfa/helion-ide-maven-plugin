/**
 * 
 */
package com.cloderia.helion.ide.pipeline;

import com.cloderia.helion.pipeline.AbstractPipelineItem;
import com.cloderia.helion.pipeline.PipelineContext;
import com.cloderia.helion.pipeline.PipelineException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author adrian
 *
 */
public class BuildLogger extends AbstractPipelineItem {

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
