package HashMap;

import java.util.ArrayList;

public class Map<K,V> {
	
	ArrayList<MapNode<K,V>> buckets;
	int count ;
	int numBuckets;
	
	
	 public  Map()
	 {
		 buckets = new ArrayList<>();
		 
		 numBuckets = 20;
		 
		 for(int i=0;i<numBuckets;i++)  //we have inisilised all the 20 element of buckets as null
		 {
			 buckets.add(null);
		 }
	 }
		 
		 //Now we will make a function to insert the element into buckets
		 
		 
		 public void insert(K key,V value)
		 {
			 int bucketIndex = getBucketIndex(key);//this should be return the buckest;
			 
			 MapNode<K, V> head = buckets.get(bucketIndex); //this will return head of list if it is present
			//Check if element is already there ? then just update there value; 
			 while(head != null)
			 {
				 if(head.key.equals(key))
				 {
					 head.value = value;
					 
					 return;
				 }
				 
				 head = head.next;
			 }
			 // if element is not there then make a node and and put as head into arryList
			 head = buckets.get(bucketIndex);
			 
			 MapNode<K,V> newNode = new MapNode<>(key,value);
			 
			 newNode.next = head;
			 
			 buckets.set( bucketIndex,newNode);
			 
			 count++;
			 double loadFactor = 1.0*count/numBuckets;
			 
			 if(loadFactor>0.7)
			 {
				 reHash();
			 }
				 
			 
			 
			 
		 }
	 


	private void reHash() {
		
		ArrayList<MapNode<K,V>> temp = buckets;
		
		buckets = new ArrayList<>();
		
		for(int i=0;i<2*numBuckets;i++)
		{
			buckets.add(null);
		}
		
		count = 0;
		
		numBuckets = 2*numBuckets;
		
		for(int i=0;i<temp.size();i++)
		{
			MapNode<K,V> head = temp.get(i);
			
			while(head != null)
			{
				
				K key = head.key;
				V value = head.value;
				insert(key,value);
				head = head.next;
			}
		}
			
		}

	private int getBucketIndex(K key) {
		
		int  hc = key.hashCode(); //this will return the hash code that are given from the object class
		
		int index = hc%numBuckets;
		
		return index;
	}
	
	
	
	//Now we will make a function to find size of hashMap
	
	public int size()
	{
		return count;
	}
	
	public V getValue(K key)
	{
		
		 int bucketIndex = getBucketIndex(key);//this should be return the buckest;
		 
		 MapNode<K, V> head = buckets.get(bucketIndex); //this will return head of list if it is present
		
		 while(head != null)
		 {
			 if(head.key.equals(key))
			 {
				
				 
				 return head.value;
			 }
			 
			 head = head.next;
		 }
		 
		 return null;
		
	}
	
	public V removeKey(K key)
	{
		int bucketIndex = getBucketIndex(key);
		
		MapNode<K,V> head = buckets.get(bucketIndex);
		
		MapNode<K,V> prev = null;
		
		while(head != null)
		{
			
			if(head.key.equals(key))
			{
				if(prev != null)
				{
				prev.next = head.next;
				}
				else {
					buckets.set(bucketIndex,head.next);
				}
				count--;
				
				return head.value;
				
			}
			
			prev = head;
			head=head.next;
		}
		return null;
		
}
	
	//Now we are going to dovelop a functiomn that will remove the key From hashMap
	
	public 

}
