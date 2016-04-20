package assignment;

import java.util.Comparator;

public class nodeCompare implements Comparator<node> {
	@Override 
	    public int compare(node node1, node node2) {
	    	
	    	if(node1.frequency>node2.frequency) return 1;
	    	else if(node1.frequency<node2.frequency) return -1;
	        return 0;
	    }
}
