// const a = 10;
// const b = 20;
// console.log(a+b)


/*
Array functions
const add = (a, b) => {
    return a + b;
}

console.log(add(10, 20))
*/
const readline = require('readline');

const getDate = () =>{
    return new Date().toLocaleDateString();
}

const getDay = () => {
    return new Date().getDay();
}

const getTime = () =>{
    return new Date().toLocaleTimeString();
}

const main = (name) => {
    console.log("Hello, ", name);
    console.log("Today is ", getDate());
    console.log("Day is ", getDay());
    console.log("Time is ", getTime());
}

// For browsers
// const getUserInput = () => {
//     const name = prompt("Enter your name:");
//     main(name);
// }

const getUserInput = () => {

    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    rl.question("Enter your name: ", (name) => {
        rl.close();
        main(name);
    });
    
}


getUserInput();