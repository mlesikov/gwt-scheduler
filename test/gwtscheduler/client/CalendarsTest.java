package gwtscheduler.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;
import com.google.gwt.junit.client.GWTTestCase;
import gwtscheduler.client.modules.AppModule;
import gwtscheduler.client.modules.UIModule;
import gwtscheduler.client.widgets.view.MultiColumnPresenter;
import gwtscheduler.client.widgets.view.common.AbstractCalendarPresenter;
import gwtscheduler.client.widgets.view.dayweek.AbstractDaysView;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author mlesikov  {mlesikov@gmail.com}
 */
public class CalendarsTest extends GWTTestCase {
  private Calendars calendars;

  /**
   * Specifies a module to use when running this test case. Subclasses must
   * return the name of a module that will cause the source for that subclass to
   * be included.
   *
   * @return the fully qualified name of a module, or <code>null</code> to run
   *         as a non-GWT test case
   */
  @Override
  public String getModuleName() {
    return "com.evo.adm.contract.contract";
  }

  @GinModules( {UIModule.class, AppModule.class})
  interface CalendarsGinjector extends Ginjector {
    Calendars getCalendars();

  }

  private CalendarsGinjector ginjector;


  /**
   * A replacement for JUnit's {@link #setUp()} method. This method runs once
   * per test method in your subclass, just before your each test method runs
   * and can be used to perform initialization. Override this method instead of
   * {@link #setUp()}.
   */
  @Override
  protected void gwtSetUp() throws Exception {
    super.gwtSetUp();
    ginjector = GWT.create(CalendarsGinjector.class);
  }


  @Test
  public void testNewMultiColumn(){
    calendars = ginjector.getCalendars();
    AbstractCalendarPresenter<AbstractDaysView> presenter = calendars.newMultiColumn(null).build();
    assertTrue(presenter instanceof MultiColumnPresenter);
  }
  
}
