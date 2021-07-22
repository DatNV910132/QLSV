package data_access;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import value_object.Bangdiem;

class BangdiemTest {

	@Test
	void testgetMalop() {
		Bangdiem bd = new Bangdiem();
		bd.setMaLop("12345678");
		assertTrue(bd.getMaLop().equals("12345678"));
	}
	
	@Test
	void testgetMSSV() {
		Bangdiem bd = new Bangdiem();
		bd.setMSSV("20154484");
		assertTrue(bd.getMSSV().equals("20154484"));
	}

	@Test
	void testgetHocky() {
		Bangdiem bd = new Bangdiem();
		bd.setHocky("20181");
		assertTrue(bd.getHocky().equals("20181"));
	}
	
	@Test
	void testgetDiemCuoiky() {
		Bangdiem bd = new Bangdiem();
		bd.setDiemcuoiky(7.8f);
		assertTrue(bd.getDiemcuoiky() == 7.8f);
	}

	@Test
	void testgetDiemQT() {
		Bangdiem bd = new Bangdiem();
		bd.setDiemQT(7.8f);
		assertTrue(bd.getDiemQT() == 7.8f);
	}
	
	@Test
	void testgetDiemheso4() {
		Bangdiem bd = new Bangdiem();
		bd.setDiemheso4("A");
		assertTrue(bd.getDiemheso4().equals("A"));
	}
	

	@Test
	void testtoString() {
		Bangdiem bd = new Bangdiem();
		bd.setDiemheso4("A");
		bd.setMaLop("12345678");
		bd.setDiemQT(7.8f);
		bd.setHocky("20181");
		bd.setMSSV("20154484");
		bd.setDiemcuoiky(7.8f);
		assertTrue(bd.getDiemcuoiky() == 7.8f);
		assertTrue(bd.getMSSV().equals("20154484"));
		assertTrue(bd.getHocky().equals("20181"));
		assertTrue(bd.getDiemQT() == 7.8f);
		assertTrue(bd.getMaLop().equals("12345678"));
		assertTrue(bd.getDiemheso4().equals("A"));
	}
}
