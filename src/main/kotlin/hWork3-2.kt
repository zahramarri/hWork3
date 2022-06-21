class Branch(private var code: String, private var city: String, private var rate: Int) {
    val listOfCustomers = mutableListOf<Customer>()

    fun getCode(): String {
        return code
    }

    fun getCity(): String {
        return city
    }

    fun getRate(): Int {
        return rate
    }

    fun setCode(code: String) {
        this.code = code
    }

    fun setCity(city: String) {
        this.city = city
    }

    fun setRate(rate: Int) {
        this.rate = rate
    }
}

class Customer(private var name: String, private var creditCard: CreditCard, private var account: Account) {

    fun getName(): String {
        return name
    }

    fun getCreditCard(): CreditCard {
        return creditCard
    }

    fun getAccount(): Account {
        return account
    }

    fun setName(name: String) {
        this.name = name
    }

    fun setCreditCard(creditCard: CreditCard) {
        this.creditCard = creditCard
    }

    fun setAccount(account: Account) {
        this.account = account
    }

    fun calCustomerBalance(): Double {
        return creditCard.getCredit() + account.getBalance()
    }

}

class CreditCard(private var cardNumber: String, private var credit: Double) {

    fun getCardNumber(): String {
        return cardNumber
    }

    fun getCredit(): Double {
        return credit
    }

    fun setCardNumber(cardNumber: String) {
        this.cardNumber = cardNumber
    }

    fun setCredit(credit: Double) {
        this.credit = credit
    }

}

class Account(private var accountNumber: String, private var balance: Double, private var branch: Branch) {

    fun getAccountNumber(): String {
        return accountNumber
    }

    fun getBalance(): Double {
        return balance
    }

    fun getBranch(): Branch {
        return branch
    }

    fun setAccountNumber(accountNumber: String) {
        this.accountNumber = accountNumber
    }

    fun setBalance(balance: Double) {
        this.balance = balance
    }

    fun setBranch(branch: Branch) {
        this.branch = branch
    }
}

fun main() {
    val branches = mutableListOf<Branch>()
    val customers = mutableListOf<Customer>()
    // make 5 branches with random information
    for (i in 1..5) {
        var code = ""
        for (j in 1..10) {
            val c = (1..2).random()
            if (c == 1) {
                code += ('a'..'z').random()
            } else {
                code += (0..9).random()
            }
        }
        val city = arrayOf("Tehran", "Mashhad", "Qom", "Shiraz", "Tabriz").random()
        val rate = arrayOf(1, 2, 3).random()
        branches.add(Branch(code, city, rate))
    }

    //create 20 new customers with properties gotten from input
    for (k in 1..20) {
        println("Please enter NAME of customer.")
        val name = readLine().toString()

        var cardNumber = ""
        for (l in 1..16) {
            cardNumber += (0..9).random()
        }
        println("Please enter CREDIT of customer.")
        var credit = 0.0
        readLine()?.let {
            credit = it.toDouble()
        }
        val creditCard = CreditCard(cardNumber, credit)

        var accountNumber = ""
        for (l in 1..10) {
            accountNumber += (0..9).random()
        }
        println("Please enter BALANCE of customer.")
        var balance = 0.0
        readLine()?.let {
            balance = it.toDouble()
        }
        val branch = branches.random()
        val account = Account(accountNumber, balance, branch)

        val newCustomer = Customer(name, creditCard, account)
        customers.add(newCustomer)
        branch.listOfCustomers.add(newCustomer)
    }

    //call calCustomerBalance function for each customer
    customers.forEach{ println(it.calCustomerBalance()) }

    //call calCustomerBalance function for customers of each branch
    for (branch in branches) {
        println(branch.getCode())
        var sum = 0.0
        for (customer in branch.listOfCustomers) {
            sum += customer.calCustomerBalance()
        }
        println("Sum of balance in this branch: $sum")
    }
}