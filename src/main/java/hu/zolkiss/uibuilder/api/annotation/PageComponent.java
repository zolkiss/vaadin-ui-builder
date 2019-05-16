package hu.zolkiss.uibuilder.api.annotation;

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface PageComponent {
  enum Category {
    CONTAINER("Containers"),
    TEXT("Text fields"),
    INPUT("Input fields");
    private String visibleName;

    Category(String visibleName) {
      this.visibleName = visibleName;
    }

    public String getVisibleName() {
      return visibleName;
    }
  }

  String name();

  Category category();
}
