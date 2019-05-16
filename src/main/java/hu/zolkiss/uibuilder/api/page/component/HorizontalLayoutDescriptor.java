package hu.zolkiss.uibuilder.api.page.component;

import hu.zolkiss.uibuilder.api.annotation.PageComponent;

import static hu.zolkiss.uibuilder.api.annotation.PageComponent.Category.CONTAINER;
import static hu.zolkiss.uibuilder.api.page.component.OrderedLayoutDescriptor.OrderedLayoutOrientation.HORIZONTAL;

@PageComponent(name = "Horizontal Layout", category = CONTAINER)
public class HorizontalLayoutDescriptor extends OrderedLayoutDescriptor {
  @Override
  public OrderedLayoutOrientation getOrientation() {
    return HORIZONTAL;
  }
}
