//Reduce Function
function CustReduce(arr,fn){
    var sum = 0
    for (var i = 0; i < arr.length; i++){
        sum = fn(sum,arr[i]);
    }
    return sum/arr.length;
}

var arr = [1,2,3,4,5];
var result = CustReduce(arr, (acc,ele) => {
    return acc += ele;
}); 

console.log(result);