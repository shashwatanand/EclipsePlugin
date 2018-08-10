package de.shashwat.gef5.eg.model;

import org.eclipse.gef.geometry.planar.Rectangle;

import javafx.scene.paint.Color;

public class SimpleMindMapExampleFactory {
	private static final double WIDTH = 150;

	public SimpleMindMapItem createComplexModel() {
		SimpleMindMapItem simpleMindMapItem = new SimpleMindMapItem();

		MindMapNode centerNode = new MindMapNode();
		centerNode.setTitle("Core Idea");
		centerNode.setDescription("This is Core idea");
		centerNode.setColor(Color.GREENYELLOW);
		centerNode.setBounds(new Rectangle(250, 50, WIDTH, 100));
		
		simpleMindMapItem.addChildElement(centerNode);
		
		MindMapNode childNode;
		for (int index = 0; index < 5; index++) {
			childNode = new MindMapNode();
			childNode.setTitle("Association #" + index);
			childNode.setDescription("I just realized, this is related to the core idea!");
			childNode.setColor(Color.ALICEBLUE);
			
			childNode.setBounds(new Rectangle(50 + (index * 200), 250, WIDTH, 100));
			simpleMindMapItem.addChildElement(childNode);
			
			MindMapConnection conn = new MindMapConnection();
			conn.connect(centerNode, childNode);
			simpleMindMapItem.addChildElement(conn);
		}
		
		MindMapNode child2 = new MindMapNode();
		child2.setTitle("Association #4-2");
		child2.setDescription("I just realized, this is related to the last idea!");
		child2.setColor(Color.LIGHTGRAY);
		child2.setBounds(new Rectangle(250, 550, WIDTH, 100));
		simpleMindMapItem.addChildElement(child2);
		
		MindMapConnection conn = new MindMapConnection();
		conn.connect(centerNode, child2);
		simpleMindMapItem.addChildElement(conn);
		
		return simpleMindMapItem;
	}

	public SimpleMindMapItem createSingleNodeModel() {
		SimpleMindMapItem simpleMindMapItem = new SimpleMindMapItem();

		MindMapNode node = new MindMapNode();
		node.setTitle("Core Idea");
		node.setDescription("This is my Core idea. I need a larger Explanation to it, so I can test the warpping.");
		node.setColor(Color.GREENYELLOW);
		node.setBounds(new Rectangle(20, 50, WIDTH, 100));

		simpleMindMapItem.addChildElement(node);
		return simpleMindMapItem;
	}
}
