import java.util.ArrayList;
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
	
	public String getParent(Position<String> person){
		if(tree.parent(person) == null)
			return null;
		return tree.parent(person).getElement();
	}
	
	public String getGrandparent(Position<String> person){
		if(tree.parent(person) == null || tree.parent(tree.parent(person)) == null)
			return null;
		return tree.parent(tree.parent(person)).getElement();
	}
	
	public List<String> getChildren(Position<String> person){
		List<String> kids = new ArrayList<>();
		for(Position<String> kid : tree.children(person))
			kids.add(kid.getElement());
		return kids;
	}
	
	public List<String> getGrandChildren(Position<String> person){
		List<String> gkids = new ArrayList<>();
		for(Position<String> kid : tree.children(person)) {
			for(Position<String> gkid : tree.children(kid))
				gkids.add(gkid.getElement());
		}
		return gkids;
	}
}
