/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.*;

public class test
{
	public static void main(String[] args)
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try
		{
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse("fortest.xml");

			NodeList dogList = doc.getElementsByTagName("listOfProducts");
			System.out.println("共有" + dogList.getLength() + "个dog节点");
			for (int i = 0; i < dogList.getLength(); i++)
			{
				Node dog = dogList.item(i);
				Element elem = (Element) dog;
				System.out.println("id:" + elem.getAttribute("id"));
				for (Node node = dog.getFirstChild(); node != null; node = node.getNextSibling())
				{
					if (node.getNodeType() == Node.ELEMENT_NODE)
					{
						String name = node.getNodeName();
						String value = node.getFirstChild().getNodeValue();
						System.out.print(name + ":" + value + "\t");
					}
				}
				System.out.println();
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}