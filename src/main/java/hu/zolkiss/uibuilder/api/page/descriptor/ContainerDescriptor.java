package hu.zolkiss.uibuilder.api.page.descriptor;

import com.vaadin.flow.component.Component;

import java.util.Collection;
import java.util.List;

public interface ContainerDescriptor<C extends Component> extends ElementDescriptor<C> {
    List<ElementDescriptor> getChildren();

    void addChild(ElementDescriptor child);

    void addChildren(Collection<ElementDescriptor> children);
}
