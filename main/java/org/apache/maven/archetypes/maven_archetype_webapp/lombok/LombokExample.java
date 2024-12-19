package org.apache.maven.archetypes.maven_archetype_webapp.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class LombokExample {
    private String exampleField1;
    private int exampleField2;
}
