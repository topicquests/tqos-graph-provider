/**
 * 
 */
package org.topicquests.os.graph.api;

import java.util.Map;

import org.topicquests.support.api.IResult;

/**
 * @author jackpark
 * A class for creating, fetching, destroying, and searching {@link IGraph) instances
 */
public interface IGraphModel {
	
	/**
	 * Create a graph given a collection of properties
	 * @param id
	 * @param description
	 * @param language
	 * @param creatorId
	 * @return
	 */
	IGraph createGraph(String id, String description, String language, String creatorId);
	
	/**
	 * Fetch a graph identified by {@link id}
	 * @param id
	 * @return can return {@code null}
	 */
	IGraph getGraph(String id);
	
	/**
	 * Removie a graph identified by {@link id}
	 * @param id
	 * @return
	 */
	IResult removeGraph(String id);
	
	/**
	 * Find an individual or collection of graphs with given properties
	 * @param properties
	 * @return can return an empty list
	 */
	IResult findByKeyValuePairs(Map<String, String> properties);

}
