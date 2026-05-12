package bstreeInterface;

import exceptions.*; // Para que reconozca los errores que acabas de hacer

public interface BinarySearchTree<E> {
    void insert(E data) throws ItemDuplicated;
    E search(E data) throws ItemNotFound;
    void delete(E data) throws ExceptionIsEmpty;
    boolean isEmpty();
}