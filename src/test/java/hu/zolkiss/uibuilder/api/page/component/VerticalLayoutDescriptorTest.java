package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static hu.zolkiss.uibuilder.api.test.page.PageRenderTestUtils.assertComponentClass;

@DisplayName("Vertical layout render test")
class VerticalLayoutDescriptorTest {

  @Test
  @DisplayName("Simple render")
  void simpleRender() {
    assertComponentClass(new VerticalLayoutDescriptor().render(), VerticalLayout.class);
  }

  @Test
  @DisplayName("With one label and text field (no content)")
  void withLabelAndTextFieldNoContent() {
    VerticalLayoutDescriptor vLayoutDescriptor = new VerticalLayoutDescriptor();
    vLayoutDescriptor.addChild(new LabelDescriptor())
        .addChild(new TextFieldDescriptor());

    VerticalLayout verticalLayout = vLayoutDescriptor.render();
    List<Component> children = verticalLayout.getChildren().collect(Collectors.toList());

    assertComponentClass(children.get(0), Label.class);
    assertComponentClass(children.get(1), TextField.class);
  }

}