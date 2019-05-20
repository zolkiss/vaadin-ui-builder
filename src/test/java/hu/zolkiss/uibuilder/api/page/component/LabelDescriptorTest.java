package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.html.Label;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.zolkiss.uibuilder.api.test.page.PageRenderTestUtils.TEXT_FIELD_CONTENT;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Label descriptor test")
class LabelDescriptorTest {

  @Test
  @DisplayName("Simple render with value")
  void simpleRenderWithValue() {
    Label label = new LabelDescriptor().setValue(TEXT_FIELD_CONTENT).render();
    assertThat(label.getText(), equalTo(TEXT_FIELD_CONTENT));
  }

}