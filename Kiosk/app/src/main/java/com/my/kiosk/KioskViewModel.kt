package com.my.kiosk

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class MenuEntityDataClass(
    val name: String,
    val id: Int
)
//data class MenuOptionsData(
//    val name: String
//)
//interface MenuEntityData {
//    var dataClass: MenuEntityDataClass
//    var loaded : Boolean
//    val url: String
//    val name: String
//    val price: Long
//    fun menuOptions(
//        dataClass: MenuEntityDataClass,
//        loaded : Boolean,
//        url: String,
//        name: String,
//        price: Long
//    ): List<MenuOptionsData>
//}
interface Beverage: Cloneable {
    val dataClass: MenuEntityDataClass
    val imgURL: String
    val name: MutableState<String>
    var quantity: MutableState<Int>
    val price: MutableState<Int>
    var superBeverage: Beverage?
    val optPrice: Int
    val options: MutableList<Beverage>
        get() = mutableListOf<Beverage>()
    public override fun clone(): Beverage {
        return super.clone() as Beverage
    }
}
data class Coffee(
    override var dataClass: MenuEntityDataClass,
    override var imgURL: String,
    override val name: MutableState<String>,
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
    override val name: MutableState<String>
        get() {
            return mutableStateOf("${superBeverage!!.name.value} 펄추가")
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
    override val name: MutableState<String>
        get() {
            return mutableStateOf("${superBeverage!!.name.value} 샷추가")
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
    override val name: MutableState<String>
        get() {
            return mutableStateOf("${superBeverage!!.name.value} 얼음추가")
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
    override val name: MutableState<String>
        get() {
            return mutableStateOf("뜨거운 ${superBeverage!!.name.value}")
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

    val curBeverage = beverageDecoratorRemover(beverage.superBeverage!!, beverageDecorator)

    return if (beverageDecoratorTypegetter(curBeverage) == beverageDecoratorTypegetter(beverageDecorator)) {
        curBeverage
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

    val curBeverage = searchBeverageDecorator(beverage.superBeverage!!, beverageDecorator)

    return if (curBeverage == null)
        null
    else if (beverageDecoratorTypegetter(curBeverage) == beverageDecoratorTypegetter(beverageDecorator))
        null
    else
        beverage
}