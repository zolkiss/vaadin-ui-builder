package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.Component;
import hu.zolkiss.uibuilder.api.page.descriptor.ElementDescriptor;

import java.io.Serializable;

public abstract class SimpleValueDescriptor<C extends Component, V extends Serializable> implements ElementDescriptor<C> {
  private V value;

  public V getValue() {
    return value;
  }

  public SimpleValueDescriptor<C, V> setValue(V value) {
    this.value = value;
    return this;
  }
}
