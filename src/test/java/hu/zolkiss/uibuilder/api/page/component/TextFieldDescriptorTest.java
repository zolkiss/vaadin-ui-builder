package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.textfield.TextField;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static hu.zolkiss.uibuilder.api.page.PageRenderer.renderDescriptor;
import static hu.zolkiss.uibuilder.api.test.page.PageRenderTestUtils.TEXT_FIELD_CONTENT;
import static hu.zolkiss.uibuilder.api.test.page.PageRenderTestUtils.assertComponentClass;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@DisplayName("Text field render test")
class TextFieldDescriptorTest {

  @Test
  @DisplayName("Simple render with value")
  void simpleRenderWithValue() {
    Component textField = renderDescriptor(new TextFieldDescriptor().setValue(TEXT_FIELD_CONTENT));
    assertComponentClass(textField, TextField.class);
    assertThat(((TextField) textField).getValue(), equalTo(TEXT_FIELD_CONTENT));
  }

}