import java.util.List;

public class Container<TElement extends IAggregable<TElement, TAggregateResult> & IDeeplyCloneable<TElement>, TAggregateResult>
        implements IContainer<TElement, TAggregateResult> {

    private List<TElement> elements;

    Container(List<TElement> elements) {
        this.elements = elements;
    }

    @Override
    public List<TElement> elements() {
        return elements;
    }

    @Override
    public TAggregateResult aggregateAllElements() {
        TAggregateResult iResult = null;
        for (TElement element : elements) {
            iResult = element.aggregate(iResult);
        }
        return iResult;
    }

    @Override
    public TElement cloneElementAtIndex(int index) {
        return elements.get(index).deepClone();
    }

    @Override
    public TElement get(int index) {
        return elements.get(index);
    }
}
