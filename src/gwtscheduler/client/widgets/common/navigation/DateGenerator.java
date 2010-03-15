package gwtscheduler.client.widgets.common.navigation;

import gwtscheduler.client.widgets.view.columns.CalendarColumn;
import gwtscheduler.common.calendar.IntervalType;

import org.goda.time.DateTime;
import org.goda.time.Instant;
import org.goda.time.Interval;
import org.goda.time.MutableDateTime;
import org.goda.time.ReadableDateTime;

import java.util.List;

/**
 * Defines event controller operations.
 * @author Miguel Ping
 * @version $Revision: $
 * @since 1.0
 */
public interface DateGenerator {

  /**
   * Initializes the date factory.
   * @param interval the interval type
   * @param start the start date
   */
  void init(IntervalType interval, ReadableDateTime start);

  /**
   * Gets the current date.
   * @return the current date
   */
  DateTime current();

  /**
   * Moves to the specified instant.
   * @param start the start date
   */
  void goToDate(DateTime start);

  /**
   * Gets the next date period.
   * @return the next period
   */
  DateGenerator next();

  /**
   * Gets the previous period.
   * @return the previous period
   */
  DateGenerator previous();

  /**
   * Creates a new time period.
   * @return the time period
   */
  Interval interval();

  Interval currentInterval();

  Instant getInstantForCell(int[] cell, int rowNum);

  Interval getIntervalForRange(int[] start, int[] end, int rowNum);

  Interval getIntervalForDate(DateTime date);

  int getRowForInstant(Instant time, int rowsCount);
}
