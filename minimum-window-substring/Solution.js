/**
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function (s, t) {
  // Check the edge case
  if (s.length < t.length || s.length === 0 || t.length === 0) return "";

  // Init map
  const window = {};
  const tMap = {};
  for (let c of t) {
    tMap[c] = (tMap[c] || 0) + 1;
  }

  // Init condition
  let have = 0;
  need = Object.keys(tMap).length;
  let res = [-1, -1];
  let resLen = Infinity;
  let l = 0;

  // Start get the result
  for (let r = 0; r < s.length; r++) {
    // Update the window map
    let c = s[r];
    window[c] = (window[c] || 0) + 1;

    // Update the have if need
    if (tMap[c] && window[c] === tMap[c]) have++;

    // If condition is met, start pop element from left to reduce the res size
    while (have === need) {
      // Update the result first
      if (r - l + 1 < resLen) {
        resLen = r - l + 1;
        res = [l, r];
      }
      // Reduce the count of left character
      window[s[l]]--;

      // If current pop element that is needed, decrease the have
      if (tMap[s[l]] && window[s[l]] < tMap[s[l]]) {
        have--;
      }
      // Increase left pointer
      l++;
    }
  }

  return resLen === Infinity ? "" : s.slice(res[0], res[1] + 1);
};
