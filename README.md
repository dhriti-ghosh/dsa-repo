# LeetCode Data Structures — Patterns & Priority Guide

> Priority legend: 🔴 Must Know · 🟠 High Priority · 🔵 Medium · 🟣 Advanced

---

## 1. Array / String

> Foundation of ~60% of all LeetCode problems

**Java:** `int[]`, `String`, `ArrayList<>`, `Arrays.sort()`, `Collections.sort()`

| Priority | Pattern                                   | Description                                                               | Example Problems                                                                       |
|----------|-------------------------------------------|---------------------------------------------------------------------------|----------------------------------------------------------------------------------------|
| 🔴 Must  | **Two Pointers**                          | Left/right pointers that move toward each other or in same direction      | Two Sum II, Container With Most Water, Valid Palindrome, 3Sum                          |
| 🔴 Must  | **Sliding Window**                        | Fixed or dynamic window over array/string for subarray/substring problems | Longest Substring Without Repeat, Max Sum Subarray of Size K, Minimum Window Substring |
| 🔴 Must  | **Prefix Sum**                            | Precompute cumulative sums for O(1) range queries                         | Subarray Sum Equals K, Range Sum Query, Product of Array Except Self                   |
| 🟠 High  | **Kadane's Algorithm**                    | Track max subarray ending at current index                                | Maximum Subarray, Best Time to Buy/Sell Stock                                          |
| 🟠 High  | **Dutch National Flag / 3-way Partition** | Sort array of 3 distinct values in one pass                               | Sort Colors, Partition Array by Pivot                                                  |
| 🔵 Med   | **Binary Search on Answer**               | Search on the result space rather than the array itself                   | Koko Eating Bananas, Minimum Days to Make Bouquets, Capacity to Ship Packages          |
| 🟣 Adv   | **Difference Array**                      | Apply range updates in O(1) then reconstruct with prefix sum              | Corporate Flight Bookings, Car Pooling                                                 |

---

## 2. HashMap / HashSet

> Instant O(1) lookup — solves most frequency/uniqueness problems

**Java:** `HashMap<K,V>`, `HashSet<E>`, `LinkedHashMap`, `TreeMap` (sorted order)

| Priority | Pattern                      | Description                                                          | Example Problems                                                                   |
|----------|------------------------------|----------------------------------------------------------------------|------------------------------------------------------------------------------------|
| 🔴 Must  | **Frequency Count**          | Count occurrences, then use counts for decisions                     | Valid Anagram, Top K Frequent Elements, Group Anagrams                             |
| 🔴 Must  | **Two Sum Pattern**          | Store seen values/indices in map, check complement on each step      | Two Sum, Pairs with Given Difference, Subarray Sum = K                             |
| 🔴 Must  | **Seen Set / Deduplication** | Use HashSet to detect duplicates or visited nodes                    | Contains Duplicate, Longest Consecutive Sequence, Happy Number                     |
| 🟠 High  | **Index Mapping**            | Map value → first/last index for range calculations                  | Longest Subarray with Sum K, Find Pivot Index                                      |
| 🟠 High  | **Sliding Window + HashMap** | Track window contents in a frequency map while sliding               | Minimum Window Substring, Permutation in String, Longest Substring with K Distinct |
| 🔵 Med   | **Prefix Sum + HashMap**     | Store prefix sum → count in map to find subarrays matching condition | Subarray Sum Equals K, Binary Subarrays with Sum                                   |

---

## 3. Stack

> LIFO — essential for nested structures and next/prev comparisons

**Java:** `ArrayDeque<>` as stack — `push()`, `pop()`, `peek()`

