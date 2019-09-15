// 定义成员：
var sum = function(a,b){
    return a + b
}
var subtract = function(a,b){
    return a - b
}
var multiply = function(a,b){
    return a * b
}
var divide = function(a,b){
    return a / b
}

// // 导出成员：
// module.exports = {
//     sum: sum,
//     subtract: subtract,
//     multiply: multiply,
//     divide: divide
// }

//简写
module.exports = {
    sum,
    subtract,
    multiply,
    divide
}