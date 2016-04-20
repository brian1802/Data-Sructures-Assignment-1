package assignment;

import java.io.IOException;
import java.nio.file.ReadOnlyFileSystemException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 
 * @author Brian Carroll
 * @Date 20-04-2016
 * @gitHub 
 */
public class Main {

	public static void main(String[] args) throws IOException
	{
		String message = ReadFile();
		String scr = frequency(message);
		Map<Character, Integer> map = getMap(scr);
		System.out.println("This shows the frequency if the characters: " + map);
		PriorityQueue<node> pq = new PriorityQueue<>(new nodeCompare()); //Creates a new priority queue. 
		fillQueue(pq, scr);
		Main app = new Main();
		System.out.println("This shows the characters in oreder of least frequent: " + pq);
		node finalNode = new node();
		binaryString(finalNode);



		// Builds the tree. 
		while(pq.size() > 1)
		{
			node node1 = pq.remove();
			node node2 = pq.remove();
			node node3 = new node('\0', node1.frequency + node2.frequency, node1, node1);
			pq.add(node3);
		}
	}

	/**
	 * This creats a map for the binary version of the character
	 * @param node
	 * @return
	 */
	private static Map<Character, String> binaryString(node node)
	{
		Map<Character, String> map = new HashMap<Character, String>();
		generateString(node, map, "");
		return map;
	}

	/**
	 * First checks if it s the last node on the tree. Then it will recursively call until
	 * the last node is reacted. 
	 * @param node
	 * @param map1
	 * @param src
	 */
	private static void generateString(node node, Map<Character, String> map1, String src)
	{
		if(node.left == null && node.right == null)
		{
			map1.put(node.character, src);
			return;
		}
		generateString(node.left , map1, src + '0');
		generateString(node.right, map1, src + '1');
	}

	/**
	 * This will put the nodes into a priority queue. this will help for when we are building our tree. 
	 * @param pq
	 * @param scr
	 */
	private static void fillQueue(PriorityQueue<node> pq,String scr)
	{
		for(int i = 0; i < scr.length(); i += 2)
		{
			node n=new node(scr.charAt(i), Integer.parseInt(Character.toString((scr.charAt(i + 1)))));
			pq.add(n);
		}
	}

	/**
	 * This method will go through the string and then will put the characters in a hash map. 
	 * with the character and the primary and the frequency as the key.
	 * @param scr
	 * @return
	 */
	private static Map<Character, Integer> getMap(String scr) 
	{
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for(int i = 0; i < scr.length(); i += 2)
		{
			map.put(scr.charAt(i), Integer.parseInt(Character.toString((scr.charAt(i + 1)))));
		}
		return map;
	}

	/**
	 * This method will read in the string from the file and then will go through the string and get the 
	 * frequency for every character. Then it will add it to a string. 
	 * @param message
	 * @return
	 */
	public static String frequency(String message)
	{
		String scr = "";
		int size = message.length();
		int count1 = 0, count2 = 0;
		char z;

		while(count1 < size)
		{
			z = message.charAt(count1); //getting the character at the index.
			if(!scr.contains(Character.toString(z)))
			{
				count2 = 0;

				int count3 = 0;
				while(count3 < size)
				{
					if(message.charAt(count3) == z)
					{
						count2++;
					}
					count3 ++;
				}
				scr += z+ Integer.toString(count2);
			}
			count1 ++;
		}
		System.out.println(scr);
		return scr;
	}

	/**
	 * This method will read in a file. 
	 * @return
	 * @throws IOException
	 */
	public static String ReadFile() throws IOException
	{
		BufferedReader br = new BufferedReader(new FileReader("C:/Users/carro/workspace/assignment1/src/File.txt"));
		String sb = "";
		try
		{
			String line = br.readLine();

			while (line != null) {
				sb+=line;
				//sb.append(System.lineSeparator());	
				line = br.readLine();
			}
			String everything = sb.toString();
		} finally {
			br.close();
		}
		return sb;
	}
}
