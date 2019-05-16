package hu.zolkiss.uibuilder.api.page.descriptor;

import java.util.Collection;
import java.util.List;

public interface ContainerDescriptor extends ElementDescriptor {
    List<ElementDescriptor> getChildren();

    void addChild(ElementDescriptor child);

    void addChildren(Collection<ElementDescriptor> children);
}
