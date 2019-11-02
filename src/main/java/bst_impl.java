
 class node{
    int data;
    node left;
    node right;
    node parent;

    public node(){}

    public node(int element){

        this.data=element;
        this.left=null;
        this.right=null;
        this.parent=null;
    }
}

class bst_impl{

    node root=null;
    private node search(node root, int k){

        node res = null;
        if(root==null){
            return res;
        }

        if(root.data==k){
            res=root;
            return res;
        }else if(root.data>k) {
            res = search(root.left, k);
        }else if(root.data<k) {
            res = search(root.right,k);
        }
            return res;


    }

    private node insert(node root, int value, node parent){

        if(root==null){
            node n = new node(value);
            root=n;
            root.parent=parent;
            return root;

        }

        if(root.data>value) {
            root.left = insert(root.left, value, root);
        }else if(root.data<value) {
            root.right = insert(root.right,value, root);
        }
        return root;

    }

    public node predecessor(node root, int key){
        node keynode = search(root,key);
        System.out.println("Search Result "+ keynode.data);
        System.out.println("Search Result Parent "+ keynode.parent.data);

        if(keynode.left!=null){
            node temp=keynode.left;
            while(temp.right!=null)
                temp= temp.right;
            return temp;
        }else{
            node temp = keynode;
            System.out.println("Entered ELSE");
            while(temp.parent!=null){
                temp=temp.parent;
                System.out.println(temp.data);
                if(temp.data<key)
                    return temp;
                }
            return null;
        }
    }

    public void inorder(node root){
        if(root==null){
            return;
        }else{
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }


    public static void main(String[] args){

        bst_impl bst = new bst_impl();
        bst.root = bst.insert(bst.root,8,null);
        //System.out.println(bst.root.data);
        bst.root = bst.insert(bst.root,2,null);
        bst.root = bst.insert(bst.root,4,null);
        bst.root = bst.insert(bst.root,5,null);
        bst.root = bst.insert(bst.root,14,null);
        bst.root = bst.insert(bst.root,9,null);



        if(bst.root==null)
            System.out.println("NULL ROOT");
        bst.inorder(bst.root);

        System.out.println(bst.predecessor(bst.root,5).data);
        System.out.println("Sync TEST");


    }

}