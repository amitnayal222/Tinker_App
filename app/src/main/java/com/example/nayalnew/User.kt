package com.example.nayalnew

class User {
    var id : Int = 0
    var first_name : String = ""
    var last_name : String = ""
    var number : Int = 0
    var email : String = ""
    var password : String = ""
    constructor(first_name:String,last_name:String,number:Int,email:String,password:String){
        this.first_name = first_name
        this.last_name = last_name
        this.number = number
        this.email = email
        this.password = password
    }
}