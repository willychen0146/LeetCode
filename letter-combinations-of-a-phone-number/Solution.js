/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function (digits) {
  // Base case
  const result = [];
  if (digits.length === 0) return result;

  const digitToChar = {
    2: "abc",
    3: "def",
    4: "ghi",
    5: "jkl",
    6: "mno",
    7: "qprs",
    8: "tuv",
    9: "wxyz",
  };

  function backtracking(i, currentStr) {
    if (currentStr.length === digits.length) {
      result.push(currentStr);
      return;
    }
    for (const c of digitToChar[digits[i]]) {
      backtracking(i + 1, currentStr + c);
    }
  }

  backtracking(0, "");

  return result;
};
