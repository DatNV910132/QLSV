package business_logic;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

class ControllBangdiemTest {

	@Test
	void testDiemchuto4() {
		// assertThrows(IllegalArgumentException.class, () -> ControllBangdiem.Diemchuto4("aaa"));
	    assertEquals(4, ControllBangdiem.Diemchuto4("A+"));
	    assertEquals(4, ControllBangdiem.Diemchuto4("A"));
	    assertEquals(3.5, ControllBangdiem.Diemchuto4("B+"));
	    assertEquals(3, ControllBangdiem.Diemchuto4("B"));
	    assertEquals(2.5, ControllBangdiem.Diemchuto4("C+"));
	    assertEquals(2, ControllBangdiem.Diemchuto4("C"));
	    assertEquals(1.5, ControllBangdiem.Diemchuto4("D+"));
	    assertEquals(1, ControllBangdiem.Diemchuto4("D"));
	    assertEquals(0, ControllBangdiem.Diemchuto4("F"));
	}
	
	@Test
	  void testRound() {
	    assertThrows(IllegalArgumentException.class, () -> ControllBangdiem.lamtron(3f, -2));

	    BigDecimal actualTc1 = ControllBangdiem.lamtron(3.542f, 0);
	    assertEquals("4", actualTc1.toString());

	    BigDecimal actualTc2 = ControllBangdiem.lamtron(3.521f, 2);
	    assertEquals("3.52", actualTc2.toString());

	    BigDecimal actualTc3 = ControllBangdiem.lamtron(3.544f, 3);
	    assertEquals("3.544", actualTc3.toString());

	    BigDecimal actualTc4 = ControllBangdiem.lamtron(3.544f, 4);
	    assertEquals("3.5440", actualTc4.toString());
	  }
	
	@Test
	  void testParseToDiemChu() {
	    assertThrows(IllegalArgumentException.class, () -> ControllBangdiem.SoToDiemChu(-2f));
	    assertEquals("F", ControllBangdiem.SoToDiemChu(0f));
	    assertEquals("F", ControllBangdiem.SoToDiemChu(3.94f));
	    assertEquals("D", ControllBangdiem.SoToDiemChu(4f));
	    assertEquals("D", ControllBangdiem.SoToDiemChu(4.14f));
	    assertEquals("D+", ControllBangdiem.SoToDiemChu(4.96f));
	    assertEquals("D+", ControllBangdiem.SoToDiemChu(5.1f));
	    assertEquals("C", ControllBangdiem.SoToDiemChu(5.55f));
	    assertEquals("C", ControllBangdiem.SoToDiemChu(6f));
	    assertEquals("C+", ControllBangdiem.SoToDiemChu(6.45f));
	    assertEquals("C+", ControllBangdiem.SoToDiemChu(6.7f));
	    assertEquals("B", ControllBangdiem.SoToDiemChu(6.95f));
	    assertEquals("B", ControllBangdiem.SoToDiemChu(7.9f));
	    assertEquals("B+", ControllBangdiem.SoToDiemChu(7.95f));
	    assertEquals("B+", ControllBangdiem.SoToDiemChu(8.41f));
	    assertEquals("A", ControllBangdiem.SoToDiemChu(8.45f));
	    assertEquals("A", ControllBangdiem.SoToDiemChu(9.3f));
	    assertEquals("A+", ControllBangdiem.SoToDiemChu(9.45f));
	    assertEquals("A+", ControllBangdiem.SoToDiemChu(9.85f));
	    assertEquals("A+", ControllBangdiem.SoToDiemChu(10f));
	    assertThrows(IllegalArgumentException.class, () -> ControllBangdiem.SoToDiemChu(11f));
	  }


}
