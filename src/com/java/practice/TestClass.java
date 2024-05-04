package com.java.practice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class TestClass {

	private static Map<Account,String> map = new HashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Account account1 = new Account();
//		account1.setAccountNo(10);
//		account1.setBalance(1000);
//		map.put(account1, "Saurabh");
//		
//		
//		Account account2 = new Account();
//		account2.setAccountNo(12);
//		account2.setBalance(200);
//		map.put(account2, "Ankit");
//		
		String moves = "^^^<<<<vvv>>>>";
		String message = "super dog";
		int K=15;
		int arr[] = {1,2,3,4 };
		
		// Given array
		
		
		System.out.println(solution(arr));
		
		//map.put(null, null)
	}
	
	public static int solution(int[] T) {
        // Implement your solution here
		
		int num = T.length;
	    int currentSum =0;
	    int currentCount=0;
	    int ans=0;

		List<Integer> countList = countLarge(T);
	  
	  
		PriorityQueue<ItemDetails> heap = new PriorityQueue<ItemDetails>(new ItemDetailsComparator());
	  
		for(int i=0;i<num;i++){
			heap.add(new ItemDetails(T[i],i));
		}
	  
		for(int i=0;i<num;i++){
			ItemDetails itemDetails;
			itemDetails = heap.poll();
			ans = ans + num * itemDetails.val -(currentCount * itemDetails.val -currentSum) -countList.get(itemDetails.index);
			currentCount += 1;
			currentSum += itemDetails.val;
		}
	  
	  return ans;
    }
	
	static class ItemDetails {

		int val;
		int index;

		public ItemDetails(int val, int index)
		{
			this.val = val;
			this.index = index;
		}
	}
	
	static class ItemDetailsComparator implements Comparator<ItemDetails>{
		
		public int compare (ItemDetails i1,ItemDetails i2){
			if(i1.val==i2.val){
				return Integer.compare(i1.index,i2.index);
			}
			return Integer.compare(i1.val,i2.val);
		}

	}
	
	public static List<Integer> countLarge(int[] a)
	{
		int len = a.length;

		ItemDetails[] items = new ItemDetails[len];

		for (int i = 0; i < len; i++) {
			items[i] = new ItemDetails(a[i], i);
		}

		int[] count = new int[len];

		customSort(items, 0, len - 1, count);

		ArrayList<Integer> res = new ArrayList<>();

		for (int i : count) {
			res.add(i);
		}

		return res;
	}
	
	public static void customSort(ItemDetails[] items, int low ,int high, int[] count)
	{

			if (low >= high) {
				return;
			}

			int mid = low + (high - low) / 2;

			customSort(items, low, mid, count);
			customSort(items, mid + 1, high, count);

			// merge item details
			mergeItemDetails(items, low, mid, mid + 1, high, count);
	}
	
	public static void mergeItemDetails(ItemDetails[] items, int low, int lEnd, int high, int hEnd, int[] cnt)
	{
			int mid = hEnd - low + 1; 

			ItemDetails[] sorted = new ItemDetails[mid];

			int rightCounter = 0;
			int lowInd = low, highInd = high;
			int index = 0;


			while (lowInd <= lEnd && highInd <= hEnd) {

				if (items[lowInd].val <= items[highInd].val) {
					rightCounter++;
					sorted[index++] = items[highInd++];
				}
				else {
					cnt[items[lowInd].index] += rightCounter;
					sorted[index++] = items[lowInd++];
				}
			}


			while (lowInd <= lEnd) {

				cnt[items[lowInd].index] += rightCounter;
				sorted[index++] = items[lowInd++];
			}


			while (highInd <= hEnd) {

				sorted[index++] = items[highInd++];
			}

			System.arraycopy(sorted, 0, items, low, mid);
	}

	
//	private static void findAccountByAccountId(int accountNo) {
//		
//		 Entry<Account, String> entry = map.entrySet().stream().filter(e -> e.getKey().getAccountNo() == accountNo)
//				.findFirst().get();
//		 
//		 System.out.println("Account no: "+ entry.getKey().getAccountNo() + " Account Balance: " +entry.getKey().getBalance());
//	}
//	
//    public static boolean solution(String moves) {
//        // Implement your solution here
//        
//        // Initial position
//        int x=0;
//        int y=0;
//
//        // Initialize variables to keep track of maximum values of x and y positions
//        int minimX = 0;
//        int minimY = 0;
//        int maximX = 0;
//        int maximY = 0;
//
//        for(char ch : moves.toCharArray()) {
//            if(ch == '^') {
//                y++;
//            }        
//
//            // Update minimum and maximum values of x and y 
//            minimY = Math.min(minimY, y);
//            maximY = Math.max(maximY, y);
//        }
//        
//        y=0;
//        
//        for(char ch : moves.toCharArray()) {
//
//        	if(ch == 'v') {
//               y--;          
//            }
//        
//
//            // Update minimum and maximum values of x and y 
//            minimY = Math.min(minimY, y);
//            maximY = Math.max(maximY, y);
//        }
//        
//        y=0;
//        
//        for(char ch : moves.toCharArray()) {
//
//            if(ch == '>') {
//                x++;
//            }
//                     
//
//            // Update minimum and maximum values of x and y 
//            minimX = Math.min(minimX, x);
//            maximX = Math.max(maximX, x);
//        }
//        
//        x=0;
//        
//        for(char ch : moves.toCharArray()) {
//
//            if(ch == '<') {
//                x--;
//            }
//
//            // Update minimum and maximum values of x and y 
//            minimX = Math.min(minimX, x);
//            maximX = Math.max(maximX, x);
//        }
//        x=0;
//
//        // form a rectangle or not check
//        
//        boolean con1 = (maximX - minimX) + (maximY - minimY) == moves.length();
//        boolean con2 = (maximX == (minimX * -1)) && (maximY == (minimY * -1));
//        return con1 && con2;
//
//    }
//    
//    public static String modifyNotification(String message, int K) {
//        // Implement your solution here
//    	
//    	if (message.length() <= K)
//            return message;
//        
//        String[] words = message.split(" ");
//        String notification = "";
//        int spaceLeft = K - 3;  
//        
//
//                
//        for(String word: words) {
//        	if(word.length() + 1 <= spaceLeft) {
//        		notification += word + " ";
//        		spaceLeft -= word.length() + 1;
//        	}
//        	else {
//        		break;
//        	}
//        }
//        
//        notification = notification.trim(); 
//        notification += " ...";
//        
//        return notification.trim();
//
//    }
    


}
