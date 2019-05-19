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
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {PageReflectionHelper.class, PageRenderer.class})
class PageRendererTest {

  @Autowired
  PageRenderer renderer;

  @Test
  @DisplayName("Simple label render")
  void renderLabel() {
    assertComponentClass(renderer.renderDescriptor(new LabelDescriptor()), Label.class);
  }

  @Test
  @DisplayName("Simple text field render")
  void renderTextField() {
    assertComponentClass(renderer.renderDescriptor(new TextFieldDescriptor()), TextField.class);
  }

  @Test
  @DisplayName("Simple horizontal layout render")
  void renderHorizontalLayout() {
    assertComponentClass(renderer.renderDescriptor(new HorizontalLayoutDescriptor()), HorizontalLayout.class);
  }

  @Test
  @DisplayName("Simple vertical render")
  void renderVerticalLayout() {
    assertComponentClass(renderer.renderDescriptor(new VerticalLayoutDescriptor()), VerticalLayout.class);
  }

  @Test
  @DisplayName("Vertical layout with one label and text field (no content)")
  void verticalLayoutWithLabelAndTextField() {
    VerticalLayoutDescriptor vLayoutDescriptor = new VerticalLayoutDescriptor();
    vLayoutDescriptor.addChild(new LabelDescriptor());
    vLayoutDescriptor.addChild(new TextFieldDescriptor());

    Component component = renderer.renderDescriptor(vLayoutDescriptor);
    assertComponentClass(component, VerticalLayout.class);
    List<Component> children = component.getChildren().collect(Collectors.toList());

    assertComponentClass(children.get(0), Label.class);
    assertComponentClass(children.get(1), TextField.class);
  }

  private static void assertComponentClass(Component descriptor, Class<? extends Component> targetComponent) {
    assertThat("The renderer should produce a " + targetComponent.getSimpleName(), descriptor.getClass(), equalTo(targetComponent));
  }
}