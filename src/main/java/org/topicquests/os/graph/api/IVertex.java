/**
 * 
 */
package org.topicquests.os.graph.api;

/**
 * @author jackpark
 * Code adapted from TinkerPop Blueprints
 */
public interface IVertex extends INode {

    /**
     * Return the edges incident to the vertex according to the provided direction and edge labels.
     *
     * @param direction the direction of the edges to retrieve
     * @param labels    the labels of the edges to retrieve
     * @return an iterable of incident edges
     */
    public Iterable<IEdge> getEdges(IDirection direction, String... labels);

    /**
     * Return the vertices adjacent to the vertex according to the provided direction and edge labels.  This
     * method does not remove duplicate vertices (i.e. those vertices that are connected by more than one edge).
     *
     * @param direction the direction of the edges of the adjacent vertices
     * @param labels    the labels of the edges of the adjacent vertices
     * @return an iterable of adjacent vertices
     */
    public Iterable<IVertex> getVertices(IDirection direction, String... labels);

 
    /**
     * Add a new outgoing edge from this vertex to the parameter vertex with provided edge label.
     *
     * @param label    the label of the edge
     * @param inVertex the vertex to connect to with an incoming edge
     * @return the newly created edge
     */
    public IEdge addEdge(String label, IVertex inVertex);
}
