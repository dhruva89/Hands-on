package geeksForGeeks;

import concepts.Graph;
import concepts.GraphNode;

public class detectCycle {

		static Graph<Integer> input;
		
		public static void main(String args[]){
			GraphNode<Integer> n1 = new GraphNode<Integer>(1);
			GraphNode<Integer> n2 = new GraphNode<Integer>(2);
			GraphNode<Integer> n3 = new GraphNode<Integer>(3);
			GraphNode<Integer> n4 = new GraphNode<Integer>(4);
			GraphNode<Integer> n5 = new GraphNode<Integer>(5);
			GraphNode<Integer> n6 = new GraphNode<Integer>(6);
			
			
			n1.children.add(n2);
			n2.children.add(n3);
			n2.children.add(n4);
			n5.children.add(n6);
			//n6.children.add(n5);
			input = new Graph<Integer>(n1,n2,n3,n4,n5,n6);
			
			System.out.println(input.isCyclic());
			
			
		}
}
