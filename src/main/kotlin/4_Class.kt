/*
classes are declared using the class keyword
class name(params) constructors are declared in the header itself i.e ()

initialization block if some code needs to be executed during object creation that goes in the init block

diff b/w class Employee(firstName: String, lastName: String) and class Student(val firstName: String, val lastName: String)
> in the first case firstname and lastname are local scope variable of the constructor
> whereas when we define with val or var, we are saying the parameters are not only local scope but rather they are properties and can be access outside the class
> see user class to understand it
 */

class Employee(firstName: String, lastName: String) {
    val fullName = "we have $firstName $lastName".also(::println)

    init {
        println("person class's init fun is getting executed")
        println("we have the following in the constructor firstname: $firstName, lastname: $lastName and fullname: $fullName")
    }

}

class Student(val firstName: String, val lastName: String) {
    val fullName = "they have $firstName $lastName".also(::println)
    lateinit var specialization: String

    // todo: secondary contructor, they will run only after the init block of the first constructor
    constructor(firstName: String, lastName: String, specialization: String) : this(firstName, lastName) {
        this.specialization = specialization
        println("2nd person init fin is getting executed")
    }

    init {
        println("person class's first init fun is getting executed")
        println("we have the following in the constructor firstname: $firstName, lastname: $lastName and fullname: $fullName")
    }

}

class User() {
    fun getDetails() {
        var emp = Employee("teja", "pandava")
        println(emp.fullName) //we cant access the firstname and lastname
        println()

        var std = Student("teja", "pandava")
        println(std.firstName) //we can access the firstname and lastname
        println()

        var std2 = Student("teja", "pandava", "Computer Science")
        println(std2.firstName) //we can access the firstname and lastname
        println(std2.lastName) //we can access the firstname and lastname
        println(std2.fullName) //we can access the firstname and lastname
        println(std2.specialization) //we can access the firstname and lastname
        println()
    }
}