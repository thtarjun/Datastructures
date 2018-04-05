package com.ds;

public class BasicQueue <X> implements Queue<X> {

    private X[] data;
    private int front;
    private int end;

    public BasicQueue(){
        this(1000);
    }
    public BasicQueue(int size){
        this.front=-1;
        this.end=-1;
        data = (X[]) new Object[size];
    }

    @Override
    public int size(){
        if(front == -1 && end == -1 ) {
            return 0;
        }
        return end-front+1;
    }

    @Override
    public void enQueue(X item){
        // First check if Queue is full
        if((end+1) % data.length == front){
            throw new IllegalStateException( "Queue is Full" );
        }
        // Otherwise check to see if any item has been added to the Queue yet
        else if(size() == 0){
            front++;
            end++;
            data[end]=item;
        }
        //Otherwise add the data at the end of the Queue
        else{
            end++;
            data[end]=item;
        }
    }

    @Override
    public X deQueue(){
        X item = null;
        // If Queue is empty we cant DeQueue
        if(size() == 0){
            throw new IllegalStateException("No item in the Queue");
        }

        //Check if this is the last item
        else if(front == end){
            item = data[front];
            data[front]=null;
            front = -1;
            end = -1;
        }

        else {
            item=data[front];
            data[front]=null;
            front++;
        }
        return item;

    }

    @Override
    public boolean contains(X item){
        boolean found = false;
        //If Queue is empty return false

        if(size() == 0){
            return found;
        }

        for (int i=front; i<end ; i++){
            if(data[i].equals( item )){
                found = true;
                break;
            }
        }
        return found;
    }

    @Override
    public X access(int position){

        if( size() == 0 || position > size()) {
            throw new IllegalArgumentException( "Bad position given, or position outside queue" );
        }

        int trueIndex = 0;
        for(int i = front; i < end; i++){
            if(trueIndex == position){
                return data[i];
            }
            trueIndex++;
        }
        throw new IllegalArgumentException( "Could not retrieve data at position: "+ position );
    }

}
