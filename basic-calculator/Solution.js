/**
 * @param {string} s
 * @return {number}
 */
var calculate = function (s) {
  const stack = [];
  let res = 0; // To store the running result
  let cur = 0; // To build the current number
  let sign = 1; // Current sign (+1 or -1)

  for (let c of s) {
    // Number: Build the current number
    if (!isNaN(c) && c !== " ") {
      cur = cur * 10 + parseInt(c);
    }

    // '+' or '-': Update the result with the current number
    else if (c === "+" || c === "-") {
      res += sign * cur; // Apply the current sign to cur
      sign = c === "+" ? 1 : -1; // Update the sign
      cur = 0; // Reset current number
    }

    // '(': Push the current result and sign to the stack
    else if (c === "(") {
      stack.push(res); // Store the result before parentheses
      stack.push(sign); // Store the sign before parentheses
      res = 0; // Reset result for new sub-expression
      sign = 1; // Reset sign for new sub-expression
    }

    // ')': Complete the sub-expression
    else if (c === ")") {
      res += sign * cur; // Add the last number in the sub-expression
      res *= stack.pop(); // Multiply by the sign before '('
      res += stack.pop(); // Add the result before '('
      cur = 0; // Reset current number
    }
  }

  // Process any remaining number after the loop
  return res + sign * cur;
};
