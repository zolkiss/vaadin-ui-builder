package hu.zolkiss.uibuilder.api.page;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import hu.zolkiss.uibuilder.api.page.component.HorizontalLayoutDescriptor;
import hu.zolkiss.uibuilder.api.page.component.LabelDescriptor;
import hu.zolkiss.uibuilder.api.page.component.TextFieldDescriptor;
import hu.zolkiss.uibuilder.api.page.component.VerticalLayoutDescriptor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static hu.zolkiss.uibuilder.api.page.PageRenderer.renderDescriptor;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class PageRendererTest {

  private static final String TEXT_FIELD_CONTENT = "TEXT_LABEL_01";

  @Test
  @DisplayName("Label render")
  void renderLabel() {
    Component label = renderDescriptor(new LabelDescriptor().setValue(TEXT_FIELD_CONTENT));
    assertComponentClass(label, Label.class);
    assertThat(((Label) label).getText(), equalTo(TEXT_FIELD_CONTENT));
  }

  @Test
  @DisplayName("Text field render")
  void renderTextField() {
    Component textField = renderDescriptor(new TextFieldDescriptor().setValue(TEXT_FIELD_CONTENT));
    assertComponentClass(textField, TextField.class);
    assertThat(((TextField) textField).getValue(), equalTo(TEXT_FIELD_CONTENT));
  }

  @Test
  @DisplayName("Simple horizontal layout render")
  void renderHorizontalLayout() {
    assertComponentClass(renderDescriptor(new HorizontalLayoutDescriptor()), HorizontalLayout.class);
  }

  @Test
  @DisplayName("Simple vertical render")
  void renderVerticalLayout() {
    assertComponentClass(renderDescriptor(new VerticalLayoutDescriptor()), VerticalLayout.class);
  }

  @Test
  @DisplayName("Vertical layout with one label and text field (no content)")
  void verticalLayoutWithLabelAndTextField() {
    VerticalLayoutDescriptor vLayoutDescriptor = new VerticalLayoutDescriptor();
    vLayoutDescriptor.addChild(new LabelDescriptor());
    vLayoutDescriptor.addChild(new TextFieldDescriptor());

    Component component = renderDescriptor(vLayoutDescriptor);
    assertComponentClass(component, VerticalLayout.class);
    List<Component> children = component.getChildren().collect(Collectors.toList());

    assertComponentClass(children.get(0), Label.class);
    assertComponentClass(children.get(1), TextField.class);
  }

  private static void assertComponentClass(Component descriptor, Class<? extends Component> targetComponent) {
    assertThat("The renderer should produce a " + targetComponent.getSimpleName(), descriptor.getClass(), equalTo(targetComponent));
  }
}