package hu.zolkiss.uibuilder.api.page.descriptor;

import com.vaadin.flow.component.Component;

public interface ElementDescriptor<C extends Component> {
  C render();
}
