import java.util.List;
public class FamilyTree {
	
	Tree<String> tree = new SimpleTree<String>();
	Position<String> bob = new SimplePosition<String>("Bob");
	Position<String> jane = new SimplePosition<String>("Jane");
	Position<String> tim = new SimplePosition<String>("tim");
	Position<String> kate = new SimplePosition<String>("kate");
	
	public FamilyTree(Tree<String> tree){
		tree.setRoot(bob);
		tree.insert(bob, jane);
		tree.insert(bob, tim);
		tree.insert(tim, kate);
		
		FamilyTree family = new FamilyTree(tree);
		
	}
	
	public String getParent(position<string> person){
		
	}
	
	public String getGrandparent(Position<String> person){
		
		
	}
	
	public List<String> getChildren(Position<String> person){
		
	}
	
	public List<String> getGrandChildren(Position<String> person){
		
	}
}
