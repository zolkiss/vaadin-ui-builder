package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.html.Label;
import hu.zolkiss.uibuilder.api.annotation.PageComponent;

import static hu.zolkiss.uibuilder.api.annotation.PageComponent.Category.TEXT;
import static java.util.Optional.ofNullable;

@PageComponent(name = "Label", category = TEXT)
public class LabelDescriptor extends SimpleValueDescriptor<Label, String> {
  @Override
  public Label render() {
    Label label = new Label();
    ofNullable(getValue()).ifPresent(label::setText);
    return label;
  }
}
