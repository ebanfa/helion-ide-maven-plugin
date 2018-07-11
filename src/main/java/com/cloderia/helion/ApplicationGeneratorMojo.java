/**
 * 
 */
package com.cloderia.helion;

import org.apache.maven.plugins.annotations.LifecyclePhase;
import org.apache.maven.plugins.annotations.Mojo;

/**
 * This class represents a Maven goal
 * Life cycle is a sequence of named phases.
 * Phases executes sequentially. Executing a phase means executes all previous phases.
 * Plugin is a collection of goals also called MOJO (Maven Old Java Object).
 * Analogy : Plugin is a class and goals are methods within the class
 * 
 * @author adrian
 */
@Mojo(name="generate", defaultPhase = LifecyclePhase.GENERATE_SOURCES)
public class ApplicationGeneratorMojo extends AbstractPipelineMojo {}
