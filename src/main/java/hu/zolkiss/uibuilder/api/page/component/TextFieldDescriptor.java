package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.textfield.TextField;
import hu.zolkiss.uibuilder.api.annotation.PageComponent;
import hu.zolkiss.uibuilder.api.page.descriptor.ElementDescriptor;

import static hu.zolkiss.uibuilder.api.annotation.PageComponent.Category.INPUT;

@PageComponent(name = "Text field", category = INPUT)
public class TextFieldDescriptor implements ElementDescriptor<TextField> {
  @Override
  public TextField render() {
    return new TextField();
  }
}
