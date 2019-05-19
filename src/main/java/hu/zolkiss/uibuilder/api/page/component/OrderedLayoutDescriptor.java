package hu.zolkiss.uibuilder.api.page.component;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasComponents;
import hu.zolkiss.uibuilder.api.page.descriptor.ContainerDescriptor;
import hu.zolkiss.uibuilder.api.page.descriptor.ElementDescriptor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class OrderedLayoutDescriptor<C extends Component & HasComponents> implements ContainerDescriptor<C> {
  public enum OrderedLayoutOrientation {VERTICAL, HORIZONTAL}

  private List<ElementDescriptor> children = new ArrayList<>();

  public List<ElementDescriptor> getChildren() {
    return children;
  }

  public void setChildren(List<ElementDescriptor> children) {
    this.children = children;
  }

  public void addChild(ElementDescriptor child) {
    children.add(child);
  }

  public void addChildren(Collection<ElementDescriptor> children) {
    this.children.addAll(children);
  }

  public abstract OrderedLayoutOrientation getOrientation();

  protected abstract C getNewInstance();

  @Override
  public C render() {
    C newInstance = getNewInstance();
    children.forEach(child -> newInstance.add(child.render()));
    return newInstance;
  }
}
