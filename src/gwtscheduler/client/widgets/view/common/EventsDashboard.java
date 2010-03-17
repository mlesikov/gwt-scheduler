package gwtscheduler.client.widgets.view.common;

import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.ui.AbsolutePanel;
import dragndrop.client.core.DragZone;
import gwtscheduler.client.modules.EventBus;
import gwtscheduler.client.widgets.common.navigation.DateGenerator;
import gwtscheduler.client.widgets.view.calendarevent.HasEventResizeEndHandlers;
import gwtscheduler.client.widgets.view.calendarevent.HasEventResizeStartHandlers;
import gwtscheduler.client.widgets.view.common.resize.EventResizeEndHandler;
import gwtscheduler.client.widgets.view.common.resize.EventResizeStartHandler;
import gwtscheduler.client.widgets.view.common.resize.ResizeHelper;
import gwtscheduler.common.event.CalendarEvent;
import gwtscheduler.common.event.Event;
import gwtscheduler.common.event.EventPosition;

import java.util.ArrayList;


/**
 * @author Miroslav Genov (mgenov@gmail.com)
 */
public class EventsDashboard {

  public interface Display {

    AbsolutePanel asWidget();

    int[] getCellPosition(int x, int y);

    int[] calculateLeftTop(int[] cellPos);

    CalendarEvent.Display getCalendarEventDisplay();

    int getCellWidth();

    int getCellHeight();

    int getRowDistance(int start, int end);

    HasEventResizeEndHandlers getHasEventResizeEndHandlers();

    HasEventResizeStartHandlers getHasEventResizeStartHandlers();
  }

  private Display display;
  private DateGenerator dateGenerator;
  private final EventBus eventBus;
  private DragZone dragZone;
  private ResizeHelper resizeHelper;
  private ArrayList<CalendarEvent> events = new ArrayList<CalendarEvent>();

  public EventsDashboard(DateGenerator dateGenerator, EventBus eventBus, DragZone dragZone, ResizeHelper resizeHelper) {
    this.dateGenerator = dateGenerator;
    this.eventBus = eventBus;
    this.dragZone = dragZone;
    this.resizeHelper = resizeHelper;
  }

  public void bindDisplay(final Display display) {
    this.display = display;
    resizeHelper.setDashboardDisplay(display);
  }

  public int[] getCell(int x, int y) {
    return display.getCellPosition(x, y);
  }

  public void addCalendarEvent(int index, Event event) {
    int startRow = dateGenerator.getRowForInstant(event.getInterval().getStart().toInstant(), 48);
    int endRow = dateGenerator.getRowForInstant(event.getInterval().getEnd().toInstant(), 48);
               // TODO: will be refactored!
    int[] startPosition = display.calculateLeftTop(new int[]{startRow, index});
    int height = display.getRowDistance(startRow, endRow);

    CalendarEvent calendarEvent = buildCalendarEvent(event, new EventPosition(startPosition[0], startPosition[1]));
    calendarEvent.setSize(display.getCellWidth(), height);

    events.add(calendarEvent);
    resizeHelper.get(calendarEvent);
//    new CalendarEventResizeHelper(calendarEvent, display, dateGenerator);

    calendarEvent.go(display.asWidget());
  }

  private CalendarEvent buildCalendarEvent(Event event, EventPosition eventPosition) {
    CalendarEvent calendarEvent = new CalendarEvent(event, eventPosition);
    CalendarEvent.Display display = this.display.getCalendarEventDisplay();
    calendarEvent.bindDisplay(display);
    dragZone.add(calendarEvent);
    return calendarEvent;
  }

  public HandlerRegistration addEventResizeEndHandler(EventResizeEndHandler handler) {
    return display.getHasEventResizeEndHandlers().addEventResizeEndHandler(handler);
  }

  public HandlerRegistration addEventResizeStartHandler(EventResizeStartHandler handler) {
    return display.getHasEventResizeStartHandlers().addEventResizeEndHandler(handler);
  }
}
