import java.util.ArrayList;
import java.util.List;

public class Codetree {
    private InternalNode root;
    private List<List<Integer>> codes;
    Codetree(InternalNode root,int symbolnumber){
                if (root==null){
                    throw new NullPointerException("root is null or code is null");
                }
                this.root=root;
                codes=new ArrayList<List<Integer>>();
                for (int i=0;i<symbolnumber;i++){
                    codes.add(null);
                }
                    buildcodetree(root, new ArrayList<Integer>());  // Fills 'codes' with appropriate data

    }
    public InternalNode getRoot() {
        return root;
    }
    private void buildcodetree(Node node, List<Integer> coding){
          if (node instanceof InternalNode){
              InternalNode internalNode=(InternalNode)node;

              coding.add(0);
              buildcodetree(internalNode.getLeftchild(),coding);
              coding.remove(coding.size()-1);

              coding.add(1);
              buildcodetree(internalNode.getRightchild(),coding);
              coding.remove(coding.size()-1);
          }else if (node instanceof Leaf){
              Leaf leaf=(Leaf)node;
              if (leaf.getCode()>codes.size()){
                  System.out.println(codes.size());
                  throw new IllegalArgumentException("leaf's symbol out of range");
              }
              codes.set(leaf.getCode(),new ArrayList<>(coding));
          }else {
              throw new IllegalArgumentException("node is not illeagal");
          }
    }
    public List<Integer> getCode(int Symbol){
      List<Integer> code=codes.get(Symbol);
        return code;
    }
}
