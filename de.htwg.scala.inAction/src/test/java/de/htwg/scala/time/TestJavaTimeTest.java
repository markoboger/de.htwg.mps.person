package de.htwg.scala.time;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestJavaTimeTest {
	
	@Test
	public void testJavaTime() {
		JavaTime jtime;
		jtime = new JavaTime(0, 0);
		assertEquals(0, jtime.getHours());
		assertEquals(0, jtime.getMinutes());
		assertEquals(0, jtime.getAsMinutes());

		jtime = new JavaTime(0, 60);
		assertEquals(1, jtime.getHours());
		assertEquals(0, jtime.getMinutes());

		jtime = new JavaTime(24, 0);
		assertEquals(0, jtime.getHours());
		assertEquals(0, jtime.getMinutes());

		jtime = new JavaTime(8, 40);
		assertEquals(8, jtime.getHours());
		assertEquals(40, jtime.getMinutes());
	}
	
	
	@Test
	public void testGetAsMinutes() {
		assertEquals(0, new JavaTime(0,0).getAsMinutes());
		assertEquals(10, new JavaTime(0,10).getAsMinutes());
		assertEquals(50, new JavaTime(0,50).getAsMinutes());
		assertEquals(60, new JavaTime(1,00).getAsMinutes());
		assertEquals(70, new JavaTime(1,10).getAsMinutes());	
	}

	@Test
	public void testEquals() {
		JavaTime jtime = new JavaTime(8, 40);
		assertEquals(jtime, jtime);

		assertEquals(new JavaTime(0, 0), new JavaTime(0, 0));
		assertEquals(new JavaTime(0, 0), new JavaTime(24, 0));
		assertEquals(new JavaTime(1, 0), new JavaTime(0, 60));
		assertEquals(new JavaTime(8, 40), new JavaTime(8, 40));

		assert (new JavaTime(0, 0) == new JavaTime(0, 0));
		assert (new JavaTime(0, 0) == new JavaTime(24, 0));
		assert (new JavaTime(1, 0) == new JavaTime(0, 60));
		assert (new JavaTime(8, 40) == new JavaTime(8, 40));

		assertNotEquals(new JavaTime(0, 0), null);
		assertNotEquals(new JavaTime(0, 0), "00:00");
		assertNotEquals(new JavaTime(0, 0), new JavaTime(0, 32));
		assertNotEquals(new JavaTime(0, 0), new JavaTime(5, 32));
	}

	@Test
	public void testToString() {
		assertEquals("00:00", new JavaTime(0, 0).toString());
		assertEquals("00:00", new JavaTime(24, 0).toString());
		assertEquals("01:00", new JavaTime(0, 60).toString());
		assertEquals("08:40", new JavaTime(8, 40).toString());
	}

	@Test
	public void testHashCode() {
		assertEquals(new JavaTime(0, 0).hashCode(), new JavaTime(0, 0).hashCode());
		assertEquals(new JavaTime(0, 0).hashCode(), new JavaTime(24, 0).hashCode());
		assertEquals(new JavaTime(1, 0).hashCode(), new JavaTime(0, 60).hashCode());
		assertEquals(new JavaTime(8, 40).hashCode(), new JavaTime(8, 40).hashCode());

		assertNotEquals(new JavaTime(0, 0).hashCode(), new JavaTime(0, 32).hashCode());
		assertNotEquals(new JavaTime(0, 0).hashCode(), new JavaTime(5, 32).hashCode());
	}

	@Test
	public void testPlus() {
		JavaTime jtime1 = new JavaTime(0, 0);
		JavaTime jtime2 = new JavaTime(0, 0);
		jtime1.plus(jtime2);
		assertEquals(new JavaTime(0, 0), jtime1);
		
		jtime1 = new JavaTime(0, 0);
		jtime2 = new JavaTime(1, 0);
		jtime1.plus(jtime2);
		assertEquals(new JavaTime(1, 0), jtime1); 
		
		jtime1 = new JavaTime(0, 0);
		jtime2 = new JavaTime(0, 10);
		jtime1.plus(jtime2);
		assertEquals(new JavaTime(0, 10), jtime1);
		
		jtime1 = new JavaTime(0, 0);
		jtime2 = new JavaTime(0, 60);
		jtime1.plus(jtime2);
		assertEquals(new JavaTime(1, 0), jtime1);
		
		jtime1 = new JavaTime(1, 30);
		jtime2 = new JavaTime(2, 10);
		jtime1.plus(jtime2);
		assertEquals(new JavaTime(3, 40), jtime1);

		jtime1 = new JavaTime(0, 0);
		jtime2 = new JavaTime(0, 70);
		jtime1.plus(jtime2);
		assertEquals(new JavaTime(1, 10), jtime1);
	}
	
	@Test
	public void testMinus() {
		JavaTime jtime1 = new JavaTime(0, 0);
		JavaTime jtime2 = new JavaTime(0, 0);
		jtime1.minus(jtime2);
		assertEquals(new JavaTime(0, 0), jtime1);
		
		jtime1 = new JavaTime(1, 0);
		jtime2 = new JavaTime(0, 10);
		jtime1.minus(jtime2);
		assertEquals(new JavaTime(0, 50), jtime1); 
		
		jtime1 = new JavaTime(0, 0);
		jtime2 = new JavaTime(0, 10);
		jtime1.minus(jtime2);
		assertEquals(new JavaTime(23, 50), jtime1);
		
		jtime1 = new JavaTime(4, 30);
		jtime2 = new JavaTime(2, 10);
		jtime1.minus(jtime2);
		assertEquals(new JavaTime(2, 20), jtime1);
		
		jtime1 = new JavaTime(1, 30);
		jtime2 = new JavaTime(2, 40);
		jtime1.minus(jtime2);
		assertEquals(new JavaTime(22, 50), jtime1);

		jtime1 = new JavaTime(2, 0);
		jtime2 = new JavaTime(0, 70);
		jtime1.minus(jtime2);
		assertEquals(new JavaTime(0, 50), jtime1);
	}


}
