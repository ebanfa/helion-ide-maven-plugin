/**
 * 
 */
package com.cloderia.helion.ide.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * @author adrian
 *
 */
public class Entity implements ArtifactData {

	private String name;
	private boolean global;
	private String postName;
	private boolean isVirtual;
	private boolean hasOverride;
	private String parentName;
	private String displayName;
	private String description;
	private String viewFilterTemplate;
	private String singleViewTemplate;
	private String singleViewModelTemplate;
	private String singleViewActionTemplate;
	private String singlePageTemplate;
	private String createViewTemplate;
	private String createViewModelTemplate;
	private String createViewActionTemplate;
	private String editViewTemplate;
	private String listViewTemplate;
	private String createPageTemplate;
	private String editPageTemplate;
	private String editorTemplate;
	private String listPageTemplate;
	private String basePageTemplate;
	private String serviceTemplate;
	private String serviceImplTemplate;
	private String endPointTemplate;
	private String endPointImplTemplate;
	private String modelTemplate;
	private String relatedEntityFieldName;
	private Module module;
	private List<Field> fields = new ArrayList<Field>();
	private List<Field> virtualFields = new ArrayList<Field>();
	private List<RelatedEntity> relatedEntity = new ArrayList<RelatedEntity>();
	private Map<String, Field> relatedChildFields = new HashMap<String, Field>();
	private Map<String, Entity> relatedChildEntities = new HashMap<String, Entity>();

	/**
	 * 
	 */
	public Entity() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the singleViewTemplate
	 */
	public String getSingleViewTemplate() {
		return singleViewTemplate;
	}

	/**
	 * @param singleViewTemplate the singleViewTemplate to set
	 */
	@XmlElement
	public void setSingleViewTemplate(String singleViewTemplate) {
		this.singleViewTemplate = singleViewTemplate;
	}

	/**
	 * @return the singleViewModelTemplate
	 */
	public String getSingleViewModelTemplate() {
		return singleViewModelTemplate;
	}

	/**
	 * @param singleViewModelTemplate the singleViewModelTemplate to set
	 */
	@XmlElement
	public void setSingleViewModelTemplate(String singleViewModelTemplate) {
		this.singleViewModelTemplate = singleViewModelTemplate;
	}

	/**
	 * @return the viewFilterTemplate
	 */
	public String getViewFilterTemplate() {
		return viewFilterTemplate;
	}

	/**
	 * @param viewFilterTemplate the viewFilterTemplate to set
	 */
	@XmlElement
	public void setViewFilterTemplate(String viewFilterTemplate) {
		this.viewFilterTemplate = viewFilterTemplate;
	}

	/**
	 * @return the createViewTemplate
	 */
	public String getCreateViewTemplate() {
		return createViewTemplate;
	}

	/**
	 * @param createViewTemplate the createViewTemplate to set
	 */
	@XmlElement
	public void setCreateViewTemplate(String createViewTemplate) {
		this.createViewTemplate = createViewTemplate;
	}


	/**
	 * @return the createViewModelTemplate
	 */
	public String getCreateViewModelTemplate() {
		return createViewModelTemplate;
	}

	/**
	 * @param createViewModelTemplate the createViewModelTemplate to set
	 */
	@XmlElement
	public void setCreateViewModelTemplate(String createViewModelTemplate) {
		this.createViewModelTemplate = createViewModelTemplate;
	}

	/**
	 * @return the singleViewActionTemplate
	 */
	public String getSingleViewActionTemplate() {
		return singleViewActionTemplate;
	}

	/**
	 * @param singleViewActionTemplate the singleViewActionTemplate to set
	 */
	@XmlElement
	public void setSingleViewActionTemplate(String singleViewActionTemplate) {
		this.singleViewActionTemplate = singleViewActionTemplate;
	}

	/**
	 * @return the createViewActionTemplate
	 */
	public String getCreateViewActionTemplate() {
		return createViewActionTemplate;
	}

	/**
	 * @param createViewActionTemplate the createViewActionTemplate to set
	 */
	@XmlElement
	public void setCreateViewActionTemplate(String createViewActionTemplate) {
		this.createViewActionTemplate = createViewActionTemplate;
	}

	/**
	 * @return the listViewTemplate
	 */
	public String getListViewTemplate() {
		return listViewTemplate;
	}

	/**
	 * @param listViewTemplate the listViewTemplate to set
	 */
	@XmlElement
	public void setListViewTemplate(String listViewTemplate) {
		this.listViewTemplate = listViewTemplate;
	}

	
	/**
	 * @return the serviceTemplate
	 */
	public String getServiceTemplate() {
		return serviceTemplate;
	}

