/**
 * 
 */
package com.cloderia.helion.util;

/**
 * @author adrian
 *
 */
public class IDEConstants {
	public static final String MODULE_CONFIG_FILE = "modules-config.xml";
	public static final String ENTITY_CONFIG_FILE = "entities-config.xml";
	/** Build context keys */
	public static final String ENTITIES_IN_DB_CONTEXT_KEY = "ENTITIES_IN_DB";
	/** Maven directory structure constants */
	public static final String SRC_DIR = StringUtil.trailingSlashIt("src");
	public static final String SRC_MAIN_DIR = SRC_DIR + StringUtil.trailingSlashIt("main");
	public static final String JAVA_DIR = SRC_MAIN_DIR + StringUtil.trailingSlashIt("java");
	public static final String RESOURCES_DIR = SRC_MAIN_DIR + StringUtil.trailingSlashIt("resources");
	public static final String JAVA_PERSISTENCE_DIR = StringUtil.trailingSlashIt("persistence");
	public static final String JAVA_ENTITY_PERSISTENCE_DIR = StringUtil.trailingSlashIt("entity");
	public static final String JAVA_ENTITY_OP_PERSISTENCE_DIR = StringUtil.trailingSlashIt("operation");
	public static final String JAVA_SERVICE_PERSISTENCE_DIR = StringUtil.trailingSlashIt("service");
	public static final String JAVA_SERVICE_IMPL_PERSISTENCE_DIR = StringUtil.trailingSlashIt("impl");
	public static final String WEBAPP_DIR = StringUtil.trailingSlashIt("webapp");
	public static final String WEB_INF_DIR = StringUtil.trailingSlashIt("WEB-INF");

	/** Module files */
	public static final String MODULE_POM_XML = "pom.xml";
	public static final String MODULE_README_MD = "README.md";
	/** Web module files */
	public static final String WEB_XML = "web.xml";
	public static final String JBOSS_WEB_XML = "jboss-web.xml";
	
	/** Module template files */
	public static final String MODULE_POM_TMPL_FTL = "module/pom-xml.ftl";
	public static final String MODULE_README_TMPL_FTL = "module/readme-md.ftl";
	public static final String APPLICATION_POM_TMPL_FTL = "module/parent-pom-xml.ftl";
	public static final String APPLICATION_README_TMPL_FTL = "module/parent-readme-md.ftl";
	/** Web module template files */
	public static final String WEB_XML_TMPL_FTL = "module/webapp/web-xml.ftl";
	public static final String JBOSS_WEB_XML_TMPL_FTL = "module/webapp/jboss-web.ftl";
}