| Priority | Pattern                               | Description                                                               | Example Problems                                                         |
|----------|---------------------------------------|---------------------------------------------------------------------------|--------------------------------------------------------------------------|
| 🔴 Must  | **Balanced Brackets / Matching**      | Push opening chars, pop and match on closing                              | Valid Parentheses, Decode String, Remove Invalid Parentheses             |
| 🔴 Must  | **Monotonic Stack**                   | Maintain increasing or decreasing stack to find next/prev greater/smaller | Daily Temperatures, Next Greater Element, Largest Rectangle in Histogram |
| 🟠 High  | **Expression Evaluation**             | Evaluate postfix/infix expressions using operator and operand stacks      | Basic Calculator I/II, Evaluate Reverse Polish Notation                  |
| 🟠 High  | **Iterative DFS / Tree Traversal**    | Replace recursion with explicit stack for inorder/preorder traversal      | Binary Tree Inorder Traversal, Flatten Binary Tree to Linked List        |
| 🔵 Med   | **Stock Span / Trap Water**           | Use monotonic stack to determine span or bounded area                     | Trapping Rain Water, Online Stock Span, Sum of Subarray Minimums         |
| 🟣 Adv   | **Min Stack / Stack with Extra Info** | Augment stack to track additional aggregate in O(1)                       | Min Stack, Maximum Frequency Stack                                       |

---

## 4. Queue / Deque

> FIFO for BFS; Deque for sliding window extremes

**Java:** `ArrayDeque<>` for both queue (`offer`/`poll`) and deque (`offerFirst`/`pollLast`)

| Priority | Pattern                              | Description                                                          | Example Problems                                                       |
|----------|--------------------------------------|----------------------------------------------------------------------|------------------------------------------------------------------------|
| 🔴 Must  | **BFS — Level Order Traversal**      | Process nodes level-by-level using a queue                           | Binary Tree Level Order, Rotting Oranges, Word Ladder                  |
| 🔴 Must  | **BFS — Shortest Path (Unweighted)** | BFS always finds shortest path in unweighted graph                   | Word Ladder, Shortest Path in Binary Matrix, Jump Game III             |
| 🟠 High  | **Monotonic Deque**                  | Maintain max/min of sliding window in O(1) amortized using deque     | Sliding Window Maximum, Jump Game VI, Constrained Subsequence Sum      |
| 🟠 High  | **Multi-source BFS**                 | Enqueue multiple starting nodes simultaneously                       | Rotting Oranges, 0-1 Matrix, Pacific Atlantic Water Flow               |
| 🔵 Med   | **BFS on Implicit Graph**            | Model problem state as nodes, transitions as edges                   | Open the Lock, Minimum Genetic Mutation, Snakes and Ladders            |
| 🟣 Adv   | **0-1 BFS (Deque BFS)**              | Use deque to handle edge weights of 0 or 1 without Dijkstra overhead | Minimum Cost to Make at Least One Valid Path, Minimum Obstacle Removal |

---

## 5. Binary Tree / BST

> Recursive thinking is the key skill here

**Java:** `TreeNode` class; DFS = recursion or stack; BFS = `ArrayDeque`

| Priority | Pattern                               | Description                                                                | Example Problems                                                    |
|----------|---------------------------------------|----------------------------------------------------------------------------|---------------------------------------------------------------------|
| 🔴 Must  | **DFS — Recursive (all traversals)**  | Preorder, Inorder, Postorder — know all three cold                         | Path Sum, Diameter of Binary Tree, Maximum Depth, Inorder Traversal |
| 🔴 Must  | **Return value up / pass value down** | Design recursive functions that aggregate upward or carry context downward | Max Path Sum, Lowest Common Ancestor, Binary Tree Cameras           |
| 🔴 Must  | **BST Properties**                    | Inorder of BST = sorted. Validate, search, insert in O(h)                  | Validate BST, Kth Smallest in BST, Convert Sorted Array to BST      |
| 🟠 High  | **Level-order BFS**                   | Queue-based level traversal for layer-by-layer problems                    | Zigzag Traversal, Right Side View, Average of Levels                |
| 🟠 High  | **Lowest Common Ancestor (LCA)**      | Classic divide — find in left, find in right, combine                      | LCA of Binary Tree, LCA of BST, Distance Between Nodes              |
| 🔵 Med   | **Serialize / Deserialize**           | Encode tree to string and rebuild — tests traversal mastery                | Serialize and Deserialize Binary Tree, Encode N-ary Tree            |
| 🟣 Adv   | **Morris Traversal**                  | O(1) space inorder traversal using threaded tree technique                 | Binary Tree Inorder Traversal (space optimized), Recover BST        |

