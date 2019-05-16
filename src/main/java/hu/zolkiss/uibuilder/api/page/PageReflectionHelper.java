package hu.zolkiss.uibuilder.api.page;

import hu.zolkiss.uibuilder.api.annotation.PageComponent;
import hu.zolkiss.uibuilder.api.annotation.PageComponent.Category;
import hu.zolkiss.uibuilder.api.page.descriptor.ElementDescriptor;
import hu.zolkiss.uibuilder.api.util.Pair;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.AssignableTypeFilter;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Configuration
public class PageReflectionHelper {

  private Map<Category, List<Pair<PageComponent, Class<ElementDescriptor>>>> pageComponents;

  @PostConstruct
  private void collectPageComponents() {
    ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
    scanner.addIncludeFilter(new AnnotationTypeFilter(PageComponent.class));
    scanner.addIncludeFilter(new AssignableTypeFilter(ElementDescriptor.class));

    pageComponents = scanner.findCandidateComponents("hu.zolkiss").stream()
        .filter(beanDefinition -> Objects.nonNull(beanDefinition.getBeanClassName()))
        .map(PageReflectionHelper::getClassByBeanDefinition)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .map(PageReflectionHelper::getAnnotation)
        .collect(Collectors.groupingBy(pair -> pair.getFirst().category()));
  }

  public Map<Category, List<Pair<PageComponent, Class<ElementDescriptor>>>> getPageComponents() {
    return pageComponents;
  }

  @SuppressWarnings("unchecked")
  private static Optional<Class<ElementDescriptor>> getClassByBeanDefinition(BeanDefinition beanDefinition) {
    try {
      Class<?> aClass = Class.forName(beanDefinition.getBeanClassName());

      return ElementDescriptor.class.isAssignableFrom(aClass) ? Optional.of((Class<ElementDescriptor>) aClass) : Optional.empty();
    } catch (ClassNotFoundException e) {
      return Optional.empty();
    }
  }

  private static Pair<PageComponent, Class<ElementDescriptor>> getAnnotation(Class<ElementDescriptor> clazz) {
    return new Pair<>(clazz.getAnnotation(PageComponent.class), clazz);
  }
}
