/**

204. Count Primes

Given an integer n, return the number of prime numbers that are strictly less than n.

**/
class Solution {
    public int countPrimes(int n) {
        // start from 2 and then mark all prime and non prime
        if (n < 3) return 0;
        boolean [] visited = new boolean[n + 1];
        List<Integer> primes = new ArrayList<>();
        primes.add(2);
        Arrays.fill(visited, false);

        for (int i = 2; i <n; i+=2)
            visited[i] = true;

        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (!visited[i]) {
                for (int j = 2 * i; j <= n; j += i) {
                    visited[j] = true;
                }
            }
        }
        for (int i = 2; i < n; i++)
            if (!visited[i]) primes.add(i);
        return primes.size();
    }
}