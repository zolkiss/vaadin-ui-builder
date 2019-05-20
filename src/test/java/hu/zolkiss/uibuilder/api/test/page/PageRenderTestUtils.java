package hu.zolkiss.uibuilder.api.test.page;

import com.vaadin.flow.component.Component;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PageRenderTestUtils {

  public static final String TEXT_FIELD_CONTENT = "TEXT_LABEL_01";

  public static void assertComponentClass(Component descriptor, Class<? extends Component> targetComponent) {
    assertThat("The renderer should produce a " + targetComponent.getSimpleName(), descriptor.getClass(), equalTo(targetComponent));
  }
}