Write a code that would look for a football club name (as an input parameter) on the first ten pages of  Wikipedia API (https://en.wikipedia.org/w/api.php). For each page try to find one result that would display information about a given club. Return the URL to this wiki page. 
Sample API query: https://en.wikipedia.org/w/api.phpaction=query&list=search&format=json&srsearch=%22Liverpool%22&srlimit=10
Input: Liverpool
Output: https://en.wikipedia.org/wiki/Liverpool_F.C