import java.util.ArrayList;

public class Node {

	double[] question;
	Node rightOne; Node leftOne; ArrayList<String[]> data;
	
	public Node(ArrayList<String[]> data,double[] question) {
		this.data=data;
		this.question=question;
	}
}