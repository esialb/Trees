import java.util.ArrayList;
import java.util.List;



public class SimplePosition<E> implements Position<E> {

	private E element;
    private Position<E> parent;
    private List<Position<E>> children;
	
    public SimplePosition(E element) {
        this.element = element;
        this.parent = null;
        this.children = new ArrayList<Position<E>>();
    }
      
    
	@Override
	public E getElement() {
		return element;
	}

	@Override
	public void setElement(E element) {
		this.element = element;
	}

	@Override
	public Position<E> getParent() {
		return parent;
	}

	@Override
	public void setParent(Position<E> parent) {
		this.parent = parent;
	}

	@Override
	public List<Position<E>> getChildren() {
		return children;
	}

	@Override
	public void addChild(Position<E> child) {
		// add a downwards pointer
		children.add(child);
		
		// add an upwards pointer
		child.setParent(this);
	}

	@Override
	public void removeChild(Position<E> child) {
		// remove the downwards pointer
		children.remove(child);
		
		// remove the upwards pointer
		child.setParent(null);
		
	}


}
