/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
    let resultIdx = 0;
    let resultLen = 0;

    for(let i = 0; i < s.length; i++){
        // check for odd palindrome
        let l = i;
        let r = i;
        while(l >= 0 && r < s.length && s[l] === s[r]){
            if((r - l + 1) > resultLen){
                resultIdx = l;
                resultLen = r - l + 1;
            }
            l--;
            r++;
        }

        // check for even palindrome
        l = i;
        r = i + 1;
        while(l >= 0 && r < s.length && s[l] === s[r]){
            if((r - l + 1) > resultLen){
                resultIdx = l;
                resultLen = r - l + 1;
            }
            l--;
            r++;
        }
    }
    return s.substring(resultIdx, resultIdx + resultLen)
};
