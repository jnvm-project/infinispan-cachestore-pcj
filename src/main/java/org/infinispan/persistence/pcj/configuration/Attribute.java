package org.infinispan.persistence.pcj.configuration;
import java.util.HashMap;
import java.util.Map;

public enum Attribute {

    // must be first
    UNKNOWN(null);

    // Other enums to be placed here

    private final String name;

    Attribute(final String name) {
        this.name = name;
    }

    /**
     * Get the local name of this element.
     *
     * @return the local name
     */
    public String getLocalName() {
        return name;
    }

    private static final Map<String, Attribute> attributes;

    static {
        final Map<String, Attribute> map = new HashMap<String, Attribute>(64);
        for (Attribute attribute : values()) {
            final String name = attribute.getLocalName();
            if (name != null) {
                map.put(name, attribute);
            }
        }
        attributes = map;
    }

    public static Attribute forName(final String localName) {
        final Attribute attribute = attributes.get(localName);
        return attribute == null ? UNKNOWN : attribute;
    }

}
