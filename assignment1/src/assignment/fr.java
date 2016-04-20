package assignment;

public class fr {

	
	private static Map<Character, String> generateCodeMap(HuffmanNode node) {
		Map<Character, String> map = new HashMap<Character, String>();
	    doGenerateCode(node, map, "",array);
	    return map;
	}

	private static void doGenerateCode(HuffmanNode node, Map<Character, String> map, String s,	ArrayList<String> array) {
		 if (node.left == null && node.right == null) {
	            map.put(node.ch, s);
	            array.add(node.ch+s);
	            return;
	        }    
	        doGenerateCode(node.left, map, s + '0',array);
	        doGenerateCode(node.right, map, s + '1',array );
		
	}
	
	
}
