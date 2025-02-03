/**
 * @param {character[]} tasks
 * @param {number} n
 * @return {number}
 */
var leastInterval = function (tasks, n) {
  // Count the occurrences of tasks
  let counts = Array(26).fill(0);
  for (const task of tasks) {
    counts[task.charCodeAt(0) - "A".charCodeAt(0)]++;
  }

  // MaxHeap initialization
  let maxHeap = new MaxPriorityQueue({ priority: (count) => count });

  // Add counts to the MaxHeap
  for (const count of counts) {
    if (count > 0) maxHeap.enqueue(count);
  }

  // Set the time
  let time = 0;
  let q = new Queue(); // Pair of [cnt, idle time]

  while (maxHeap.size() > 0 || q.size() > 0) {
    time++;

    // Process the task with the highest priority (most frequent)
    if (maxHeap.size() > 0) {
      let cnt = maxHeap.dequeue().element - 1;
      if (cnt > 0) {
        q.push([cnt, time + n]); // Add to the cooldown queue
      }
    }

    if (q.size() > 0 && q.front()[1] === time) {
      maxHeap.enqueue(q.pop()[0]);
    }
  }
  return time;
};
