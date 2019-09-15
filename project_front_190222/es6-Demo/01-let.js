// var 声明的变量没有局部作用域
// let 声明的变量  有局部作用域
{
    var a = 0
    let b = 1
}
console.log(a)  // 0
//console.log(b)  // ReferenceError: b is not defined

// var 可以声明多次
// let 只能声明一次
var m = 1
var m = 2
let n = 3
//let n = 4
console.log(m)  // 2
console.log(n)  // Identifier 'n' has already been declared

// var 会变量提升
// let 不存在变量提升
console.log(x)  //undefined
var x = 'apple'


console.log(y)  //ReferenceError: y is not defined
let y = 'banana'