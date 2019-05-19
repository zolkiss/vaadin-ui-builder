package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.textfield.TextField;
import hu.zolkiss.uibuilder.api.annotation.PageComponent;

import static hu.zolkiss.uibuilder.api.annotation.PageComponent.Category.INPUT;
import static java.util.Optional.ofNullable;

@PageComponent(name = "Text field", category = INPUT)
public class TextFieldDescriptor extends SimpleValueDescriptor<TextField, String> {
  @Override
  public TextField render() {
    TextField textField = new TextField();
    ofNullable(getValue()).ifPresent(textField::setValue);
    return textField;
  }
}
