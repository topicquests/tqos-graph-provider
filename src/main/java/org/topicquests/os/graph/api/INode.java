/**
 * 
 */
package org.topicquests.os.graph.api;

import java.util.List;
import java.io.PrintWriter;
import org.topicquests.support.api.IResult;

import net.minidev.json.JSONObject;

/**
 * @author jackpark
 * <p>Root API for both {@code IVertex} and {@code IEdge}</p>
 * <p>Both are implemented in a single class so that an
 *  {@ IEdge} can be cast as an {@code IVertex} and vice versa.</p>
 */
public interface INode {

	//////////////////////
	// Utility Identity
	//////////////////////
	JSONObject getData();
	String toJSONString();
	
	void toJSONString(PrintWriter out);
	
	//////////////////////
	// Node Identity
	//////////////////////
	void setId(String id);
	String getId();
	
	//////////////////////
	// Text
	//////////////////////
	void setLabel(String label, String language);
	
	/**
	 * 
	 * @param language can be {@code null}
	 * @return
	 */
	String getLabel(String language);
	
	void addDescription(String description, String language);
	
	/**
	 * Returns all descriptions if {@code language} is {@code null}
	 * @param language
	 * @return
	 */
	List<String> listDescriptions(String language);

	//////////////////////
	// Properties
	//////////////////////
	
	IResult addProperty(String key, Object value);
	
	IResult addToSetProperty(String key, String value);
	
	/**
	 * Returns an {@code Object} in the result. It's up to
	 * caller to cast as needed
	 * @param key
	 * @return
	 */
	IResult getValue(String key);
	
	IResult removeProperty(String key);
	

	
}
