package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.textfield.TextField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static hu.zolkiss.uibuilder.api.test.page.PageRenderTestUtils.assertComponentClass;

@DisplayName("Horizontal layout descriptor test")
class HorizontalLayoutDescriptorTest {

  @Test
  @DisplayName("Simple render")
  void simpleRender() {
    assertComponentClass(new HorizontalLayoutDescriptor().render(), HorizontalLayout.class);
  }

  @Test
  @DisplayName("With one label and text field (no content)")
  void withLabelAndTextFieldNoContent() {
    HorizontalLayoutDescriptor hLayoutDescriptor = new HorizontalLayoutDescriptor();
    hLayoutDescriptor.addChild(new LabelDescriptor())
        .addChild(new TextFieldDescriptor());

    HorizontalLayout horizontalLayout = hLayoutDescriptor.render();
    List<Component> children = horizontalLayout.getChildren().collect(Collectors.toList());

    assertComponentClass(children.get(0), Label.class);
    assertComponentClass(children.get(1), TextField.class);
  }

}