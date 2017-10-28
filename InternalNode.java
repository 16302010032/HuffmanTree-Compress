public class InternalNode extends Node {
 private Node leftchild;
 private Node rightchild;
    InternalNode(Node leftchild,Node rightnode){
       if (leftchild!=null&&rightnode!=null){
           this.leftchild=leftchild;
           this.rightchild=rightnode;
       }else {
           throw new NullPointerException("Child is null");
       }
    }
    public void setLeftchild(Node leftchild) {
        this.leftchild = leftchild;
    }
    public Node getLeftchild() {
        return leftchild;
    }
    public void setRightchild(Node rightchild) {
        this.rightchild = rightchild;
    }
    public Node getRightchild() {
        return rightchild;
    }
}
