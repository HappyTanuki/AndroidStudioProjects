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
    var dataClass: MenuEntityDataClass
    var imgURL: String
    val name: String
    val quantity: Int
    val price: Int
    fun setDataClass(classData: MenuEntityDataClass) { dataClass = classData }
    fun setImgURL(uRL: String) { imgURL = uRL }
    fun getImgURL(): String = imgURL
    fun getName(): String = name
    fun getQuantity(): Int = quantity
    fun getPrice(): Int = price
    fun getOptions(): List<Beverage>
}
class Coffee(
    override var dataClass: MenuEntityDataClass,
    override var imgURL: String,
    override val name: String,
    override val quantity: Int,
    override val price: Int
) : Beverage {
    override fun getOptions(): List<Beverage> {
        return emptyList()
    }
}
abstract class CoffeeDecorator(
    private val coffee: Coffee
): Beverage by coffee
class CoffeePurl(
    coffee: Coffee
): CoffeeDecorator(coffee) {
    override fun getName(): String {
        return "${super.name} 펄추가"
    }
    override fun getPrice(): Int {
        return super.price + 100
    }
    override fun getOptions(): List<Beverage> {
        return super.getOptions() + listOf(this)
    }
}
class CoffeeShot(
    coffee: Coffee
): CoffeeDecorator(coffee) {
    override fun getName(): String {
        return "${super.name} 샷추가"
    }
    override fun getPrice(): Int {
        return super.price + 100
    }
    override fun getOptions(): List<Beverage> {
        return super.getOptions() + listOf(this)
    }
}
class CoffeeIce(
    coffee: Coffee
): CoffeeDecorator(coffee) {
    override fun getName(): String {
        return "${super.name} 얼음추가"
    }
    override fun getPrice(): Int {
        return super.price
    }
    override fun getOptions(): List<Beverage> {
        return super.getOptions() + listOf(this)
    }
}