---

## 6. Heap (PriorityQueue)

> Efficient top-K and dynamic ordering problems

**Java:** `PriorityQueue<>` (min-heap default); max-heap: `(a,b)->b-a` or `Comparator.reverseOrder()`

| Priority | Pattern                         | Description                                               | Example Problems                                                                      |
|----------|---------------------------------|-----------------------------------------------------------|---------------------------------------------------------------------------------------|
| 🔴 Must  | **Top K Elements**              | Maintain a heap of size K — O(n log K) instead of sorting | Top K Frequent Elements, K Closest Points to Origin, Kth Largest Element              |
| 🔴 Must  | **Merge K Sorted Lists/Arrays** | Always poll the global minimum across K iterators         | Merge K Sorted Lists, K-th Smallest in Sorted Matrix, Smallest Range Covering K Lists |
| 🟠 High  | **Two Heaps (Running Median)**  | Max-heap for lower half, min-heap for upper half          | Find Median from Data Stream, Sliding Window Median                                   |
| 🟠 High  | **Dijkstra's Shortest Path**    | Min-heap drives greedy expansion of shortest distances    | Network Delay Time, Cheapest Flights Within K Stops, Path with Min Effort             |
| 🔵 Med   | **Task / Interval Scheduling**  | Use heap to always pick the best next task by priority    | Task Scheduler, Meeting Rooms II, IPO, Reorganize String                              |
| 🟣 Adv   | **Huffman / Greedy Heap**       | Repeatedly merge two smallest elements                    | Minimum Cost to Connect Sticks, Furthest Building You Can Reach                       |

---

## 7. Graph

> Build adjacency list first, then choose DFS / BFS / Union-Find

**Java:** `Map<Integer, List<Integer>>` or `List<List<Integer>>` adj; `boolean[] visited`