	/**
	 * @param serviceTemplate the serviceTemplate to set
	 */
	@XmlElement
	public void setServiceTemplate(String serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
	}

	/**
	 * @return the name
	 */
	public boolean getGlobal() {
		return global;
	}

	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setGlobal(boolean global) {
		this.global = global;
	}

	/**
	 * @return the name
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the displayName
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * @param displayName the displayName to set
	 */
	@XmlElement
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * @return the name
	 */
	public String getPostName() {
		return postName;
	}

	/**
	 * @param name the name to set
	 */
	@XmlElement
	public void setPostName(String postName) {
		this.postName = postName;
	}

	/**
	 * @return the parentName	
	 */
	public String getParentName() {
		return parentName;
	}

	/**
	 * @param parentName the parentName to set
	 */
	@XmlElement
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	/**
	 * @return the isVirtual
	 */
	public boolean getIsVirtual() {
		return isVirtual;
	}

	/**
	 * @param isVirtual the isVirtual to set
	 */
	@XmlElement
	public void setIsVirtual(boolean isVirtual) {
		this.isVirtual = isVirtual;
	}

	/**
	 * @return the relatedEntityFieldName
	 */
	public String getRelatedEntityFieldName() {
		return relatedEntityFieldName;
	}

	/**
	 * @param relatedEntityFieldName the relatedEntityFieldName to set
	 */
	public void setRelatedEntityFieldName(String relatedEntityFieldName) {
		this.relatedEntityFieldName = relatedEntityFieldName;
	}

	/**
	 * @return the relatedChildEntities
	 */
	public List<Field> getFields() {
		return fields;
	}

	/**
	 * @param fields the fields to set
	 */
	@XmlElement(name="field")
	public void setFields(List<Field> fields) {
		this.fields = fields;
	}

	/**
	 * @return the virtualFields
	 */
	public List<Field> getVirtualFields() {
		return virtualFields;
	}

	/**
	 * @param virtualFields the virtualFields to set
	 */
	public void setVirtualFields(List<Field> virtualFields) {
		this.virtualFields = virtualFields;
	}

	/**
	 * @return the relatedChildEntities
	 */
	public Map<String, Entity> getRelatedChildEntities() {
		return relatedChildEntities;
	}

	/**
	 * @param relatedChildEntities the relatedChildEntities to set
	 */
	public void setRelatedChildEntities(Map<String, Entity> relatedChildEntities) {
		this.relatedChildEntities = relatedChildEntities;
	}
/**
	 * @return the createPageTemplate
	 */
	public String getCreatePageTemplate() {
		return createPageTemplate;
	}

	/**
	 * @param createPageTemplate the createPageTemplate to set
	 */
	@XmlElement
	public void setCreatePageTemplate(String createPageTemplate) {
		this.createPageTemplate = createPageTemplate;
	}

	/**
	 * @return the editPageTemplate
	 */
	public String getEditPageTemplate() {
		return editPageTemplate;
	}

	/**
	 * @param editPageTemplate the editPageTemplate to set
	 */
	@XmlElement
	public void setEditPageTemplate(String editPageTemplate) {
		this.editPageTemplate = editPageTemplate;
	}

	/**
	 * @return the singlePageTemplate
	 */
	public String getSinglePageTemplate() {
		return singlePageTemplate;
	}

	/**
	 * @param singlePageTemplate the singlePageTemplate to set
	 */
	@XmlElement
	public void setSinglePageTemplate(String singlePageTemplate) {
		this.singlePageTemplate = singlePageTemplate;
	}

	/**
	 * @return the listPageTemplate
	 */
	public String getListPageTemplate() {
		return listPageTemplate;
	}

	/**
	 * @param listPageTemplate the listPageTemplate to set
	 */
	@XmlElement
	public void setListPageTemplate(String listPageTemplate) {
		this.listPageTemplate = listPageTemplate;
	}

	/**
	 * @return the relatedChildFields
	 */
	public Map<String, Field> getRelatedChildFields() {
		return relatedChildFields;
	}

	/**
	 * @param relatedChildFields the relatedChildFields to set
	 */
	public void setRelatedChildFields(Map<String, Field> relatedChildFields) {
		this.relatedChildFields = relatedChildFields;
	}

	/**
	 * @return the serviceImplTemplate
	 */
	public String getServiceImplTemplate() {
		return serviceImplTemplate;
	}

