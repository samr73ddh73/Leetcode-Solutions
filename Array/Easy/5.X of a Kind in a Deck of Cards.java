//https://leetcode.com/problems/x-of-a-kind-in-a-deck-of-cards/
import java.util.*;
class Solution {
    public int gcd(int a,int b)
    {
        if(b==0)
            return a;
        return gcd(b,a%b);
    }
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> m=new HashMap<>();
        int min=Integer.MAX_VALUE;
        for(int i=0;i<deck.length;i++)
        {
            if(!m.containsKey(deck[i]))
                m.put(deck[i],1);
            else
                m.put(deck[i],m.get(deck[i])+1);
        }
       List<Integer> l=new ArrayList<>(m.values()); 
        int res=l.get(0);
       for(int i=1;i<l.size();i++)
       {
           res=gcd(res,l.get(i));
       }
            
        if(res==1)
            return false;
        return true;
            
    }
}