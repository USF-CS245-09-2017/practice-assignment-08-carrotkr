import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class GraphAdjMatrix implements Graph {
	private int numVertices;
	private LinkedList<Integer>[] adjMatrix;
	private int[] indegree; 
	
	/**
	 * Constructs and returns a graph with the number of vertices passed as the argument.
	 * Vertices have IDs, numbered 0, 1, …, vertices-1.
	 * No edges exist between vertices at instantiation.
	 * 
	 * @param
	 */
	public GraphAdjMatrix(int vertices) {
		numVertices = vertices;
		adjMatrix = new LinkedList[vertices];
		
		indegree = new int[vertices];
		
		for (int i = 0; i < vertices; ++i) {
			adjMatrix[i] = new LinkedList<Integer>();
		}
	}

	/**
	 * addEdge
	 * 
	 * @param
	 * @param
	 */
	@Override
	public void addEdge(int source, int target) {
		adjMatrix[source].add(target);
 
		indegree[target]++;
	}

	/**
	 * Returns an array of vertex IDs such that each ID represents a vertex
	 * 	which is the destination of the edge origination from the argument.
	 */
	@Override
	public int[] neighbors(int vertex) {
		
		return indegree;
	}
	
	/**
	 * topologicalSortHelper
	 * 
	 * @param
	 * @param
	 * @param
	 */
    private void topologicalSortHelper(int v, boolean visited[], Stack<Integer> stack) {
        visited[v] = true;
        Integer i;
 
        Iterator<Integer> it = adjMatrix[v].iterator();
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                topologicalSortHelper(i, visited, stack);
            }
        }
 
        stack.push(new Integer(v));
    }
	
    /**
     * topologicalSort
     */
	@Override
	public void topologicalSort() {
		Stack<Integer> stack = new Stack<Integer>();
		
		boolean visited[] = new boolean[numVertices];
		for (int i = 0; i < numVertices; i++) {
			visited[i] = false;
		}
		
		for (int i = 0; i < numVertices; i++) {
            if (visited[i] == false) {
                topologicalSortHelper(i, visited, stack);
            }
		}
		
		while (stack.empty() == false) {
            System.out.print(stack.pop() + " ");
		}
	}
}