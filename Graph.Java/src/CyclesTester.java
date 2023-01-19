//------------------------------------------------------------------------------------------------------------------------------------
// Title: CyclesTester class
// Author: Hüseyin Ufuk Yýlmaz
// ID: 21826286904
// Section: 02
// Assignment: 1
// Description: this class is main class. 
//-------------------------------------------------------------------------------------------------------------------------------------
import java.util.Scanner;
public class CyclesTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		int temp = 0, size = 0;
		char index = '\0';
		String path = keyboard.next();
		for (int i = 0; i < path.length(); i += 2) {

			if (temp < (int) (path.charAt(i))) {
				temp = (int) (path.charAt(i));        //This for loop determines the size of Array which is created in Graph class.
			}

			size = temp + 1;
		}
		Graph graph = new Graph(size);                // Graph object is created.
		for (int i = 0; i < path.length(); i += 4) {
			if (i == path.length() - 1) {                            //This for loop takes the points that are letter. 
				break;
			}

			graph.addEdge(path.charAt(i), path.charAt(i + 2));  // Graph is connected.
		}
		index = keyboard.next().charAt(0);    // Starting point
		graph.PrintCycle(graph, index);       // Print path

	}

}
