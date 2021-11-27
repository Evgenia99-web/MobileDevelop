/*
    Ситуация такая: очень часто пользователь при регистрации подписывается
    на расслку новостей по почте и телефону.

    Так вот в базе хранится User к которому приминяется Command.
 */

data class User(val name: String){}

interface Command{ fun execute(user: User)}

class SendEmailUser : Command {
    override fun execute(user: User) {
        println("Send news by email to username: "+user.name)
    }
}

class SendPhoneUser : Command {
    override fun execute(user: User) {
        println("Send news by phone to username: "+user.name)
    }
}

fun main(args:Array<String>){
    var user = User("Jane Fonda")

    var email = SendEmailUser()
    email.execute(user)

    var telephone = SendPhoneUser()
    telephone.execute(user)
}