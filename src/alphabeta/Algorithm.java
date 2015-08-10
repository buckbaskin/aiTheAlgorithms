package alphabeta;

import java.util.ArrayList;
import java.util.List;

import resources.Environment;
import resources.Heuristic;
import resources.Pair;
import resources.State;
import resources.Transition;

/*
 * Class implements minimax adversarial search with alpha-beta pruning
 */

public class Algorithm <S extends State, T extends Transition<S,E>, E extends Environment<S,E>> {
	
	Heuristic<S> h;
	NodeOrder<S,E> no;
	
	public Algorithm(Heuristic<S> heuristic, NodeOrder<S,E> node_order, int depth) {
		h = heuristic;
		no = node_order;
	}
	
	public T search(S user_state, S adversary_state, T[] user_moves, T[] adversary_moves, E env) {
		// default is searching from user move
		
		List<Pair<S,E>> ordered_children = no.order(generate_children(user_state, user_moves, env));
		
		return user_moves[0];
	}
	
	public List<Pair<S,E>> generate_children(S state, T[] moves, E env) {
		List<Pair<S,E>> children = new ArrayList<Pair<S,E>>();
		for(T move: moves) {
			if(move.is_valid(state,env)) {
				children.add(move.actOn(state, env));
			}
		}
		return children;
	}
}