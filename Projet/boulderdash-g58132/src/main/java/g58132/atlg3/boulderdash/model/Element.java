package g58132.atlg3.boulderdash.model;

public class Element {
    private Element element;

    /**
     * Constructor without parameter of the element which set to null the element
     **/

    public Element() {
        element=null;

    }

    /**
     * Constructor of the element
     * @param element is an element that we will put on the board
     */
    public Element(Element element) {
        this.element = element;
    }

    /**
     * Accessor of element
     *
     * Allows access to the value of the element attribute.
     *
     * @return an element
     */
    public Element getElement() {
        return element;
    }
}
