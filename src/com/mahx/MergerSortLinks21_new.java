package com.mahx;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;


public class MergerSortLinks21_new {

	static class Node implements Comparable<Node> {
		int i;
		Node next = null;

		@Override
		public int compareTo(Node o) {
			return i = ((Node) o).i;
		}
	}

	static Comparator<Node> comparator = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.i - o2.i;
		}

	};

	public Node[] initNodes() {
		Random random = new Random();
		int linkCount = random.nextInt(32);
		Node[] nodes = new Node[linkCount];
		PriorityQueue<Node> pq = new PriorityQueue<MergerSortLinks21_new.Node>(comparator);
		Node n = null;
		Node tmp = null;
		for (int i = 0; i < linkCount; i++) {
			int length = random.nextInt(32);
			for (int j = 0; j < length; j++) {
				n = new Node();
				n.i = random.nextInt(1000);
				pq.add(n);
			}

			Node header = null;
			while (!pq.isEmpty()) {
				n = pq.poll();
				if (header == null) {
					tmp = n;
					header = n;
				} else {
					tmp.next = n;
					tmp = n;
					tmp.next = null;
				}
			}
			nodes[i] = header;
			printResult(header);
		}

		return nodes;
	}

	public static void main(String[] args) {
		// init order link list
		MergerSortLinks21_new msl = new MergerSortLinks21_new();
		Node[] nodes = msl.initNodes();
		Node result = msl.merge(nodes);
		printResult(result);
	}

	public Node merge(Node[] nodesList) {
		PriorityQueue<Node> pq = new PriorityQueue<MergerSortLinks21_new.Node>(comparator);
		Node ret = null;
		Node tmp = null;
		for (Node n : nodesList) {
			if (n == null) {
				System.out.println("null node and not added");
			} else {
				pq.add(n);
			}
		}
		while (!pq.isEmpty()) {
			if (ret == null) {
				ret = pq.poll();
				tmp = ret;
			} else {
				tmp.next = pq.poll();
				tmp = tmp.next;
			}
			if (tmp.next != null) {
				pq.add(tmp.next);
				tmp.next = null;
			}
		}
		return ret;
	}

	public static void printResult(Node n) {
		if(n == null) {
			System.out.println("null Node");
			return ;
		}
		Node tmp = n;
		StringBuilder sb = new StringBuilder();

		while (tmp != null) {
			sb.append("->" + tmp.i);
			tmp = tmp.next;
		}
		System.out.println(sb.toString());
	}
}
