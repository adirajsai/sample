package com.custom.linkedlist;

public class CustomLisnkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	
	public void add(T element){
		
		Node<T> nd = new Node<T>();
		nd.setValue(element);
		System.out.println("Adding: "+element);
		/**
		 * check if the list is empty
		 */
		if(head == null){
			//since there is only one element, both head and 
			//tail points to the same object.
			head = nd;
			tail = nd;
		} else {
			//set current tail next link to new node
			tail.setNextRef(nd);
			//set tail as newly created node
			tail = nd;
		}
	}
	
	
public void deleteLast(){
		
		if(tail == null){
			System.out.println("Underflow...");
		}
		Node<T> tmp = tail;
		tail = tmp.getNextRef();
		if(tail == null){
			head = null;
		}
		System.out.println("Deleted: "+tmp.getValue());
	}
	
	
	public void deleteAfter(T after){
		
		Node<T> tmp = head;
		Node<T> refNode = null;
		System.out.println("Traversing to all nodes..");
		/**
		 * Traverse till given element
		 */
		while(true){
			if(tmp == null){
				break;
			}
			if(tmp.compareTo(after) == 0){
				//found the target node, add after this node
				refNode = tmp;
				break;
			}
			tmp = tmp.getNextRef();
		}
		if(refNode != null){
			tmp = refNode.getNextRef();
			refNode.setNextRef(tmp.getNextRef());
			if(refNode.getNextRef() == null){
				tail = refNode;
			}
			System.out.println("Deleted: "+tmp.getValue());
		} else {
			System.out.println("Unable to find the given element...");
		}
	}
	
	
	
	public static void main(String a[]){
		CustomLisnkedList<Integer> sl = new CustomLisnkedList<Integer>();
		sl.add(3);
		sl.add(32);
		sl.add(54);
		sl.add(89);
		
		sl.deleteLast();
		sl.deleteAfter(3);
		
		
	}
}

