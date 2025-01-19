/**
 * @param {number[][]} intervals
 * @return {number[][]}
 */
var merge = function(intervals) {
    intervals.sort((a, b) => a[0] - b[0]);
    const output = [];
    output.push(intervals[0]);

    for (const interval of intervals){
        const start = interval[0];
        const end = interval[1];
        const lastEnd = output[output.length - 1][1];

        if(start <= lastEnd){
            output[output.length - 1][1] = Math.max(end, lastEnd);
        }
        else{
            output.push(interval);
        }
    }

    return output;
};
