package gwtscheduler.client.dragndrop;

/**
 * Widgets that implements this interface will be drop zones and only this widgets will accept objects that is dropped.
 * After implementing this interface you can use this code to attach drop handlers to the widget.
 * <pre>
 * public void addDropHandler(DropHandler handler){
 *   addHandler(handler, DropEvent.TYPE);
 * }
 *
 * public void addDragOverHandler(DragOverHandler handler) {
 *   addHandler(handler, DragOverEvent.TYPE);
 * }
 *
 * public void addDragOutHandler(DragOutHandler handler) {
 *   addHandler(handler, DragOutEvent.TYPE);
 * }
 * </pre>
 *
 * @author Lazo Apostolovski (lazo.apostolovski@gmail.com)
 */
public interface DropZone {

  /**
   * Attaches drop handler that will handle dropped object.
   * @param handler drop handler.
   */
  void addDropHandler(DropHandler handler);

  /**
   * Attaches drag over handler. This handler accept event fired when dragged widget enter to the dragged zone.
   * @param handler drag over handler.
   */
  void addDragOverHandler(DragOverHandler handler);

  /**
   * Attaches drag out handler. This handler accept event fired when dragged widget exit from dragged zone.
   * @param handler drag out handler.
   */
  void addDragOutHandler(DragOutHandler handler);

}