package beingZero.phase_three.others;

import java.util.*;

class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}

class Solution
{
    //Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) 
    {
        double prof = 0.0;
        // Sort descending order based on unit profit
        Arrays.sort(arr, (i1, i2) -> {
            
            double p1 = (double) i1.value/i1.weight;
            double p2 = (double) i2.value/i2.weight;
            
            return (p1>p2) ? -1 : (p1<p2) ? 1 : 0;
            
        });
        
        int i = 0;
        
        while(W>0 && i<n){
            
            int mnQ = Math.min(W, arr[i].weight);
            W = W - mnQ;
            
            prof += mnQ * ((double)(arr[i].value/arr[i].weight));
            
            i++;
            
        }
        
        return prof;
    }
}