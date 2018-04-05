package com.ds;

public class BasicStack<X> implements Stack<X> {

    private X [] data;
    private int stackPointer;

    public BasicStack() {

        data = (X[]) new Object[1000];
        stackPointer=0;
    }

    @Override
    public void push(X newItem) {
        data[stackPointer++]=newItem;
    }

    @Override
    public X pop(){
        if(stackPointer == 0){
            throw new IllegalStateException( "No items in the Stack!!" );
        }
        return data[--stackPointer];
    }

    @Override
    public boolean contains(X item) {
        boolean found = false;
        for(int i =0; i<stackPointer ; i++){
            if(data[i].equals( item )){
                found = true;
                break;
            }
        }

        return found;
    }

    @Override
    public X access(X item){
        while(stackPointer>0){
            X tmpItem = pop();
            if(item.equals( tmpItem )){
                return tmpItem;
            }
        }
        // Throw exception if not found
        throw new IllegalArgumentException( "Could not find the item in the stack : " + item );
    }

    @Override
    public int size(){
        return stackPointer;
    }
}
