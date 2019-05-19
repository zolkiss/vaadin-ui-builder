package hu.zolkiss.uibuilder.api.page;

import com.vaadin.flow.component.Component;
import hu.zolkiss.uibuilder.api.page.descriptor.ElementDescriptor;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Component
public class PageRenderer {

  private transient PageReflectionHelper pageReflectionHelper;

  public PageRenderer(@Autowired PageReflectionHelper pageReflectionHelper) {
    this.pageReflectionHelper = pageReflectionHelper;
  }

  public Component renderDescriptor(ElementDescriptor descriptor) {
    return descriptor.render();
  }
}
