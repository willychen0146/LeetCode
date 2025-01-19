/**
 * @param {string} s
 * @param {string[]} wordDict
 * @return {boolean}
 */
var wordBreak = function (s, wordDict) {
  // dp bottom up approach
  totalLen = s.length;
  const dp = new Array(totalLen + 1).fill(false);
  dp[totalLen] = true; // Base case

  for (let i = totalLen - 1; i >= 0; i--) {
    for (const w of wordDict) {
      if (i + w.length <= totalLen && s.slice(i, i + w.length) === w) {
        dp[i] = dp[i + w.length];
      }
      if (dp[i]) {
        break;
      }
    }
  }

  return dp[0];
};