| Priority | Pattern                                 | Description                                                            | Example Problems                                                              |
|----------|-----------------------------------------|------------------------------------------------------------------------|-------------------------------------------------------------------------------|
| 🔴 Must  | **DFS — Connected Components**          | DFS from each unvisited node, count components                         | Number of Islands, Number of Provinces, Count Connected Components            |
| 🔴 Must  | **Topological Sort (DFS / Kahn's BFS)** | Order nodes with no incoming edges first — detects cycles too          | Course Schedule I/II, Alien Dictionary, Sort Items by Group                   |
| 🟠 High  | **BFS Shortest Path (Dijkstra)**        | Greedy shortest path with min-heap                                     | Network Delay Time, Cheapest Flights, Path with Min Effort                    |
| 🟠 High  | **Union-Find**                          | Group nodes into components; fast union and find with path compression | Number of Islands II, Redundant Connection, Accounts Merge                    |
| 🟠 High  | **Cycle Detection**                     | DFS with in-stack set (directed) or parent tracking (undirected)       | Course Schedule, Find Eventual Safe States, Graph Valid Tree                  |
| 🔵 Med   | **Bipartite Check**                     | 2-color graph using BFS/DFS; detect odd-length cycles                  | Is Graph Bipartite, Possible Bipartition                                      |
| 🟣 Adv   | **Bellman-Ford / SPFA**                 | Handle negative edges; detect negative cycles                          | Cheapest Flights Within K Stops (k-stop constraint), Negative Cycle Detection |

---

## 8. Trie (Prefix Tree)

> Best for dictionary / autocomplete / word search problems

**Java:** `TrieNode { TrieNode[] children = new TrieNode[26]; boolean isEnd; }`

| Priority | Pattern                            | Description                                              | Example Problems                                                   |
|----------|------------------------------------|----------------------------------------------------------|--------------------------------------------------------------------|
| 🔴 Must  | **Insert & Search**                | Build the trie then search for exact words or prefixes   | Implement Trie, Add and Search Words, Design Search Autocomplete   |
| 🟠 High  | **Prefix Matching / startsWith**   | Check if any inserted word has a given prefix            | Implement Trie, Replace Words, Map Sum Pairs                       |
| 🟠 High  | **Trie + DFS (Word Search)**       | Traverse grid while navigating trie simultaneously       | Word Search II, Boggle Solver                                      |
| 🔵 Med   | **XOR Maximum (Binary Trie)**      | Store numbers bit-by-bit; greedy descent to maximize XOR | Maximum XOR of Two Numbers, Maximum XOR with an Element from Array |
| 🟣 Adv   | **Compressed Trie / Suffix Array** | Space-efficient tries or suffix-based string indexing    | Short Encoding of Words, Longest Word in Dictionary                |

---

## 9. Linked List

> Pointer manipulation — draw the list, then code

**Java:** `ListNode { int val; ListNode next; }` — always use a dummy head node

| Priority | Pattern                             | Description                                                   | Example Problems                                                      |
|----------|-------------------------------------|---------------------------------------------------------------|-----------------------------------------------------------------------|
| 🔴 Must  | **Reverse (Iterative & Recursive)** | Three pointers: prev, curr, next — fundamental building block | Reverse Linked List, Reverse in K-Group, Reverse Between              |
| 🔴 Must  | **Fast & Slow Pointers (Floyd's)**  | Detect cycles, find middle, find cycle entry point            | Linked List Cycle I/II, Middle of Linked List, Palindrome Linked List |
| 🟠 High  | **Dummy Head Node**                 | Simplifies edge cases for insertions/deletions at head        | Remove Nth from End, Merge Two Sorted Lists, Remove Duplicates        |
| 🟠 High  | **Merge / Sort**                    | Merge two sorted lists; sort using merge sort on list         | Merge Two Sorted Lists, Sort List, Merge K Sorted Lists               |
| 🔵 Med   | **LRU Cache (DLL + HashMap)**       | Doubly linked list + HashMap for O(1) get and put             | LRU Cache, LFU Cache, All O(1) Data Structure                         |

---

## 10. Union-Find (Disjoint Set)

> Fast grouping of nodes — complement to graph DFS/BFS

**Java:** `int[] parent, rank;` with path compression + union by rank

| Priority | Pattern                               | Description                                                  | Example Problems                                            |
|----------|---------------------------------------|--------------------------------------------------------------|-------------------------------------------------------------|
| 🔴 Must  | **Connected Components**              | Union edges, count distinct roots                            | Number of Islands II, Number of Provinces, Friend Circles   |
| 🟠 High  | **Cycle Detection (Undirected)**      | If `find(u) == find(v)` before union — cycle exists          | Redundant Connection, Graph Valid Tree                      |
| 🟠 High  | **Dynamic Connectivity**              | Handle online queries adding edges and checking connectivity | Accounts Merge, Satisfiability of Equality Equations        |
| 🔵 Med   | **Minimum Spanning Tree (Kruskal's)** | Sort edges by weight, union greedily avoiding cycles         | Min Cost to Connect All Points, Optimize Water Distribution |
| 🟣 Adv   | **Weighted Union-Find**               | Store relative weights/ratios in union structure             | Evaluate Division, Smallest String With Swaps               |

---

## Quick Reference — Priority Summary

| Tier             | Patterns to master                                                                                                                                                                                                                                                |
|------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| 🔴 Must Know     | Two Pointers, Sliding Window, Prefix Sum, HashMap Frequency/Two-Sum, Stack Matching, Monotonic Stack, BFS (level + shortest path), DFS (tree traversals), Top-K Heap, Merge K Sorted, Graph DFS/Topo Sort, Linked List Reverse + Fast-Slow, Union-Find Components |
| 🟠 High Priority | Kadane's, Dutch Flag, Two Heaps, Dijkstra, LCA, Monotonic Deque, Multi-source BFS, Trie + DFS, Cycle Detection, Kruskal's MST, Dummy Head                                                                                                                         |
| 🔵 Medium        | Binary Search on Answer, Prefix Sum + Map, BFS on Implicit Graph, Serialize/Deserialize Tree, XOR Trie, Bipartite Check, LRU Cache                                                                                                                                |
| 🟣 Advanced      | Difference Array, 0-1 BFS, Morris Traversal, Huffman Heap, Bellman-Ford, Compressed Trie, Weighted Union-Find                                                                                                                                                     |