	/**
	 * @param serviceImplTemplate the serviceImplTemplate to set
	 */
	@XmlElement
	public void setServiceImplTemplate(String serviceImplTemplate) {
		this.serviceImplTemplate = serviceImplTemplate;
	}

	/**
	 * @return the endPointTemplate
	 */
	public String getEndPointTemplate() {
		return endPointTemplate;
	}

	/**
	 * @param endPointTemplate the endPointTemplate to set
	 */
	@XmlElement
	public void setEndPointTemplate(String endPointTemplate) {
		this.endPointTemplate = endPointTemplate;
	}

	/**
	 * @return the endPointImplTemplate
	 */
	public String getEndPointImplTemplate() {
		return endPointImplTemplate;
	}

	/**
	 * @param endPointImplTemplate the endPointImplTemplate to set
	 */
	@XmlElement
	public void setEndPointImplTemplate(String endPointImplTemplate) {
		this.endPointImplTemplate = endPointImplTemplate;
	}

	/**
	 * @return the editViewTemplate
	 */
	public String getEditViewTemplate() {
		return editViewTemplate;
	}

	/**
	 * @param editViewTemplate the editViewTemplate to set
	 */
	@XmlElement
	public void setEditViewTemplate(String editViewTemplate) {
		this.editViewTemplate = editViewTemplate;
	}

	/* (non-Javadoc)
	 * @see com.cloderia.helion.ide.app.ArtifactData#getArtifactDataType()
	 */
	public String getArtifactDataType() {
		return "entity";
	}

	

	/**
	 * @return the module
	 */
	public Module getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	@XmlTransient
	public void setModule(Module module) {
		this.module = module;
	}

	/**
	 * @return the hasOverride
	 */
	public boolean isHasOverride() {
		return hasOverride;
	}

	/**
	 * @param hasOverride the hasOverride to set
	 */
	public void setHasOverride(boolean hasOverride) {
		this.hasOverride = hasOverride;
	}

	/**
	 * @return the relatedEntity
	 */
	public List<RelatedEntity> getRelatedEntity() {
		return relatedEntity;
	}

	/**
	 * @param relatedEntity the relatedEntity to set
	 */
	@XmlElement
	public void setRelatedEntity(List<RelatedEntity> relatedEntity) {
		this.relatedEntity = relatedEntity;
	}

	/**
	 * @return the modelTemplate
	 */
	public String getModelTemplate() {
		return modelTemplate;
	}

	/**
	 * @param modelTemplate the modelTemplate to set
	 */
	@XmlElement
	public void setModelTemplate(String modelTemplate) {
		this.modelTemplate = modelTemplate;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Entity [name=" + name + ", global=" + global + ", postName=" + postName + ", isVirtual=" + isVirtual
				+ ", hasOverride=" + hasOverride + ", parentName=" + parentName + ", displayName=" + displayName
				+ ", description=" + description + ", viewFilterTemplate=" + viewFilterTemplate
				+ ", singleViewTemplate=" + singleViewTemplate + ", createViewTemplate=" + createViewTemplate
				+ ", editViewTemplate=" + editViewTemplate + ", listViewTemplate=" + listViewTemplate
				+ ", createPageTemplate=" + createPageTemplate + ", editPageTemplate=" + editPageTemplate
				+ ", listPageTemplate=" + listPageTemplate + ", singlePageTemplate=" + singlePageTemplate + ", serviceTemplate="
				+ serviceTemplate + ", serviceImplTemplate=" + serviceImplTemplate + ", endPointTemplate=" + endPointTemplate
				+ ", endPointImplTemplate=" + endPointImplTemplate + ", modelTemplate=" + modelTemplate
				+ ", relatedEntityFieldName=" + relatedEntityFieldName + ", module=" + module + ", fields=" + fields
				+ ", virtualFields=" + virtualFields + ", relatedEntity=" + relatedEntity + ", relatedChildFields="
				+ relatedChildFields + ", relatedChildEntities=" + relatedChildEntities + "]";
	}

	/**
	 * @return the basePageTemplate
	 */
	public String getBasePageTemplate() {
		return basePageTemplate;
	}

	/**
	 * @param basePageTemplate the basePageTemplate to set
	 */
	@XmlElement
	public void setBasePageTemplate(String basePageTemplate) {
		this.basePageTemplate = basePageTemplate;
	}

	/**
	 * @return the editorTemplate
	 */
	public String getEditorTemplate() {
		return editorTemplate;
	}

	/**
	 * @param editorTemplate the editorTemplate to set
	 */
	@XmlElement
	public void setEditorTemplate(String editorTemplate) {
		this.editorTemplate = editorTemplate;
	}

}
