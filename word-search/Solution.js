/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function (board, word) {
  const ROW = board.length;
  const COL = board[0].length;
  // const path = new Set();

  function dfs(r, c, i) {
    if (i === word.length) return true;

    if (
      r < 0 ||
      c < 0 ||
      r >= ROW ||
      c >= COL ||
      board[r][c] !== word[i] ||
      //    path.has(`${r},${c}`)) return false;
      board[r][c] === "X"
    )
      return false;

    // path.add(`${r},${c}`);
    board[r][c] = "X";
    const result =
      dfs(r + 1, c, i + 1) ||
      dfs(r - 1, c, i + 1) ||
      dfs(r, c + 1, i + 1) ||
      dfs(r, c - 1, i + 1);
    // path.delete(`${r},${c}`);
    board[r][c] = word[i];
    return result;
  }

  for (let r = 0; r < ROW; r++) {
    for (let c = 0; c < COL; c++) {
      if (dfs(r, c, 0)) return true;
    }
  }
  return false;
};
