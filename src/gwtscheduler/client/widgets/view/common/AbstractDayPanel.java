package gwtscheduler.client.widgets.view.common;

import gwtscheduler.client.interfaces.uievents.IHasResizeHandler;
import gwtscheduler.client.interfaces.uievents.IWidgetResizeHandler;
import gwtscheduler.client.widgets.view.common.grid.HorizontalGridFill;
import gwtscheduler.client.widgets.view.common.grid.HorizontalGridFillResizeHandler;

import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Abstract class for day and week views.
 */
public abstract class AbstractDayPanel extends WrappedWidget implements IHasResizeHandler {

	/** Main container */
	protected VerticalPanel container;
	/** Hours grid */
	protected HorizontalGridFill grid;
	/** Resize handler */
	private IWidgetResizeHandler rh;

	/**
	 * Default constructor.
	 */
	public AbstractDayPanel() {
		container = new VerticalPanel();
		container.setSize("100%", (getRows() * 2) + "em");
		wrapWidget(container);

		grid = new HorizontalGridFill(getRows(), getColumns());
		rh = new HorizontalGridFillResizeHandler(grid);

		container.add(grid);
	}

	/**
	 * Gets the resize handler for this widget.
	 * 
	 * @return the resize handler.
	 */
	public IWidgetResizeHandler getResizeHandler() {
		return rh;
	}

	/**
	 * Gets the number of rows.
	 * 
	 * @return
	 */
	protected abstract int getRows();

	/**
	 * Gets the number of columns
	 * 
	 * @return
	 */
	protected abstract int getColumns();
}