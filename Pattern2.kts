interface ComputerItem{
    fun setName(NameItem: String)
    fun Price(): Int
    fun viewItem()
}

class Computer{
    val partOfComputerName: String = ""

    override fun setName(NameItem: String){partOfComputerName = NameItem}
    override fun Price(): Int{ return priceOfPart}
    override fun viewItem() { println("$partOfComputerName - $priceOfPart")}
}

class PartOfComputer : ComputerItem{
    private var partName = ""
    private val items = mutableListOf<ComputerItem>()

    fun addPart(computerItem: ComputerItem) {items.add(computerItem)}
    fun removePart(computerItem: ComputerItem) {items.remove(computerItem)}

    override fun setName(NameItem: String) { partName = NameItem }
    override fun Price(): Int {
        var sum = 0
        items.forEach{sum += it.Price()}
        return sum
    }

    override fun viewItem() { printIn("$partName - ${Price()}") }
}

fun main(){
    val partsItem = mutableListOf<ComputerItem>()

    val ssd = Computer(2500).apply { setName("SSD") }
    val hdd = Computer(3000).apply { setName("HDD") }
    val ram = Computer(2200).apply { setName("RAM") }
    val motherboard = Computer(4200).apply { setName("Motherboard") }
    val monitor = Computer(5500).apply { setName("Monitor") }
    val keyboard = Computer(2000).apply { setName("Keyboard") }

    val externalParts = PartOfComputer().apply { setName("External parts of computer") }
    val internalParts = PartOfComputer().apply { setName("Internal parts of computer") }

    externalParts.apply {
        addPart(monitor)
        addPart(keyboard)
    }
    internalParts.apply {
        addPart(ssd)
        addPart(hdd)
        addPart(ram)
        addPart(motherboard)
    }

    partsItem.addAll(listOf(ssd,hdd,ram,motherboard,monitor,keyboard, externalParts, internalParts))

    partsItem.forEach { it.viewItem() }
}