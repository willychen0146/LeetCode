/**
 * @param {string[][]} accounts
 * @return {string[][]}
 */

// Basic union find data structure
class UnionFind{
    constructor(n){
        this.parent = Array.from({ length: n }, (_, i) => i); // [0, 1, 2, ...]
        this.rank = Array(n).fill(1); // [1, 1, 1, ...]
    }

    find(x){
        if(x !== this.parent[x]){
            this.parent[x] = this.find(this.parent[x])
        }
        return this.parent[x];
    }

    union(x1, x2){
        const p1 = this.find(x1);
        const p2 = this.find(x2);
        if(p1 === p2){
            return false;
        }
        if(this.rank[p1] > this.rank[p2]){
            this.parent[p2] = p1;
            this.rank[p1] += this.rank[p2];
        }
        else{
            this.parent[p1] = p2;
            this.rank[p2] += this.rank[p1];       
        }
        return true;
    }
}

var accountsMerge = function(accounts) {
    const n = accounts.length;
    const uf = new UnionFind(n);
    const mailToAccount = new Map(); // mail -> index of account

    // Building UF
    for(let i = 0; i < accounts.length; i++){
        for(let j = 1; j < accounts[i].length; j++){
            const mail = accounts[i][j];
            if(mailToAccount.has(mail)){
                uf.union(i, mailToAccount.get(mail));
            }
            else{
                mailToAccount.set(mail, i);
            }
        }
    }

    // Group emails by leader account
    const mailGroup = new Map(); // index of account -> list of email
    for(const [mail, accID] of mailToAccount.entries()){
        const leader = uf.find(accID);
        if(!mailGroup.has(leader)){
            mailGroup.set(leader, []);
        }
        mailGroup.get(leader).push(mail);
    }

    // Get the result
    let result = [];
    for(const [accID, mails] of mailGroup){
        mails.sort();
        const merge = [accounts[accID][0], ...mails];
        result.push(merge);
    }

    return result;
};
