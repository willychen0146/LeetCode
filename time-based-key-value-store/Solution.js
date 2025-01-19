
var TimeMap = function() {
    this.keyStore = new Map(); // key : list of [value, timestamp]
};

/** 
 * @param {string} key 
 * @param {string} value 
 * @param {number} timestamp
 * @return {void}
 */
TimeMap.prototype.set = function(key, value, timestamp) {
    if(!this.keyStore.has(key)){
        this.keyStore.set(key, []);
    }
    this.keyStore.get(key).push([timestamp, value]);
};

/** 
 * @param {string} key 
 * @param {number} timestamp
 * @return {string}
 */
TimeMap.prototype.get = function(key, timestamp) {
    const values = this.keyStore.get(key) || [];
    let result = '';

    // Binary search
    let l = 0;
    let r = values.length - 1;
    while(r >= l){
        const mid = Math.floor((l + r) / 2);
        if(values[mid][0] <= timestamp){
            result = values[mid][1];
            l = mid + 1;
        }
        else{
            r = mid - 1;
        }
    }
    return result;
};

/** 
 * Your TimeMap object will be instantiated and called as such:
 * var obj = new TimeMap()
 * obj.set(key,value,timestamp)
 * var param_2 = obj.get(key,timestamp)
 */
