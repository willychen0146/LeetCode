/**
 * @param {number} n
 * @param {number[][]} edges
 * @return {number[]}
 */
var findMinHeightTrees = function (n, edges) {
  // Only have one node case
  if (n === 1) return [0];

  // Adjacency list
  const adj = Array.from({ length: n }, () => []);

  // Build undirect adjacency list
  for (const [n1, n2] of edges) {
    adj[n1].push(n2);
    adj[n2].push(n1);
  }

  // Every node's edge count
  const edgeCnt = Array(n).fill(0);
  const leaves = new Queue();

  for (let i = 0; i < n; i++) {
    edgeCnt[i] = adj[i].length;
    // Identify leave node
    if (adj[i].length === 1) {
      leaves.push(i);
    }
  }

  // BFS
  while (!leaves.isEmpty()) {
    // If n less than 2, return the result
    if (n <= 2) return leaves.toArray();
    const size = leaves.size();
    for (let i = 0; i < size; i++) {
      const node = leaves.pop();
      n--;
      // Update the new leaves (converge)
      for (const nei of adj[node]) {
        edgeCnt[nei]--;
        if (edgeCnt[nei] === 1) {
          leaves.push(nei);
        }
      }
    }
  }

  // Null list -> return null
  return [];
};
