package YAT;

import java.util.Collection;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;

public abstract class AbstractTreeNode<E> implements TreeNode<E> {

    E data;
    TreeNode<E> parent;
    // Collection<TreeNode<E>> children; // Нужно ли ? - тут не нужно

    @Override
    public E getValue() {
        return this.data;
    }

    @Override
    public void setValue(E element) {
        this.data = element;
    }

    @Override
    public TreeNode<E> getParent() {
        return this.parent;
    }

    @Override
    public Collection<TreeNode<E>> getChilds() {
        // Не можем копировать структуру чтобы вернуть здесь
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean isLeaf() {
        // throw new UnsupportedOperationException();
        return getChilds().isEmpty();
    }

    @Override
    public boolean isRoot() {
        if (this.parent == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public TreeNode<E> addChild(E element) {
        // TODO: Не можем здесь создать экземпляр абстрактного класса, чтобы добавить
        throw new UnsupportedOperationException();
    }

    @Override
    public TreeNode<E> addChild(TreeNode<E> node) {
        // Не можем тут добавить в children, так как getChilds() возвращает копию коллекции
        // Сама коллекция детей в конечной реализации
        throw new UnsupportedOperationException();
    }

    @Override
    public TreeNode<E> remove(E element) {
        // Итератор в интерфейсе коллекции есть
        // Не можем тут удалить из children, так как getChilds() возвращает копию коллекции
        throw new UnsupportedOperationException();
    }

    @Override
    public Collection<TreeNode<E>> removeAll(E element) {
        // Не можем копировать структуру чтобы вернуть здесь
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(E element) {
        boolean ans = false;
        for (TreeNode<E> item: getChilds()){
            if (item.getValue() == element) {
                ans = true;
            }
        }
        return ans;
    }

    @Override
    public TreeNode<E> getNodeFor(E element) {
        for (TreeNode<E> item : getChilds()) {
            if (item.getValue() == element) {
                return item;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public Collection<TreeNode<E>> getNodesFor(E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean seach(E element) {
        boolean ans = false;
        if (ans) return true;
        if (getChilds() == null) return false;
        for (TreeNode<E> item : getChilds()) {
            ans = true;
            return item.seach(element);
        }
        return ans;
    }

    @Override
    public TreeNode<E> seachNodeFor(E element) {
        return recursive_search(element, this);
        // throw new UnsupportedOperationException();
    }

    @Override
    public Collection<TreeNode<E>> seachNodesFor(E element) {
        // Этот метод мы не можем тут сделать, так как надо отдавать коллекцию
        // TODO: странно это: реализовывать один поиск тут, а очень похожий поиск всех элементов делать в конечн. реализ.
        // Поэтому в конечном классе реализуем для разнообразия BFS :)
        throw new UnsupportedOperationException();
    }

    protected TreeNode<E> recursive_search(E element, TreeNode<E> node){
        if (node.getValue() == element){
            return node;
        }
        TreeNode<E> res = null;
        for (TreeNode<E> item : node.getChilds()) {
            if (res == null)
                res = recursive_search(element, item);
        }
        return res;
    }

}
