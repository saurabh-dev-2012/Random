package com.java.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArrayPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] cpdomains =
			{"9001 discuss.leetcode.com"};
		System.out.println(subdomainVisits(cpdomains));
	}
	
   private static List<String> subdomainVisits(String[] cpdomains) {

        Map<String, Long> domainVisits = new HashMap<>();
        List<String> allDomainVisits = new ArrayList<>();

        for(String cpDomain: cpdomains) {
            String[] domains = cpDomain.split(" ")[1].split("\\.");
            String fullDomain = cpDomain.split(" ")[1];
            int overallCount = Integer.valueOf(cpDomain.split(" ")[0]);

            if(domains.length == 2) {
                // parent domain value set
                domainVisits.put(domains[1], domainVisits.getOrDefault(domains[1], 0L) + overallCount);
                // full domain value set
                domainVisits.put(fullDomain, domainVisits.getOrDefault(fullDomain, 0L) + overallCount);
            }

            if(domains.length == 3) {
                // parent domain value set
                domainVisits.put(domains[2], domainVisits.getOrDefault(domains[2], 0L) + overallCount);
                // second level domain value set
                domainVisits.put(domains[1]+domains[2], domainVisits.getOrDefault(domains[1]+domains[2], 0L) + overallCount);
                
                // full domain value set
                domainVisits.put(fullDomain, domainVisits.getOrDefault(fullDomain, 0L) + overallCount);
            }
            
        }

        // return all domains visits
        for(String domain : domainVisits.keySet()) {
            String domainDetail = "" + domainVisits.get(domain) + " " + domain;
            allDomainVisits.add(domainDetail);
        } 

        return allDomainVisits;
        
    }

}
