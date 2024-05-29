package com.my.kiosk

import androidx.compose.runtime.MutableState

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
    var quantity: MutableState<Int>
    val price: Int
    var superBeverage: Beverage?
    val options: MutableList<Beverage>
        get() = mutableListOf<Beverage>()
}
class Coffee(
    override var dataClass: MenuEntityDataClass,
    override var imgURL: String,
    override val name: String,
    override var quantity: MutableState<Int>,
    override val price: Int,
    override var superBeverage: Beverage? = null
) : Beverage {
}
abstract class BeverageDecorator(
    override var superBeverage: Beverage?
): Beverage {
    override val dataClass: MenuEntityDataClass
        get() {
            return superBeverage!!.dataClass
        }
    override var imgURL: String = ""
        set(value) {
            field = value
        }
        get() {
            return superBeverage!!.imgURL
        }
    override var quantity: MutableState<Int>
        set(value) {
            superBeverage!!.quantity = value
        }
        get() {
            return superBeverage!!.quantity
        }
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

    override val options: MutableList<Beverage>
        get() {
            superBeverage!!.options.add(this)
            return superBeverage!!.options
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

    override val options: MutableList<Beverage>
        get() {
            superBeverage!!.options.add(this)
            return superBeverage!!.options
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

    override val options: MutableList<Beverage>
        get() {
            superBeverage!!.options.add(this)
            return superBeverage!!.options
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

    override val options: MutableList<Beverage>
        get() {
            superBeverage!!.options.add(this)
            return superBeverage!!.options
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
    beverageDecorator: BeverageDecorator): Beverage {

    if (beverage.superBeverage == null)
        return beverage

    val curBeverage = beverageDecoratorRemover(beverage.superBeverage!!, beverageDecorator)

    return if (beverageDecoratorTypegetter(curBeverage) == beverageDecoratorTypegetter(beverageDecorator)) {
        curBeverage.superBeverage!!
    }
    else {
        curBeverage
    }
}