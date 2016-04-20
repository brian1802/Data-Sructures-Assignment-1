package assignment;

public class node {
	char character;
	int frequency;
	node left;
	node right;
	
	public node(char character, int frequency, node left, node right)
	{
		this.character = character;
		this.frequency = frequency;
		this.left = left;
		this.right = right;
	}
	
	public node(char character, int frequency)
	{
		this.character = character;
		this.frequency = frequency;
	}
	
	public node()
	{
		
	}
	
	@Override
	public String toString() {
		return Character.toString(character) +Integer.toString(frequency);
	}
}
