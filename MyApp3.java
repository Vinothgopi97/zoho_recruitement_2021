// INCOMPLETE


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node{
	
	public Node(String el){
		element = el;
		children = null;
	}
	
	private String element;
	private List<Node> children;
	
	public String getElement() {
		return element;
	}
	
	public List<Node> getChildren(){
		return children;
	}
	
	public boolean addChild(Node n) {
		if(this.children == null)
			this.children = new ArrayList<>();
		children.add(n);
		return true;
	}
	
	public boolean addAsChild(String parent, String child) {
		if(parent.equals(this.getElement())) {
			addChild(new Node(child));
			return true;
		}
		else {
			for(Node n: getChildren()) {
				return n.addAsChild(parent,child);
			}
		}
		return false;
	}
	
	public void traverseInOrder() {
		System.out.print(this.getElement()+" ");
		List<Node> nodes = this.getChildren();
		if(nodes != null)			
		{
			for(Node node: nodes) {
				node.traverseInOrder();
			}
		}
		return;
			
	}
	
}

public class MyApp3 {
				
	
	static int getChildCount(Node n,String str) {
		if(isNodeExists(n,str)) {
			if(n.getElement().equals(str)) {
				return n.getChildren().size();
			}
			else {
				List<Node> nodes = n.getChildren();
				for(Node n1: nodes) {
					
				}
			}
		}
		return -1;
	}
	
	static boolean isNodeExists(Node n,String str) {
		if(str.equals(n.getElement())) {
			return true;
		}
		else{			
			List<Node> nodes = n.getChildren();	
			if(nodes != null)
				for(Node n1: nodes) {
					return isNodeExists(n1,str);
				}			
		}
		return false;
	}
	
	
	static List<Node> createNodes(String[][] mat){
		List<Node> nodes = new ArrayList<>();
		for(int i=0;i<mat.length;i++) {
			String[] arr = mat[i];
			if(nodes.isEmpty()) {
				Node n = new Node(arr[1]);
				n.addChild(new Node(arr[0]));
				nodes.add(n);
			}
			else {
				boolean found = false;
				for(Node n: nodes) {
					System.out.println(n.getElement()+" "+arr[1]);
					if(isNodeExists(n,arr[1])) {
						
						System.out.println(arr[0]+" is added as child for "+arr[1]+": "+n.addAsChild(arr[1],arr[0]));
						found = true;
						break;
					}else if(isNodeExists(n,arr[0])) {
						//add as parent of n
						Node n1 = new Node(arr[0]);
						System.out.println(n.getElement()+" is added as child for "+n1.getElement()+": "+n1.addChild(n));						
						n = n1;

					}
				}
				if(found == false) {
					Node n = new Node(arr[1]);
					n.addChild(new Node(arr[0]));
					nodes.add(n);
				}
			}
			
		}
		
		return nodes;
	}
	
	public static void main(String[] args) {
		
		String[][] matrix = {{"Surya", "Sivakumar"},
				{"Karthi", "Sivakumar"},
				{"Sivakumar", "Rakkaiya"},
				{"Dev", "Surya"},
				{"Umayaal", "Karthi"},
				{"Diya", "Surya"},
				{"Prabu", "Sivaji"},
				{"Vikram", "Prabu"}
		};
		
		List<Node> nodes = createNodes(matrix);
		
		for(Node n: nodes) {
			System.out.println("-----");
			n.traverseInOrder();
		}
								
		System.out.print(nodes.size());
		
		Scanner scan= new Scanner(System.in);
		String name = scan.next();
		int num = scan.nextInt();
		
		if(num==1) {
			for(Node n: nodes) {
				if(isNodeExists(n,name)) {
					
				}
			}
		}
	}
	
}
