// Class defining the dependency

interface NotificationInterface {
    fun sendMessage(message: String)
}
class EmailService : NotificationInterface {
    override fun sendMessage(message: String) {
        println("Sending email: $message")
    }
}

class SMSService : NotificationInterface {
    override fun sendMessage(message: String) {
        println("Sending sms: $message")
    }
}
class Notification {
    private val emailService = EmailService()
    private val smsService = SMSService()

    fun sendNotification(notification: String) {
        emailService.sendMessage(notification)
        smsService.sendMessage(notification)
    }
}

//High Level Module
//High Level Module depends on interface
//ligh Level Module depends on inteface
class DINotification(val service: NotificationInterface) {

    fun sendNotification(notification: String) {
        service.sendMessage(notification)
    }
}

// Main function to demonstrate the code without IoC
fun main() {
    val email = EmailService()
    val sms = SMSService()
    val notificationService = Notification()
    notificationService.sendNotification("Hello, world!")

    val diNotification = DINotification(sms)
    diNotification.sendNotification("Hello World")
}



//Class that relies on EmailService

//tight couple
// open and close principle
//single Responsibility Principle

//control of flow is with the notificaiton
//notification class has what all responsibilities?
//--> creation of objects
//--> send notification