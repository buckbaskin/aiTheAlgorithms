package astar;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

import resources.*;

public class Algorithm <S extends State, T extends Transition, E extends Environment> {//, H extends Heuristic> {
	
	//H heuristic;
	
	//public Algorithm(H heuristic) {
	//	this.heuristic = heuristic;
	//}
	
	public Stack<Pair<S,T>> search(S initial, S goal, T[] moves, E env) {
		PriorityQueue<S> frontier = new PriorityQueue<S>();
		
		return null;
	}
	
	//
	private double f(S current, S goal) {
		// TODO fix
		return 0.0;
	}
	
	private class AstarComparator implements Comparator<S> {
		S goal;
    	public AstarComparator(S goal)
    	{
    		this.goal = goal;
    	}
		@Override
		public int compare(S arg0, S arg1) {
			if (f(arg0, goal) - f(arg1, goal) == 0.0 ) {
				return 0;
			}
			else if (f(arg0, goal) - f(arg1, goal) < 0.0 ) {
				return -1;
			}
			else {
				return 1;
			}
		}
	}
	/*
	public static class MyComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer one, Integer two) {
			if (one - two == 0.0 ) {
				return 0;
			}
			else if (one - two < 0.0 ) {
				return -1;
			}
			else {
				return 1;
			}
		}
	}
	*/
	
	public static void main(String[] args) {
		/*
		PriorityQueue<Integer> pqi = new PriorityQueue<Integer>(new MyComparator());
		pqi.add(1);
		pqi.add(3);
		pqi.add(2);
		System.out.println("1: "+pqi.poll());
		System.out.println("2: "+pqi.poll());
		System.out.println("3: "+pqi.poll());
		*/
	}
	
}
