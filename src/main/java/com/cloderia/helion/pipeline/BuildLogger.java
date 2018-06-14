/**
 * 
 */
package com.cloderia.helion.pipeline;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * @author adrian
 *
 */
public class BuildLogger extends AbstractPipelineItem {

	@Override
	protected PipelineContext doExecute(PipelineContext context) {
		ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String json = mapper.writeValueAsString(context);
            System.out.println(json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
		return context;
	}

}
