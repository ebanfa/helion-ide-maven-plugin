/**
 * 
 */
package com.cloderia.helion.ide;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;

import schemacrawler.schema.Catalog;
import schemacrawler.schema.Column;
import schemacrawler.schema.Schema;
import schemacrawler.schema.Table;
import schemacrawler.schema.View;
import schemacrawler.schemacrawler.DatabaseConnectionOptions;
import schemacrawler.schemacrawler.ExcludeAll;
import schemacrawler.schemacrawler.RegularExpressionInclusionRule;
import schemacrawler.schemacrawler.SchemaCrawlerException;
import schemacrawler.schemacrawler.SchemaCrawlerOptions;
import schemacrawler.schemacrawler.SchemaInfoLevelBuilder;
import schemacrawler.utility.SchemaCrawlerUtility;

/**
 * @author adrian
 *
 */
@Mojo(name="generate-model")
public class DBToXMLEntityDataMojo  extends AbstractHelionMojo {

	public void execute() throws MojoExecutionException, MojoFailureException {
		// TODO Auto-generated method stub
		// Create a database connection
	    try {
			final DataSource dataSource = new DatabaseConnectionOptions("jdbc:hsqldb:hsql://localhost:9001/schemacrawler");
			final Connection connection = dataSource.getConnection("sa", "");

			// Create the options
			final SchemaCrawlerOptions options = new SchemaCrawlerOptions();
			// Set what details are required in the schema - this affects the
			// time taken to crawl the schema
			options.setSchemaInfoLevel(SchemaInfoLevelBuilder.standard());
			options.setRoutineInclusionRule(new ExcludeAll());
			options
			  .setSchemaInclusionRule(new RegularExpressionInclusionRule("PUBLIC.BOOKS"));

			// Get the schema definition
			final Catalog catalog = SchemaCrawlerUtility.getCatalog(connection,
			                                                        options);

			for (final Schema schema: catalog.getSchemas())
			{
			  System.out.println(schema);
			  for (final Table table: catalog.getTables(schema))
			  {
			    System.out.print("o--> " + table);
			    if (table instanceof View)
			    {
			      System.out.println(" (VIEW)");
			    }
			    else
			    {
			      System.out.println();
			    }

			    for (final Column column: table.getColumns())
			    {
			      System.out.println("     o--> " + column + " ("
			                         + column.getColumnDataType() + ")");
			    }
			  }
			}
		} catch (SchemaCrawlerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
