package struct;

public class LinkedList {
	
	class Node {
		String data;
	}
	
	class CLType {
		Node node = new Node();
		CLType nextNode;
		CLType head = new CLType();
		
		public CLType() {
			// TODO Auto-generated constructor stub
			head.node = node;
		}
	
		/**加到结尾*/
		CLType append(Node node) {
			CLType curr = new CLType();
			curr.node = node;
			curr.nextNode = null;
			CLType temp = head;
			while(temp.nextNode != null) {
				temp = temp.nextNode;
			}
			temp.nextNode = curr;
			
			return curr;
		}
		
		CLType push(Node node){
			CLType curr = new CLType();
			curr.nextNode = head;
			curr.node = node;
			return curr;
		}
	}
	
	
}
