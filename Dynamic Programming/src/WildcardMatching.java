
public class WildcardMatching {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		System.out.println(isMatch("","*a"));
		System.out.println(isMatch("aab","***b"));
		//System.out.println(isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaa", "b*b*ab**ba*b**b***a"));
		//System.out.println(isMatch("bbbbbbbabbaabbabbbbaaabbabbabaaabbababbbabbbabaaabaab", "b*b*ab**ba*b**b***bba"));
		System.out.println(isMatch("aa", "*"));
		System.out.println(isMatch("aa", "a*"));
		System.out.println(isMatch("ab", "?*"));
		System.out.println(isMatch("aab", "c*a*b"));
	}
	public static boolean isMatch(String s, String p) {
        /**
         * solution 1:
         */
		if (s == null || p == null)
            return true;
        if (p.replace("*", "").length() > s.length()) //pass TLE
            return false;  

        int row = s.length();
        int col = p.length();
        //match[i][j] use to store the result of isMatch(previous i in s, previous j in p), eg. match(1,2) means
        //the result isMatch(s.substring(0,1), p.substring(0,2)), check whether the 1st char in s matches
        //the 2 characters in p
        boolean[][] match = new boolean[row+1][col+1];
        match[0][0] = true;
        for (int i = 1; i <= col && p.charAt(i-1) == '*'; i++){
            match[0][i] = true;
        }

        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
            	//if i-1 char in s matches with j-1 char in p or i char in s matches with j char in p or i char in s
            	//matches with j-1 char in p, then the first ith char in s should all matches with jth char in p
                if (p.charAt(j-1) == '*'){
                    match[i][j] = match[i-1][j-1] || match[i-1][j] || match[i][j-1];
                }
                //if the jth char in p is ? and previous i-1 in s matches with j-1 in p, then match[i][j] should be true
                else if (p.charAt(j-1) == '?'){
                    match[i][j] = match[i-1][j-1];
                }
                //if the jth char in p is not ? or *, then previous i-1 in s should match with j-1 in p, and s.charAt(i-1) == p.charAt(j-1)
                else{
                    match[i][j] = match[i-1][j-1] && s.charAt(i-1) == p.charAt(j-1);
                }
            }
        }    

        return match[row][col];
		
		/**
         * solution 2:
         */
		/*
		int m = s.length(), n = p.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (p.charAt(i) == '*') count++;
        }
        if (count==0 && m != n) return false;
        else if (n - count > m) return false;
        //initialize the boolean array
        boolean[] match = new boolean[m+1];
        match[0] = true;
        for (int i = 0; i < m; i++) {
            match[i+1] = false;
        }
        
        for (int i = 0; i < n; i++) {
        	//as long as the next char is * and previous match is true, the next match should be true
            if (p.charAt(i) == '*') {
                for (int j = 0; j < m; j++) {
                    match[j+1] = match[j] || match[j+1]; 
                }
            } else {
                for (int j = m-1; j >= 0; j--) {
                    match[j+1] = (p.charAt(i) == '?' || p.charAt(i) == s.charAt(j)) && match[j];
                }
                match[0] = false;
            }
        }
        return match[m];*/
		
		/**
		 * solution 3: LTE error
		 */

	
		/*
		if(p.length() == 0) return s.length() == 0;
        if(p.length() == 1){
        	if(p.charAt(0) == '*') return true;
        	else if(p.charAt(0) == '?') return s.length() == 1;
        	else return s.length() == 1 && s.charAt(0) == p.charAt(0);
        }
        else if(p.length() > 1){
        	//if s is "" and p is "****a"
        	if(s.isEmpty()){
        		for(int i = 0; i < p.length(); i++){
        			if(p.charAt(i) != '*')
        				return false;
        		}
        	}
        	if(s.charAt(0) != p.charAt(0) && p.charAt(0) != '?' && p.charAt(0) != '*') return false;
        	while(!s.isEmpty() && !p.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '?' || p.charAt(0) == '*')){
        		if(isMatch(s,p.substring(1)))
        			return true;
        		if(p.charAt(0) == '*'){
        			s = s.substring(1);
        			//continuously remove redundant *
        			while(p.length() > 1 && p.charAt(1) == '*')
        				p = p.substring(1);
        		}
        		else{
        			s = s.substring(1);
        			p = p.substring(1);
        		}
        	}
        }
        return isMatch(s,p);
        */
    }

}
