package com.example.kotlinlib

open class Food
class FastFood() : Food()
class BurgerFood : Food()

interface Production<out T> {
    fun product(): T
}

interface Consumer<in T> {
    fun consume(item: T)
}

// 生产者，商店
class FoodStore : Production<Food> {
    override fun product(): Food {
        println("product food")
        return Food()
    }

}

//快餐店
class FastFoodStore : Production<FastFood> {
    override fun product(): FastFood {
        println("product fast food")
        return FastFood()
    }
}

//快餐店
class BurgerFoodStore : Production<BurgerFood> {
    override fun product(): BurgerFood {
        println("product Burger food")
        return BurgerFood()
    }
}

fun main() {
    val p1: Production<Food> = FoodStore()
    val p2: Production<Food> = FastFoodStore()
}