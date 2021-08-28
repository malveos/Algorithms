/***
93. Restore IP Addresses

Given a string s containing only digits, return all possible valid IP addresses that can be obtained from s. You can return them in any order.

A valid IP address consists of exactly four integers, each integer is between 0 and 255, separated by single dots and cannot have leading zeros. For example, "0.1.2.201" and "192.168.1.1" are valid IP addresses and "0.011.255.245", "192.168.1.312" and "192.168@1.1" are invalid IP addresses. 


***/
import java.util.*;
class Solution {
    List<String> validIPs = new LinkedList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s == null || s.length() == 0) return validIPs;
        prepareValidIPs(s, 0, new ArrayList<>());
        return validIPs;
    }

    // here pi is the index for a part in IP
    private void prepareValidIPs (String s, int pi, List<String> parts) {
        if(0 == s.length() && pi == 4) {
            StringJoiner sj = new StringJoiner(".");
            for (String str : parts) {
                sj.add(str);
            }
            validIPs.add(sj.toString());
        }
        
        if (0 == s.length() && pi < 4) return;
        if (pi < 4 && s.length() / (4 - pi) > 3) return;

        for (int i = 0; i < Math.min(3, s.length()); i++) {
            String part = s.substring(0, i + 1);
            if (part.length() > 1 && part.startsWith("0")) {
                continue;
            }
            
            int value = Integer.parseInt(part);
            if (value <= 255) {
                parts.add(part);
                prepareValidIPs(s.substring(i + 1), pi + 1, parts);
                parts.remove(parts.size() - 1);
            }
        }
    }
}