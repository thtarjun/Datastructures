package com.ds;

import java.util.ArrayList;

public class ListQueue<X> implements Queue<X> {

    private ArrayList<X> data;
    private int front;
    private int end;

    public ListQueue(){
        data = new ArrayList<X>();
        this.front=-1;
        this.end=-1;

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
        if(size() == 0){
            front++;
            end++;
            data.add( end,item );
        }
        //Otherwise add the data at the end of the Queue
        else{
            end++;
            data.add(end,item);
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
            item = data.get(front);
            data.add(front,null);
            front = -1;
            end = -1;
        }

        else {
            item=data.get( front );
            data.add(front,null);
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
            if(data.get(i).equals( item )){
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
                return data.get(i);
            }
            trueIndex++;
        }
        throw new IllegalArgumentException( "Could not retrieve data at position: "+ position );
    }

}
