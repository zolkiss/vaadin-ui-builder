package hu.zolkiss.uibuilder.api.page.descriptor;

import com.vaadin.flow.component.Component;

import java.util.Collection;
import java.util.List;

public interface ContainerDescriptor<C extends Component> extends ElementDescriptor<C> {
    List<ElementDescriptor> getChildren();

    ContainerDescriptor<C> addChild(ElementDescriptor child);

    ContainerDescriptor<C> addChildren(Collection<ElementDescriptor> children);
}
