package astar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import resources.*;

public class Algorithm <S extends State, T extends Transition<S,E>, E extends Environment<S,E>, H extends Heuristic> {
	
	H heuristic;
	
	public Algorithm(H heuristic) {
		this.heuristic = heuristic;
	}
	
	@SuppressWarnings("unchecked")
	public Stack<S> search(S initial, S goal, T[] moves, E env) {
		PriorityQueue<Pair<S, E>> frontier = new PriorityQueue<Pair<S,E>>(new AstarComparator(goal));
		List<Pair<S,E>> explored = new ArrayList<Pair<S,E>>();
		
		frontier.add(new Pair<S,E>(initial,env));
		Pair<S,E> next = frontier.poll();
    	explored.add(next);
    	boolean reached_goal = false;
    	
    	//while there are nodes in the queue, keep exploring nodes.
    	// The algorithm A* guarantees that the minimum number of nodes are explored if there is a path.
    	while(next != null) {
    		if (next.a().distance(goal) == 0.0) {
    			reached_goal = true;
    			break;
    		}
    		else {
    			//expand the possible frontier to child nodes
    			frontier.addAll(nextStates(next.a(), moves, next.b(), explored));
    		}
    		next = frontier.poll(); //returns null if the priority queue is empty
    		explored.add(next);
    	}
    	if (reached_goal) {
            Stack<S> toReturn = new Stack<S>();
            S n = next.a();
            
            while(n.parent() != null) {
            	toReturn.push(n);
            	n = (S) n.parent();
            }
            
            return toReturn;
    	}
    	else {
    		//if we have exhausted all options (priority queue is empty, goal not found)
    		System.out.println("“No available path.”");
    		return new Stack<S>();
    	}
	}
	
	// f is the informed estimation of the distance to the goal
	// h is the heuristic estimate of cost to the goal (can't over estimate)
	// g is the cost already acrued on the path
	private double f(S current, S goal) {
		return heuristic.h(current, goal) + current.g();
	}
	
	private List<Pair<S,E>> nextStates(S current, T[] transitions, E env, List<Pair<S,E>> explored) {
		
		ArrayList<Pair<S,E>> new_states = new ArrayList<Pair<S,E>>();
		tLoop:
		for (T t : transitions) {
			if(t.is_valid(current, env)) {
				
				Pair<S,E> potential = t.actOn(current, env);
				for(Pair<S,E> s : explored) {
					if(s.a().distance(potential.a()) == 0.0) {
						continue tLoop; // with transitions loop
					}
				}
				
				new_states.add(t.actOn(current, env));
			}
		}
		
		return new_states;
	}	
	
	private class AstarComparator implements Comparator<Pair<S,E>> {
		S goal;
    	public AstarComparator(S goal)
    	{
    		this.goal = goal;
    	}
		@Override
		public int compare(Pair<S,E> arg0, Pair<S,E> arg1) {
			if (f(arg0.a(), goal) - f(arg1.a(), goal) == 0.0 ) {
				return 0;
			}
			else if (f(arg0.a(), goal) - f(arg1.a(), goal) < 0.0 ) {
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
