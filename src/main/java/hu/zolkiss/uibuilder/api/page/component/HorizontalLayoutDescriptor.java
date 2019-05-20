package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import hu.zolkiss.uibuilder.api.annotation.PageComponent;

import static hu.zolkiss.uibuilder.api.annotation.PageComponent.Category.CONTAINER;
import static hu.zolkiss.uibuilder.api.page.component.OrderedLayoutDescriptor.OrderedLayoutOrientation.HORIZONTAL;

@PageComponent(name = "Horizontal Layout", category = CONTAINER)
public class HorizontalLayoutDescriptor extends OrderedLayoutDescriptor<HorizontalLayout> {
  @Override
  public OrderedLayoutOrientation getOrientation() {
    return HORIZONTAL;
  }

  @Override
  protected HorizontalLayout getNewInstance() {
    return new HorizontalLayout();
  }
}
