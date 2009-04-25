package gwtscheduler.client.widgets.view.common;

import gwtscheduler.client.interfaces.events.IWidgetResizeHandler;
import gwtscheduler.client.interfaces.events.WidgetResizeEvent;
import gwtscheduler.client.resources.Resources;
import gwtscheduler.client.resources.css.DayWeekCssResource;
import gwtscheduler.client.utils.Constants;
import gwtscheduler.client.widgets.ViewportPanel;

import com.google.gwt.gen2.table.override.client.FlexTable;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 * Composite view class for days. Has an upper label and a grid.
 */
public abstract class AbstractCompositeDayView extends Composite {
	
	/** static ref to css */
	protected static final DayWeekCssResource CSS = Resources.dayWeekCss();
	/** widget impl */
	protected VerticalPanel impl;
	/** viewport widget */
	private ViewportPanel vmain;

	/**
	 * Default constructor.
	 */
	public AbstractCompositeDayView() {
		impl = new VerticalPanel();

		AbstractDayView dayView = createDayView();

		vmain = new ViewportPanel();
		vmain.add(dayView, dayView.getResizeHandler());

		Widget topView = createTopView(dayView.getColumns());

		impl.add(topView);
		impl.add(vmain);

		initWidget(impl);
		// we'll delegate the resize to the viewport panel
		addHandler(new IWidgetResizeHandler() {
			public void onResize(WidgetResizeEvent event) {
				vmain.doDeferredResize();
			}
		}, WidgetResizeEvent.getType());
	}

	/**
	 * Creates the top view widget.
	 * 
	 * @param columns the number of columns
	 * @return the top view widget
	 */
	protected Widget createTopView(int columns) {
		FlexTable g = new FlexTable();
		g.addStyleName(CSS.genericContainer());
		g.setWidth("100%");
		g.getCellFormatter().setWidth(0, 0, CSS.titleColumnWidthPx() + "px");
		g.getCellFormatter().setWidth(0, columns + 2, Constants.SCROLLBAR_WIDTH + "px");

		for (int i = 0; i < columns; i++) {
			g.setWidget(0, 1 + i, new Label("Day" + i));
			g.getFlexCellFormatter()
					.setHorizontalAlignment(0, 1 + i, HasHorizontalAlignment.ALIGN_CENTER);
		}
		return g;
	}

	/**
	 * Creates the day view widget.
	 * 
	 * @return the day view widget
	 */
	protected abstract AbstractDayView createDayView();
}
