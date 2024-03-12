package main

import (
    "fmt"
    "time"
)

func getDate() string {
    // Get current date in YYYY-MM-DD format
    return time.Now().Format("2006-01-02")
}

func getDay() string {
    // Get current day as a string (e.g., "Monday")
    return time.Now().Weekday().String()
}

func getTime() string {
    // Get current time in HH:MM:SS format
    return time.Now().Format("15:04:05")
}

func main() {
    var name string
    fmt.Print("Enter your name: ")
    fmt.Scanf("%s", &name)
    fmt.Println("Hello,", name)
    fmt.Println("Today is:", getDate())
    fmt.Println("Day is:", getDay())
    fmt.Println("Current time is:", getTime())
}

