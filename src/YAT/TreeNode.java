package YAT;

import java.util.Collection;

public interface TreeNode<E> {
    //возвращает хранящееся в узле значение
    E getValue();
    //устанавливает хранящееся в узле значение
    void setValue(E element);
    //возвращает родителя узла
    TreeNode<E> getParent();
    //возвращает всех потомков узла, если их нет то пустая коллекция
    Collection<TreeNode<E>> getChilds();

    //возвращает истину если у узла нет потомков
    boolean isLeaf();
    //возвращает истину если у узла нет родителя
    boolean isRoot();

    //создаёт и добавляет узел с переданым значением
    TreeNode<E> addChild(E element);
    //добавляет узел
    TreeNode<E> addChild(TreeNode<E> node);

    //удаляет первого найденого потомка с таким значением и возвращает его
    TreeNode<E> remove(E element);
    //удаляет все найденые  узлы с таким значением и возвращает их
    Collection<TreeNode<E>> removeAll(E element);

    //проверяет есть ли такое значение среди потомков этого узла
    boolean contains(E element);
    //возвращает первого найденого потомка с таким значением, если не найден то null
    TreeNode<E> getNodeFor(E element);
    //возвращает всех потомков с таким значением, если не найдены то пустая коллекция
    Collection<TreeNode<E>> getNodesFor(E element);

    //проверяет есть ли такое значение среди потомков этого узла и их потомков
    boolean seach(E element);
    //рекурсивно ищет и возвращает первый найденый  узел с таким значением, если не найден то null
    //!рекурсивно это с поиском среди потомков
    TreeNode<E> seachNodeFor(E element);
    //возвращает всё рекурсивно найденые  узлы с таким значением, если не найдены то пустая коллекция
    Collection<TreeNode<E>> seachNodesFor(E element);

}
