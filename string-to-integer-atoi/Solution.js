/**
 * @param {string} s
 * @return {number}
 */
var myAtoi = function(s) {
    // Remove extra space
    s = s.trim();

    // Handle empty string case
    if (s.length === 0) return 0;

    // Initiate the index and sign
    let index = 0;
    let sign = 1;

    // Identify the +-
    if(s[index] === '+'){
        index++;
    }
    else if(s[index] === '-'){
        index++;
        sign = -1;
    }

    // start process the string
    let parse = 0;
    while(index < s.length){
        let curr = s[index];
        if(curr < '0' || curr > '9'){
            break;
        }
        parse = parse * 10 + parseInt(curr);
        index++;
    }
    parse *= sign;

    // check the int is inside the range
    if(parse > (2**31 - 1)){
        return (2**31 - 1)
    }
    else if(parse < -(2**31)){
        return -(2**31)
    }
    else{
        return parse;
    }
};
