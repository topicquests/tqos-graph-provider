package org.topicquests.os.graph.api;


/**
 * 
 * @author jackpark
 *
 */
public interface IEdge extends INode {

    /**
     * Return the tail/out or head/in vertex.
     * @see Blueprints Edge
     * @param direction whether to return the tail/out or head/in vertex
     * @return the tail/out or head/in vertex
     * @throws IllegalArgumentException is thrown if a direction of both is provided
     */
    public IVertex getVertex(IDirection direction) throws IllegalArgumentException;

}
