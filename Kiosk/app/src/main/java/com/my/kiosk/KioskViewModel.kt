package com.my.kiosk

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class MenuEntityDataClass(
    val name: String,
    val id: Int
)
interface Beverage {
    val dataClass: MenuEntityDataClass
    val imgURL: String
    val name: MutableState<List<String>>
    var quantity: MutableState<Int>
    val price: MutableState<Int>
    var superBeverage: Beverage?
    val optPrice: Int
    val options: MutableList<Beverage>
        get() = mutableListOf<Beverage>()
}
data class Coffee(
    override var dataClass: MenuEntityDataClass,
    override var imgURL: String,
    override val name: MutableState<List<String>>,
    override var quantity: MutableState<Int>,
    override val price: MutableState<Int>,
    override var superBeverage: Beverage? = null,
    override val optPrice: Int = 0
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
    override val price: MutableState<Int>
        get() {
            return superBeverage!!.price
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
    override val name: MutableState<List<String>>
        get() {
            return mutableStateOf(superBeverage!!.name.value + listOf(" 펄추가"))
        }
    override val options: MutableList<Beverage>
        get() {
            superBeverage!!.options.add(this)
            return superBeverage!!.options
        }
    override val optPrice: Int
        get() = superBeverage!!.optPrice + 100
}

class BeverageAddShot(
    override var superBeverage: Beverage?
): BeverageDecorator(superBeverage) {
    override val name: MutableState<List<String>>
        get() {
            return mutableStateOf(superBeverage!!.name.value + listOf(" 샷추가"))
        }
    override val options: MutableList<Beverage>
        get() {
            superBeverage!!.options.add(this)
            return superBeverage!!.options
        }
    override val optPrice: Int
        get() = superBeverage!!.optPrice + 100
}

class BeverageAddIce(
    override var superBeverage: Beverage?
): BeverageDecorator(superBeverage) {
    override val name: MutableState<List<String>>
        get() {
            return mutableStateOf(superBeverage!!.name.value + listOf(" 얼음추가"))
        }
    override val options: MutableList<Beverage>
        get() {
            superBeverage!!.options.add(this)
            return superBeverage!!.options
        }
    override val optPrice: Int
        get() = superBeverage!!.optPrice
}

class HotBeverage(
    override var superBeverage: Beverage?
): BeverageDecorator(superBeverage) {
    override val name: MutableState<List<String>>
        get() {
            return mutableStateOf(listOf("뜨거운 ") + superBeverage!!.name.value)
        }
    override val options: MutableList<Beverage>
        get() {
            superBeverage!!.options.add(this)
            return superBeverage!!.options
        }
    override val optPrice: Int
        get() = superBeverage!!.optPrice
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

    beverage.superBeverage = beverageDecoratorRemover(beverage.superBeverage!!, beverageDecorator)

    return if (beverageDecoratorTypegetter(beverage) == beverageDecoratorTypegetter(beverageDecorator)) {
        beverage.superBeverage!!
    }
    else {
        beverage
    }
}

fun searchBeverageDecorator(
    beverage: Beverage,
    beverageDecorator: BeverageDecorator): Beverage? {
    if (beverage.superBeverage == null)
        return beverage

    val nextBeverage = searchBeverageDecorator(beverage.superBeverage!!, beverageDecorator)

    return if (nextBeverage == null)
        null
    else if (beverageDecoratorTypegetter(beverage) == beverageDecoratorTypegetter(beverageDecorator))
        null
    else
        beverage
}