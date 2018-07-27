/**
 * 
 */
package com.cloderia.helion.util;

/**
 * @author adrian
 *
 */
public class IDEConstants {
	public static final String MODULE_CONFIG_FILE = "module-config.xml";
	public static final String ENTITY_CONFIG_FILE = "entities-config.xml";
	/** Build context keys */
	public static final String ENTITIES_IN_DB_CONTEXT_KEY = "entitiesReadFromTheDatabase";
	public static final String APPLICATION_CONFIG_KEY = "applicationConfiguration";
	public static final String APPLICATION_OBJ_KEY = "application";
	/** Maven directory structure constants */
	public static final String SRC_DIR = StringUtil.trailingSlashIt("src");
	public static final String SRC_MAIN_DIR = SRC_DIR + StringUtil.trailingSlashIt("main");
	public static final String JAVA_DIR = SRC_MAIN_DIR + StringUtil.trailingSlashIt("java");
	public static final String RESOURCES_DIR = SRC_MAIN_DIR + StringUtil.trailingSlashIt("resources");
	public static final String RESOURCES_META_INF_DIR = RESOURCES_DIR + StringUtil.trailingSlashIt("META-INF");
	public static final String JAVA_PERSISTENCE_DIR = StringUtil.trailingSlashIt("entity");
	public static final String JAVA_PERSISTENCE_OPS_DIR = StringUtil.trailingSlashIt("operation");
	public static final String JAVA_SERVICE_DIR = StringUtil.trailingSlashIt("service");
	public static final String JAVA_WEB_DIR = StringUtil.trailingSlashIt("service");
	public static final String WEBAPP_DIR = StringUtil.trailingSlashIt("webapp");
	public static final String WEB_INF_DIR = StringUtil.trailingSlashIt("WEB-INF");

	/** Module files */
	public static final String POM_XML_FILE_NAME = "pom.xml";
	public static final String README_MD_FILE_NAME = "README.md";
	/** Web module files */
	public static final String WEB_XML = "web.xml";
	public static final String JBOSS_WEB_XML = "jboss-web.xml";
	
	/** Module template files */
	public static final String MODULE_POM_TMPL_FTL = "module/pom-xml.ftl";
	public static final String MODULE_README_TMPL_FTL = "module/readme-md.ftl";
	public static final String APPLICATION_POM_TMPL_FTL = "parent-pom-xml.ftl";
	public static final String APPLICATION_README_TMPL_FTL = "parent-readme-md.ftl";
	public static final String APPLICATION_EAR_POM_TMPL_FTL = "ear-pom-xml.ftl";
	public static final String APPLICATION_EAR_README_TMPL_FTL = "ear-readme-md.ftl";
	/** Web module template files */
	public static final String WEB_XML_TMPL_FTL = "module/webapp/web-xml.ftl";
	public static final String JBOSS_WEB_XML_TMPL_FTL = "module/webapp/jboss-web.ftl";
	public static final String WEB_MODULE_RS_APPL_TMPL_FTL = "module/webapp/rs-application-java.ftl";
	public static final String WEB_WS_SERVICE_TMPL_FTL = "module/webapp/ws-service-java.ftl";
	/** Default entity template file */
	public static final String ENTITY_JAVA_TMPL_FTL = "module/entity/entity.ftl";
	public static final String ENTITY_OPS_JAVA_TMPL_FTL = "module/entity/entity-ops.ftl";
	public static final String ENTITY_JAVA_SERVICE_TMPL_FTL = "module/entity/entity-service-interface.ftl";
	public static final String ENTITY_JAVA_SERVICE_IMPL_TMPL_FTL = "module/entity/entity-service-implementation.ftl";
	
	public static final String PERSISTENCE_XML_TMPL_FTL = "module/META-INF/persistence-xml.ftl";
	public static final String PERSISTENCE_XML = "persistence.xml";

	/** Configuration parameters */
	public static final String DB_ID_CONFIG_PARAM = "databaseId";
	public static final String DB_URL_CONFIG_PARAM = "databaseUrl";
	public static final String DB_USER_CONFIG_PARAM = "databaseUser";
	public static final String DB_PASSWORD_CONFIG_PARAM = "databasePassword";
	public static final String DB_JNDI_URL_CONFIG_PARAM = "databaseJndiUrl";
	
	public static final String MODULE_ENTITIES_FILE_CONFIG_PARAM = "entitiesConfFile";
	
	public static final String POM_TMPL_FILE_CONFIG_PARAM = "pomTemplateFile";
	
	public static final String ENTITY_TMPL_FILE_CONFIG_PARAM = "entityTemplateFile";
	public static final String ENTITY_OPS_TMPL_FILE_CONFIG_PARAM = "entityOpsTemplateFile";
	public static final String ENTITY_SERVICE_TMPL_FILE_CONFIG_PARAM = "entityServiceTemplateFile";
	public static final String ENTITY_SERVICE_IMPL_TMPL_FILE_CONFIG_PARAM = "entityServiceImplTemplateFile";
	
	public static final String PIPELINE_CLASS_PARAM = "pipelineClass";
	public static final String PROJECT_DIR_PARAM = "projectDir";
	public static final String TARGET_DIR_PARAM = "targetDir";
	public static final String TEMPLATES_DIR_PARAM = "templatesDir";
	public static final String CONFIG_READER_CLASS_PARAM = "configReaderClass";
	public static final String CONFIG_READER_FILE_PARAM = "configFile";
	
	public static final String APPLICATION_BUILDER_CLASS_PARAM = "applicationBuilderClass";
	
	public static String APP_GEN_HEADER = 
			"------------------------------------------------------------------------\n"
			+ "                  HELION APPLICATION GENERATOR MOJO                     \n"
			+ "------------------------------------------------------------------------\n";
	
}
