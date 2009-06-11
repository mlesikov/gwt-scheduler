// package gwtscheduler.junit.common;
//
// import static junit.framework.Assert.assertEquals;
// import static junit.framework.Assert.assertNotNull;
// import static junit.framework.Assert.assertTrue;
//
// import java.util.Calendar;
// import java.util.Date;
// import java.util.GregorianCalendar;
//
// import org.goda.time.DateTime;
// import org.junit.Before;
// import org.junit.Test;
//
// /**
// * Test case for date operations.
// */
// public class DateOperationsTestCase {
//
// private GregorianCalendar today;
//
// @Before
// public void setUp() {
// today = new GregorianCalendar();
// }
//
// /**
// * Simple test for date creation.
// */
// @Test
// public void testCreateDate() {
// DateTime date = new DateTime();
// assertNotNull(date);
//    
// assertEquals(today.get(Calendar.DAY_OF_MONTH), date.day());
// assertEquals(today.get(Calendar.MONTH), date.month());
// assertEquals(today.get(Calendar.YEAR), date.year());
// }
//
// /**
// * Tests date comparison.
// */
// @Test
// public void testCompareDates() {
// DateTime d1 = new DateTime();
// DateTime d2 = new DateTime();
// d2.
// d2.addDays(1);
// assertTrue("d2 should be bigger", d2.compareTo(d1) > 0);
// }
//
// @Test
// public void testDiffHours1() {
// DateTime d1 = new DateTime();
// DateTime d2 = d1.copy();
// assertEquals("Diff should be 0", 0, d2.diff(d1).hours());
// }
//
// @Test
// public void testDiffHours2() {
// DateTime d1 = new DateTime();
// DateTime d2 = d1.copy().addHours(1);
// assertEquals("Diff should be 1", 1, d2.diff(d1).hours());
// }
//
// @Test
// public void testDiffDays1() {
// DateTime d1 = new DateTime();
// DateTime d2 = d1.copy();
// assertEquals("Diff should be 0", 0, d2.diff(d1).days());
// }
//
// @Test
// public void testDiffDays2() {
// DateTime d1 = new DateTime();
// DateTime d2 = d1.copy().addDays(1);
// assertEquals("Diff should be 1", 1, d2.diff(d1).days());
// }
//  
// @Test
// public void testEndOfMonth(){
// today.set(2009, Calendar.JANUARY, 31);
// Date copy = new Date();
// copy.setTime(today.getTimeInMillis());
//    
// DateTime d1 = new DateTime(copy);
// assertEquals(1, d1.addDays(1).day());
// }
// }
