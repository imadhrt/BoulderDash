package g58132.atlg3.boulderdash.model;

import java.util.Objects;

public class Element {
    private Element element;

    /**
     * Constructor without parameter of the element which set to null the element
     **/

    public Element() {
        element = null;

    }

    /**
     * Constructor of the element
     *
     * @param element is an element that we will put on the board
     */
    public Element(Element element) {
        this.element = element;
    }

    /**
     * Accessor of element
     * Allows access to the value of the element attribute.
     *
     * @return an element
     */
    public Element getElement() {
        return element;
    }

    /**
     * Mutator of the element
     *
     * @param element is a element
     */
    public void setElement(Element element) {
        this.element = element;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element1 = (Element) o;

        return Objects.equals(element, element1.element);
    }

    @Override
    public int hashCode() {
        return element != null ? element.hashCode() : 0;
    }
}
