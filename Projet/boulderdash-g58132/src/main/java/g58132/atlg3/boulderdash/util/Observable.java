package g58132.atlg3.boulderdash.util;

public interface Observable {
    /**
     * Adds an observer to the list of observers.
     * @param observer The observer to be added.
     */
    void addObserver(Observer observer);

    /**
     * Removes the observer from the list.
     * @param observer The  observer to be removed.
     */
    void removeObserver(Observer observer);

}
