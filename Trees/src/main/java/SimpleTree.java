import java.util.List;


public class SimpleTree<E> implements Tree<E>{

	private Position<E> root;  


	public SimpleTree() {
		// let the tree be empty to begin with
		root = null;
	}
	
	@Override
	public int size() {
		if(isEmpty())
		{
			return 0;
		}
		return size(root);
	}
	
	private int size(Position<E> root) {
		
		// for all children
		// get their size
		List<Position<E>> children = root.getChildren();
		
		int count = 1; // initialise to 1, not 0, to count the node itself 
		for(int i = 0; i < children.size(); i++)
		{
			count += size(children.get(i));
		}
		return count;
		
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public Position<E> root() {
		return root;
	}

	@Override
	public Position<E> parent(Position<E> position) {
		return position.getParent();
	}

	@Override
	public List<Position<E>> children(Position<E> position) {
		return position.getChildren();
	}

	@Override
	public int numChildren(Position<E> position) {
		return position.getChildren().size();
	}

	@Override
	public void setRoot(Position<E> root) {
		this.root = root;
		
	}

	@Override
	public void insert(Position<E> parent, Position<E> child) {
		parent.addChild(child);
		child.setParent(parent);
		
	}

	@Override
	public void remove(Position<E> position) {
		if(position == root)
		{
			root = null;
		}
		else
		{
			position.getParent().removeChild(position);
			position.setParent(null);
		}
		
	}

	

}
