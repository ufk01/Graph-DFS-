//------------------------------------------------------------------------------------------------------------------------------------
// Title: Deep First Search class
// Author: Hüseyin Ufuk Yýlmaz
// ID: 21826286904
// Section: 02
// Assignment: 1
// Description: This class provides to travel in graph.
//-------------------------------------------------------------------------------------------------------------------------------------
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class DeepFirstSearch {
	int firstIndex,h_size;
	String exp;
	boolean check;
	public boolean[] marked;
	ArrayList<String> arr;
	HashMap<Integer, String> h;

	public DeepFirstSearch(Graph G, int firstIndex)  // Constructor class.
	{
		this.firstIndex=firstIndex;
		marked = new boolean[G.V()];
		arr = new ArrayList<String>();
		h = new HashMap<Integer, String>();
		h_size=0;
		exp = Character.toString((char)firstIndex);
		check=false;
		marked[firstIndex]=true;
	}
	public boolean isPath(Graph G, int index) 
    //--------------------------------------------------------
	 // Summary: Checking connection between two points in the graph.
	 // Precondition: G is an element of Graph class and index is an integer.
	 // Postcondition: Checked connection between two points in the graph.
	 //--------------------------------------------------------
	{
		for (int temp : G.adj(index)) {
			if (!marked[index]) {
				return true;
			}
		}
		return false;
	}
	public void CyclingPath(Graph G, int v)  
	//--------------------------------------------------------
	 // Summary: That method provides to travel in graph to find graph has cycle or not
	 // Precondition: G is an element of Graph class and v is an integer.
	 // Postcondition: That method provided to travel in graph to find graph has cycle or not
	 //--------------------------------------------------------
	{
		for (int w : G.adj(v)) {
			if (marked[w]) {
				if (w != v && w==firstIndex && exp.length()>=5 && !arr.contains(exp) && G.adj[w].size()>1 ) {
					arr.add(exp);
					Collections.sort(arr);
					check=true;
				}
				
			} else {
				marked[w] = true;
			  if(!exp.contains(Character.toString((char)w)) && G.adj[w].size()>1)
				exp += (char)w;
				CyclingPath(G, w);
			}
		}
	}
   public void DirectionofCheckPath() 
 //--------------------------------------------------------
   // Summary: After travelling operation this method checks for any paths.
   // Precondition: varName is a char and varValue is an
   // integer
   // Postcondition: After travelling operation done this method checked for any paths.
   //--------------------------------------------------------
   {
	  if(arr.isEmpty())
		  return;
	   CheckPath(arr);
   }
	public void CheckPath(ArrayList<String> arr) 
	//--------------------------------------------------------
	 // Summary: This method lists the paths according the length of paths.
	 // Precondition: arr is an Array list.
	 // Postcondition: This method listed the paths according the length of paths.
	 //--------------------------------------------------------
	{
		for (int i = 0; i < arr.size(); i++) {
			
			int temp = arr.get(i).length();
			h_size=temp;
			if (h.containsKey(temp)) {
				h.put(arr.get(i).length() + 1, arr.get(i));

			} else {
				h.put(arr.get(i).length(), arr.get(i));
			}
		}
		PrintPath();
	}
	public void PrintPath() 
	//--------------------------------------------------------
	 // Summary: it calls to print methods.
	 // Precondition: -
	 // Postcondition: called the print methods.
	 //--------------------------------------------------------
	{
		for (int i =5; i <= h.get(h_size).length()+h.get(h_size).length(); i++) {
			if (h.containsKey(i)) {
				PrintSortString(h.get(i));
				System.out.println();
			}
		}
	}
	public void PrintSortString(String exp) 
	//--------------------------------------------------------
	 // Summary: it provides to print paths.
	 // Precondition: exp is a string.
	 // Postcondition: it provided to print paths.
	 //--------------------------------------------------------
	{
		char[] arr = exp.toCharArray();
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) {
				System.out.print(arr[i]);
			} else {
				System.out.print(arr[i] + "-");
			}
		}
	}
}
