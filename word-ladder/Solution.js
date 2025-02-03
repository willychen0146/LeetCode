/**
 * @param {string} beginWord
 * @param {string} endWord
 * @param {string[]} wordList
 * @return {number}
 */
var ladderLength = function (beginWord, endWord, wordList) {
  // Base case: the word is not in wordList
  if (!wordList.includes(endWord)) return 0;

  // Create adjacency list
  const nei = {};
  wordList.push(beginWord);
  for (const word of wordList) {
    for (let j = 0; j < word.length; j++) {
      // Create pattern substring
      const pattern = word.substring(0, j) + "*" + word.substring(j + 1);
      if (!nei[pattern]) {
        nei[pattern] = [];
      }
      nei[pattern].push(word);
    }
  }

  // Create BFS data structure
  const visit = new Set([beginWord]);
  const q = new Queue([beginWord]);
  let res = 1;

  // BFS
  while (!q.isEmpty()) {
    const size = q.size();
    for (let i = 0; i < size; i++) {
      const word = q.pop();

      // Got to the endWord position
      if (word === endWord) return res;

      for (let j = 0; j < word.length; j++) {
        // Create pattern substring
        const pattern = word.substring(0, j) + "*" + word.substring(j + 1);
        // Go through every neighbor
        for (const neiWord of nei[pattern]) {
          if (!visit.has(neiWord)) {
            visit.add(neiWord);
            q.push(neiWord);
          }
        }
      }
    }
    // Update res when traverse one layer
    res++;
  }

  // No valid transformation sequence found
  return 0;
};
