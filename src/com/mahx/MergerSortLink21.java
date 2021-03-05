package com.mahx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class MergerSortLink21 {

	public static void main(String[] args) {

		Random random = new Random();
		int linkCount = random.nextInt(32);
		Node[] nodes = new Node[linkCount];
		MergerSortLink21 msl = new MergerSortLink21();
		for (int i = 0; i < linkCount; i++) {
			int length = random.nextInt(32);
			Node n = null;
			Node[] initList = new Node[length];

			for (int j = 0; j < length; j++) {
				n = new Node();
				n.i = random.nextInt(1000);
				initList[j] = n;

			}
			nodes[i] = msl.getSortedList(initList);
		}

		Node result = msl.merged(nodes);
		msl.printResult(result);

	}

	Comparator<Node> comparator = new Comparator<Node>() {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.i - o2.i;
		}

	};

	static class Node implements Comparable<Node> {
		int i;
		Node next = null;

		@Override
		public int compareTo(Node o) {
			return i = ((Node) o).i;
		}
	}

	public Node merged(Node[] nodes) {
		Node ret = null;
		if (nodes == null || nodes.length == 0) {
			return ret;
		}
		ArrayList<Node> tmp = new ArrayList<Node>();
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i] != null) {
				tmp.add(nodes[i]);
			}
		}
		Node lastTmp = null;
		while (!tmp.isEmpty()) {
			Collections.sort(tmp, comparator);
			Node node = tmp.remove(0);
			if (node.next != null) {
				tmp.add(node.next);
			}
			if (ret == null) {
				ret = node;
				lastTmp = node;
			} else {
				lastTmp.next = node;
				lastTmp = node;
			}
			lastTmp.next = null;
		}

		return ret;
	}

	public Node getSortedList(Node[] nodes) {
		if (nodes == null || nodes.length == 0)
			return null;
		List<Node> tmp = Arrays.asList(nodes);
		Collections.sort(tmp, comparator);
		for (int i = 0; i < tmp.size(); i++) {
			if (i + 1 != tmp.size()) {
				tmp.get(i).next = tmp.get(i + 1);
			}
		}
		return tmp.get(0);
	}

	public void printResult(Node n) {
		Node tmp = n;
		StringBuilder sb = new StringBuilder();

		while (tmp != null) {
			sb.append("->" + tmp.i);
			tmp = tmp.next;
		}
		System.out.println(sb.toString());
	}
}
