package hu.zolkiss.uibuilder.api.page.component;

import hu.zolkiss.uibuilder.api.annotation.PageComponent;

import static hu.zolkiss.uibuilder.api.annotation.PageComponent.Category.CONTAINER;
import static hu.zolkiss.uibuilder.api.page.component.OrderedLayoutDescriptor.OrderedLayoutOrientation.VERTICAL;

@PageComponent(name = "Vertical Layout", category = CONTAINER)
public class VerticalLayoutDescriptor extends OrderedLayoutDescriptor {
  @Override
  public OrderedLayoutOrientation getOrientation() {
    return VERTICAL;
  }
}
