package com.solvd.laba.Utils;

public class LinkedListNotepad<T> {

	private Node<T> head;
	
	public static class Node<T>{
		Node<T> next;
		T value;
		
		Node(T value) {
			this.value = value;
			next = null;
		}
	}
	
	public void add(T data) {
		Node<T> newNode = new Node<T>(data); 
		
		if (head == null) {
			head = newNode;
		} else {
			Node<T> last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = newNode;
		}
	}
	
	public void add(int index, T data) {
		Node<T> newNode = new Node<T>(data); 
		Node<T> node = head;
		for(int i = 0; i < index -1; i++) {
			node = node.next;
		}
		newNode.next = node.next;
		node.next = newNode;
	}
	
	public void remove(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node<T> node = head;
			for(int i = 0; i < index -1; i++) {
				node = node.next;
			}
			node.next = node.next.next;
		}

	}
	
	public void displayList() {
		if (head!=null) {
			Node<T> node = head; 
			while(node.next != null) {	
				System.out.println("| "+ node.value + " |");
				node = node.next;
			}
			System.out.println("| "+ node.value + " |");
		}
	}
}
