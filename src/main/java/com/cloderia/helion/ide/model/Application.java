/**
 * 
 */
package com.cloderia.helion.ide.model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author adrian
 *
 */
@SuppressWarnings("restriction")
@XmlRootElement(name="application")
public class Application extends AbstractArtifact {
	
	private String groupId;
	private String artifactId;
	private String version;
	private DatabaseData database;
	private List<Module> modules = new ArrayList<Module>();

	/**
	 * 
	 */
	public Application() {
	}
	
	/**
	 * @return the groupId
	 */
	public String getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId the groupId to set
	 */
	@XmlElement
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the artifactId
	 */
	public String getArtifactId() {
		return artifactId;
	}

	/**
	 * @param artifactId the artifactId to set
	 */
	@XmlElement
	public void setArtifactId(String artifactId) {
		this.artifactId = artifactId;
	}


	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * @param version the version to set
	 */
	@XmlElement
	public void setVersion(String version) {
		this.version = version;
	}

	/**
	 * @return the database
	 */
	public DatabaseData getDatabase() {
		return database;
	}

	/**
	 * @param database the database to set
	 */
	@XmlElement
	public void setDatabase(DatabaseData database) {
		this.database = database;
	}

	/**
	 * @return the modules
	 */
	public List<Module> getModules() {
		return modules;
	}

	/**
	 * @param modules the modules to set
	 */
	@XmlElement(name="module")
	@XmlElementWrapper(name="modules")
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.artifacts.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactType() {
		return "application";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Application [" + ", groupId=" + groupId + ", artifactId=" + artifactId 
				+ ", version=" + version + ", database=" + database + ", modules=" + modules + "]";
	}

}
