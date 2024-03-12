/*
const a:number = 10;
const b:number = 20;
console.log(a+b)
*/

const readline = require('readline');

const getDate = ():String => {
    return new Date().toDateString();
}

const getTime = ():String => {
    return new Date().toTimeString();
}

const getMonth = ():String => {
    return new Date().getMonth().toString();
}

const main = (raja:String):void => {

    console.log("Hello, ",raja);
    console.log(getDate());
    console.log(getTime());
    console.log(getMonth());

}

const readInput = ():void => {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });
    rl.question('What is your name? ', (name:String) => {
        main(name);
        rl.close();
    });
}

readInput();