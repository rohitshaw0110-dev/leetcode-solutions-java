Best Time to Buy and Sell Stock

## 📝 Problem Summary
You are given an array `prices` where `prices[i]` is the stock price on day `i`.

Your goal is to **maximize profit** by choosing:

- One day **to buy**
- A later day **to sell**

Return the **maximum profit** possible.  
If no profit is possible, return `0`.

---

## 🔍 Example 1
**Input:**  
`prices = [7,1,5,3,6,4]`  

**Output:**  
`5`  

**Explanation:**  
Buy at price **1**, sell at price **6** → profit = `6 - 1 = 5`.

---

## 🔍 Example 2
**Input:**  
`prices = [7,6,4,3,1]`  

**Output:**  
`0`  

**Explanation:**  
Prices are decreasing → no profit possible.

---

## 💡 Optimal Solution — Single Pass (O(n) Time, O(1) Space)

To maximize profit:

1. Track the **minimum price** seen so far (best day to buy).
2. At each day, compute potential profit:  
   `price - minPrice`
3. Update the **maximum profit** when today’s profit is higher.

This ensures:
- You always buy **before** selling  
- You find the most profitable pair of days

This is the classic O(n) sliding window minimum approach.

---

## ⏱ Complexity

| Operation | Complexity |
|----------|-------------|
| Time     | **O(n)** |
| Space    | **O(1)** |

---

## ✅ Java Code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE; // track lowest price seen so far
        int maxProfit = 0;                // track best profit

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;         // new best buy price
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice); // sell today
            }
        }

        return maxProfit;
    }
}
🧠 Explanation of Key Line
java
Copy code
maxProfit = Math.max(maxProfit, price - minPrice);
price - minPrice = profit if selling today

Compare this with previous maxProfit

Keep whichever is larger

This ensures we always track the best possible profit.

🧪 Local Testing (Optional)
java
Copy code
public static void main(String[] args) {
    int[] prices = {7, 1, 5, 3, 6, 4};
    Solution sol = new Solution();
    System.out.println(sol.maxProfit(prices)); // Output: 5
}
✔️ Summary
Scan prices once

Track the minimum buy price

Update maximum profit on each day

O(n) time, O(1) space

Simple and optimal for single-transaction stock trading
