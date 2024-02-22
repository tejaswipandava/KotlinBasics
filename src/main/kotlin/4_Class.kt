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

    val fullName2 = "we have over and above $firstName $lastName".also(::println)

    companion object {
        val fullName3 = "we have full name 3 ".also(::println)
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

fun main() {
    var emp = Employee("teja", "pandava")
    println(emp.fullName) //we cant access the firstname and lastname
    println()

    val emp1 = Employee1("parikshit", "teja", 12)
//    val emp2 = Employee2("pJ", "TJ", 12,"Axis")
    val emp2 = Employee2("pJ", "TJ", 12)
    emp2.department = "Axis kar do"
//    emp2.setDepartment1("Axis bank")
    emp2.getDepartment1()
}


//data class when you want only a model which will store some kind of data type/ object
//data class objects should be accessible outside its own class like main that's why they are declared with val or var

//class: to have some functionality not limited to a particular type
//we need not access the data outside the class so that's why no need of var or val
//() are primary constructors that are used to load data to the class/datatype

data class Employee1(val fname: String, val lname: String, val age: Int) {
    lateinit var department: String
    fun getname(): String {
        return fname + lname
    }

    constructor(firstname: String, lastname: String, age: Int, department: String) : this(firstname, lastname, age) {
        this.department = department
    }
}


//lateinit can be set from : init, secondary constructor, class method but cant use same names like getter/setter, outside the class using its .property
//We are in init block 1"
//We are in init block 2
//we are in secondary constructor
//we have this details 1


//we have this details 1
//We are in init block 1"
//we are in secondary constructor
//We are in init block 2

class Employee2(fname: String, lname: String, val age: Int) {
    val fulldetails = "we have this details 1 $age".also(::println)
    lateinit var department: String
    val fname = fname
    val lname = lname

    init {
        println("We are in init block 1 $department")
    }

//    constructor(firstname: String, lastname: String, age: Int, department: String) : this(firstname, lastname, age) {
//        this.department = department
//        println("we are in secondary constructor")
//    }

    fun setDepartment1(department: String) {
        this.department = department
    }

    fun getDepartment1() {
        println("we have the follwoing department with us : $department")
    }

    init {
        print("We are in init block 2")
    }

    fun getname(): String {
        return fname + lname
    }

}


