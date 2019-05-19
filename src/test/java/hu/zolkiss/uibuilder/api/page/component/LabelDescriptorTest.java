package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.zolkiss.uibuilder.api.page.PageRenderer.renderDescriptor;
import static hu.zolkiss.uibuilder.api.test.page.PageRenderTestUtils.TEXT_FIELD_CONTENT;
import static hu.zolkiss.uibuilder.api.test.page.PageRenderTestUtils.assertComponentClass;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Label descriptor test")
class LabelDescriptorTest {

  @Test
  @DisplayName("Simple render with value")
  void simpleRenderWithValue() {
    Component label = renderDescriptor(new LabelDescriptor().setValue(TEXT_FIELD_CONTENT));
    assertComponentClass(label, Label.class);
    assertThat(((Label) label).getText(), equalTo(TEXT_FIELD_CONTENT));
  }

}