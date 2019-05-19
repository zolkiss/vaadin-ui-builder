package hu.zolkiss.uibuilder.api.page;

import com.vaadin.flow.component.Component;
import hu.zolkiss.uibuilder.api.page.descriptor.ElementDescriptor;

public class PageRenderer {

  public static Component renderDescriptor(ElementDescriptor descriptor) {
    return descriptor.render();
  }
}
