/**
 * @param {string} s
 * @param {string} p
 * @return {number[]}
 */
var findAnagrams = function (s, p) {
  // Impossible to build the word
  const sLen = s.length,
    pLen = p.length;
  if (pLen > sLen) return [];

  // Create two arrays to store character frequencies (a-z)
  const pCount = new Array(26).fill(0);
  const sCount = new Array(26).fill(0);

  // Count frequencies of first pLen characters in both strings
  for (let i = 0; i < pLen; i++) {
    pCount[p.charCodeAt(i) - 97]++; // 97 is ASCII for 'a'
    sCount[s.charCodeAt(i) - 97]++;
  }

  // Count how many characters have matching frequencies
  let match = 0;
  for (let i = 0; i < 26; i++) {
    if (pCount[i] === sCount[i]) match++;
  }

  const res = [];
  // If all 26 characters match (including 0 counts), found an anagram
  if (match === 26) res.push(0);

  // Slide the window through string s
  let l = 0;
  for (let r = pLen; r < sLen; r++) {
    // Remove leftmost character of previous window
    let c = s.charCodeAt(l) - 97;
    // If counts matched before removal, decrement match
    if (sCount[c] === pCount[c]) match--;
    sCount[c]--; // Remove character from window
    l++; // Move left pointer
    // If counts match after removal, increment match
    if (sCount[c] === pCount[c]) match++;

    // Add new character at right edge of window
    c = s.charCodeAt(r) - 97;
    // If counts matched before addition, decrement match
    if (sCount[c] === pCount[c]) match--;
    sCount[c]++; // Add new character to window
    // If counts match after addition, increment match
    if (sCount[c] === pCount[c]) match++;

    // If all character frequencies match, we found an anagram
    if (match === 26) res.push(l);
  }

  return res;
};
