package edu.cuny.csi.csc330.radio;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RadioTestUnitAdvanced {

private Radio radio; 
	
	@Before
	public void prereq() {
		radio = new Radio();
		System.out.println("In prereq()"); 
	}
	
	
	@After
	public void postreq() {
		radio.off(); 
		System.out.println("In postreq()"); 
	}
	

	@Test
	public void testOnOffOn() {
		radio.on();
		radio.setVolume(20);
		radio.setSelectedStation(92.3);
		assertTrue( radio.isOn() );
		
		radio.off();
		assertTrue( radio.isOn() == false );
		
		radio.on();
		assertTrue( radio.getSelectedStation() == 92.3 );
		assertTrue( radio.getVolume() == 20 );
		
	}

	
	@Test
	public void testSetBass() {
		radio.setSelectedBassLevel(15);
		assertTrue( radio.getSelectedBassLevel() == 15);
	}

	
	/*
	@Test
	public void test() {
		fail("Not yet implemented"); // forces a failure 
	}
	*/

}
