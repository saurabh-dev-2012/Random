package com.java.practice;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author saurabh
 *
 * Log file: 
 * customerid,
 * pageId
 * timestamp
 * 
 * 
 *
 */
public class LogFileMap {

	
	Map<String, Data> map;
	Map<Integer, String> pageMap;
	
	public LogFileMap() {
		map = new HashMap<>();
		pageMap = new HashMap<>();
	}
	
	
	public List<String> getCustomersMultiplePages(Map<String, Data> map) {
		
		List<String> customers = new ArrayList<>();
		for(String customer : map.keySet()) {
			Data customerData = map.get(customer);
			if(pageMap.containsKey(customerData.pageId)) {
				if(pageMap.get(customerData.pageId).equals(customer)) {
					
					customers.add(customer);
				}
			}
			pageMap.put(customerData.pageId, customer);
			
		}
		return customers;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class Data {
	int pageId;
	Date timestamp;
	
	public Data(int pageId, Date timestamp) {
		this.pageId = pageId;
		this.timestamp = timestamp;
	}
	
	public boolean isWithinTwoDays(Date timestamp) {
		
		return this.timestamp.before(timestamp) && this.timestamp.getDay() - timestamp.getDay() >= 2;
	}
	
//	public isDifferentPage()
}
