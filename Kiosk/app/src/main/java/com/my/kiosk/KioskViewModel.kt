package com.my.kiosk

data class MenuEntityDataClass(
    val name: String,
    val id: Int
)
data class MenuOptionsData(
    val name: String
)
interface MenuEntityData {
    var dataClass: MenuEntityDataClass
    var loaded : Boolean
    val url: String
    val name: String
    val price: Long
    fun menuOptions(
        dataClass: MenuEntityDataClass,
        loaded : Boolean,
        url: String,
        name: String,
        price: Long
    ): List<MenuOptionsData>
}
interface Beverage {
    val dataClass: MenuEntityDataClass
    val imgURL: String
    val name: String
    var quantity: Int
    val price: Int
    var superBeverage: Beverage?
    val options: List<Beverage>
        get() = emptyList()
}
class Coffee(
    override var dataClass: MenuEntityDataClass,
    override var imgURL: String,
    override val name: String,
    override var quantity: Int,
    override val price: Int,
    override var superBeverage: Beverage? = null
) : Beverage {
}
abstract class BeverageDecorator(
    override var superBeverage: Beverage?
): Beverage {
    override val dataClass: MenuEntityDataClass = superBeverage!!.dataClass
    override val imgURL: String  = superBeverage!!.imgURL
    override val name: String = superBeverage!!.name
    override var quantity: Int = superBeverage!!.quantity
    override val price: Int = superBeverage!!.price
}
class BeverageAddPurl(
    override var superBeverage: Beverage?
): BeverageDecorator(superBeverage) {
    override val name: String
        get() {
            return "${superBeverage!!.name} 펄추가"
        }

    override val price: Int
        get() {
            return superBeverage!!.price + 100
        }

    override val options: List<Beverage>
        get() {
            return superBeverage!!.options + listOf(this)
        }
}

class BeverageAddShot(
    override var superBeverage: Beverage?
): BeverageDecorator(superBeverage) {
    override val name: String
        get() {
            return "${superBeverage!!.name} 샷추가"
        }

    override val price: Int
        get() {
            return superBeverage!!.price + 100
        }

    override val options: List<Beverage>
        get() {
            return superBeverage!!.options + listOf(this)
        }
}

class BeverageAddIce(
    override var superBeverage: Beverage?
): BeverageDecorator(superBeverage) {
    override val name: String
        get() {
            return "${superBeverage!!.name} 얼음추가"
        }

    override val price: Int
        get() {
            return superBeverage!!.price
        }

    override val options: List<Beverage>
        get() {
            return superBeverage!!.options + listOf(this)
        }
}

class HotBeverage(
    override var superBeverage: Beverage?
): BeverageDecorator(superBeverage) {
    override val name: String
        get() {
            return "뜨거운 ${superBeverage!!.name}"
        }

    override val price: Int
        get() {
            return superBeverage!!.price
        }

    override val options: List<Beverage>
        get() {
            return superBeverage!!.options + listOf(this)
        }
}

fun beverageDecoratorTypegetter(beverage: Beverage): Int {
    when (beverage) {
        is BeverageAddPurl -> return 0
        is BeverageAddShot -> return 1
        is BeverageAddIce -> return 2
        is HotBeverage -> return 3
        else -> return -1
    }
}

fun beverageDecoratorRemover(
    beverage: Beverage,
    beverageDecorator: BeverageDecorator): Boolean {
    var curBeverage: Beverage = beverage
    if (curBeverage.superBeverage == null)
        return false
    while (curBeverage.superBeverage != null) {
        val nextBeverage: Beverage = curBeverage.superBeverage!!
        if (beverageDecoratorTypegetter(curBeverage) == beverageDecoratorTypegetter(beverageDecorator)) {
            curBeverage.superBeverage = nextBeverage.superBeverage
            curBeverage = nextBeverage.superBeverage!!
        }
    }
    return true
}