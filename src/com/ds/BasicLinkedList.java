package com.ds;

public class BasicLinkedList<X> implements LinkedList<X> {
    private Node first;
    private Node last;
    private int nodeCount;

    public BasicLinkedList(){
        first=null;
        last=null;
        nodeCount=0;
    }

    @Override
    public void add(X item){
        //Adding for the first time?
        if(first == null ){
            first = new Node(item);
            last = first;
        }

        else {
            Node newLastNode = new Node(item);
            last.setNextNode( newLastNode );
            last = newLastNode;
        }

        nodeCount++;
    }

    @Override
    public void insert(X item, int position){
        if(size() < position){
            throw new IllegalStateException( "List is shorter than position passed, retry with correct position" );
        }
        // get to the first node
        Node currentNode = first;

        for(int i =0; i< position && currentNode!=null ; i++){
            currentNode = currentNode.getNextNode();
        }

        //current node is at the position , now corrent the links
        Node newNode = new Node(item);
        Node nextNode = currentNode.getNextNode();
        currentNode.setNextNode( newNode );
        newNode.setNextNode( nextNode );
        nodeCount++;

    }


    @Override
    public X remove(){

        //Check if list is empty
        if(first == null){
            throw new IllegalStateException( "No Items in the List" );
        }
        X nodeToRemove = first.getNodeItem();
        // update the first node to be the next node of first
        first = first.getNextNode();
        nodeCount -- ;

        return nodeToRemove;
    }

    @Override
    public String toString(){
        StringBuffer contents = new StringBuffer( );
        Node curNode = first;
        while(curNode!=null){
            contents.append(curNode.getNodeItem() );
            curNode = curNode.getNextNode();

            if(curNode != null){
                contents.append(", " );
            }
        }
        return contents.toString();
    }

    @Override
    public X get(int position){
        if(position > size() || first == null){
            throw new IllegalArgumentException( "Size entered is outside List or list is empty" );
        }

        Node currentNode = first;

        for(int i = 1 ; i < size() && currentNode != null ; i++){
            if(i == position){
                return currentNode.getNodeItem();
            }
            currentNode = currentNode.getNextNode();
        }

       return null;
    }

    @Override
    public int find(X item){
        if(first == null){
            throw new IllegalStateException( "List Empty" );
        }
        Node currentNode = first;

        for(int i=1; i< size() && currentNode != null ; i++){
            if(currentNode.getNodeItem().equals( item )){
                return i;
            }
            currentNode = currentNode.getNextNode();
        }

        return -1;
    }

    @Override
    public X removeAt(int position){
        if(position > size() || first == null){
            throw new IllegalArgumentException( "Size entered is outside List or list is empty" );
        }

        Node currentNode = first;
        Node prevNode = first;

        for(int i = 1 ; i < position && currentNode != null ; i++){
            prevNode = currentNode;
            currentNode = currentNode.getNextNode();
        }

        X nodeItem = currentNode.getNodeItem();
        prevNode.setNextNode( currentNode.getNextNode() );

        nodeCount--;

        return nodeItem;
    }

    @Override
    public int size(){
        return nodeCount;
    }

    private class Node{
        private Node nextNode;
        private X nodeItem;

        public Node( X item){
            this.nextNode=null;
            this.nodeItem=item;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public X getNodeItem() {
            return nodeItem;
        }

        public Node getNextNode() {
            return nextNode;
        }


    }
}
