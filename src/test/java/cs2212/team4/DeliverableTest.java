package cs2212.team4;

import org.junit.Assert;
import org.junit.Test;

public class DeliverableTest 
{
	Deliverable deliver1 = new Deliverable("name1", "type1", 20.0, 10);
	Deliverable deliver2 = new Deliverable("name2", "type2", 40.0, 20);
	Deliverable deliver3 = new Deliverable("name3", "type3", 30.0, 30);
	Deliverable deliver4 = new Deliverable("name4", "type4", 5.0, 40);
	Deliverable deliver5 = new Deliverable("name5", "type5", 5.0, 50);
	
	@Test
	public void testGetName() 
	{
		Assert.assertNotEquals("name", deliver1.getName());
		Assert.assertNotEquals("name", deliver2.getName());
		Assert.assertNotEquals("name", deliver3.getName());
		Assert.assertNotEquals("name", deliver4.getName());
		Assert.assertNotEquals("name", deliver5.getName());
		
		Assert.assertEquals("name1", deliver1.getName());
		Assert.assertEquals("name2", deliver2.getName());
		Assert.assertEquals("name3", deliver3.getName());
		Assert.assertEquals("name4", deliver4.getName());
		Assert.assertEquals("name5", deliver5.getName());
	}

	@Test
	public void testGetType() 
	{
		Assert.assertNotEquals("type", deliver1.getType());
		Assert.assertNotEquals("type", deliver2.getType());
		Assert.assertNotEquals("type", deliver3.getType());
		Assert.assertNotEquals("type", deliver4.getType());
		Assert.assertNotEquals("type", deliver5.getType());
		
		Assert.assertEquals("type1", deliver1.getType());
		Assert.assertEquals("type2", deliver2.getType());
		Assert.assertEquals("type3", deliver3.getType());
		Assert.assertEquals("type4", deliver4.getType());
		Assert.assertEquals("type5", deliver5.getType());
	}

	@Test
	public void testGetWeight() 
	{
		Assert.assertFalse(0==deliver1.getWeight());
		Assert.assertFalse(0==deliver2.getWeight());
		Assert.assertFalse(0==deliver3.getWeight());
		Assert.assertFalse(0==deliver4.getWeight());
		Assert.assertFalse(0==deliver5.getWeight());
		
		Assert.assertTrue(20==deliver1.getWeight());
		Assert.assertTrue(40==deliver2.getWeight());
		Assert.assertTrue(30==deliver3.getWeight());
		Assert.assertTrue(5==deliver4.getWeight());
		Assert.assertTrue(5==deliver5.getWeight());
	}

	@Test
	public void testGetObjId()
	{
		Assert.assertFalse(0==deliver1.getObjId());
		Assert.assertFalse(0==deliver2.getObjId());
		Assert.assertFalse(0==deliver3.getObjId());
		Assert.assertFalse(0==deliver4.getObjId());
		Assert.assertFalse(0==deliver5.getObjId());
		
		Assert.assertTrue(10==deliver1.getObjId());
		Assert.assertTrue(20==deliver2.getObjId());
		Assert.assertTrue(30==deliver3.getObjId());
		Assert.assertTrue(40==deliver4.getObjId());
		Assert.assertTrue(50==deliver5.getObjId());
	}

	@Test
	public void testSetName() 
	{
		deliver1.setName("newName1");
		Assert.assertEquals ("newName1", deliver1.getName());
		Assert.assertNotEquals ("newName", deliver1.getName());
		
		deliver2.setName("newName2");
		Assert.assertEquals ("newName2", deliver2.getName());
		Assert.assertNotEquals ("newName", deliver2.getName());

		deliver3.setName("newName3");
		Assert.assertEquals ("newName3", deliver3.getName());
		Assert.assertNotEquals ("newName", deliver3.getName());
		
		deliver4.setName("newName4");
		Assert.assertEquals ("newName4", deliver4.getName());
		Assert.assertNotEquals ("newName", deliver4.getName());
		
		deliver5.setName("newName5");
		Assert.assertEquals ("newName5", deliver5.getName());
		Assert.assertNotEquals ("newName", deliver5.getName());
	}

	@Test
	public void testSetType() 
	{
		deliver1.setType("newType1");
		Assert.assertEquals ("newType1", deliver1.getType());
		Assert.assertNotEquals ("newType", deliver1.getType());
		
		deliver2.setType("newType2");
		Assert.assertEquals ("newType2", deliver2.getType());
		Assert.assertNotEquals ("newType", deliver2.getType());

		deliver3.setType("newType3");
		Assert.assertEquals ("newType3", deliver3.getType());
		Assert.assertNotEquals ("newType", deliver3.getType());
		
		deliver4.setType("newType4");
		Assert.assertEquals ("newType4", deliver4.getType());
		Assert.assertNotEquals ("newType", deliver4.getType());
		
		deliver5.setType("newType5");
		Assert.assertEquals ("newType5", deliver5.getType());
		Assert.assertNotEquals ("newType", deliver5.getType());
	}

	@Test
	public void testSetWeight()
	{
		deliver1.setWeight(60);
		Assert.assertTrue(60==deliver1.getWeight());
		Assert.assertFalse(0==deliver1.getWeight());
		
		deliver2.setWeight(70);
		Assert.assertTrue(70==deliver2.getWeight());
		Assert.assertFalse(0==deliver2.getWeight());

		deliver3.setWeight(80);
		Assert.assertTrue(80==deliver3.getWeight());
		Assert.assertFalse(0==deliver3.getWeight());
		
		deliver4.setWeight(90);
		Assert.assertTrue(90==deliver4.getWeight());
		Assert.assertFalse(0==deliver4.getWeight());
		
		deliver5.setWeight(100);
		Assert.assertTrue(100==deliver5.getWeight());
		Assert.assertFalse(0==deliver5.getWeight());
	}

	@Test
	public void testEquals() 
	{
		Assert.assertFalse(deliver1.equals(deliver2));
		Assert.assertFalse(deliver2.equals(deliver3));
		Assert.assertFalse(deliver3.equals(deliver4));
		Assert.assertFalse(deliver4.equals(deliver5));
		Assert.assertFalse(deliver5.equals(deliver1));

		Assert.assertTrue(deliver1.equals(deliver1));
		Assert.assertTrue(deliver2.equals(deliver2));
		Assert.assertTrue(deliver3.equals(deliver3));
		Assert.assertTrue(deliver4.equals(deliver4));
		Assert.assertTrue(deliver5.equals(deliver5));
	}

	@Test
	public void testToString() 
	{		 
		Assert.assertTrue("\"name1\", \"type1\", \"20.0\"\n".equals(deliver1.toString()));
		Assert.assertNotEquals("", deliver1.toString());

		Assert.assertEquals("\"name2\", \"type2\", \"40.0\"\n", deliver2.toString());
		Assert.assertNotEquals("", deliver2.toString());
		
		Assert.assertEquals("\"name3\", \"type3\", \"30.0\"\n", deliver3.toString());
		Assert.assertNotEquals("", deliver3.toString());
		
		Assert.assertEquals("\"name4\", \"type4\", \"5.0\"\n", deliver4.toString());
		Assert.assertNotEquals("", deliver4.toString());
		
		Assert.assertEquals("\"name5\", \"type5\", \"5.0\"\n", deliver5.toString());
		Assert.assertNotEquals("", deliver5.toString());
	}

}
