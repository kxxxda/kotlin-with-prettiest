## Classes and inheritance in Kotlin

#### 클래스 계층 구조란
  + 상위 클래스 또는 슈퍼클래스 또는 **기본 클래스** : 하위 클래스가 하나 이상 있는 모든 클래스
     
#### 기본 클래스 만들기
  - 추상 클래스 : 완전히 구현되지 않아서 인스턴스화할 수 없는 클래스, 일종의 '스케치'  
      예를 들어 Vegetable 클래스 -> Vegetable은 각 채소에 관한 구체적인 세부정보의 결정은 서브클래스에 맡기는 추상 클래스다.  
      " Dwelling과 Vegetable은 추상 클래스다. 여러 유형의 주택 또는 야채의 공통적인 속성과 함수를 포함하지만 속성의 정확한 값과 함수 구현의 세부정보는 알 수 없다"
      -> 추상 클래스의 선언은 __abstract__ 키워드로 시작한다.
>val 로 선언하면 -> 변경 불가능한 변수
  
#### 서브클래스 만들기
**with** 를 통해 코드를 단순화 할 수 있다.
```kotlin
    println("\nSquare Cabin\n============")
    println("Capacity: ${squareCabin.capacity}")
    println("Material: ${squareCabin.buildingMaterial}")
    println("Has room? ${squareCabin.hasRoom()}")
```
아래와 같이 단순화
```kotlin
with(squareCabin) {
    println("\nSquare Cabin\n============")
    println("Capacity: ${capacity}")
    println("Material: ${buildingMaterial}")
    println("Has room? ${hasRoom()}")
}
```
class는 최종클래스이며 서브클래스로 분류할 수 없다.  
**abstract**클래스나 **open**키워드로 표시된 클래스에서만 상속할 수 있다.
```kotlin
open class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial = "Straw"
    override val capacity = 6
}
```

>변수를 처음! 선언할 때는 val 또는 var를 앞에 붙여줘야 한다 !  
override : 상위클래스에서 정의된 것을 다시 재정의 할 때

#### 계층 구조의 클래스 수정
추상 클래스에서 정의된 모든 추상 메서드는 추상 클래스의 **서브클래스에서 구현**되어야 한다.

>override 해서 함수를 재정의 할 때, 상위클래스에 있는 반복되는 코드를 방지하는 방법 -> super 키워드 사용 !  
```kotlin
override fun floorArea(): Double {
    return super.floorArea() * floors
}
```

#### 솔루션 코드
```kotlin
import kotlin.math.PI
import kotlin.math.sqrt

fun main() {
   val squareCabin = SquareCabin(6, 50.0)
   val roundHut = RoundHut(3, 10.0)
   val roundTower = RoundTower(4, 15.5)

   with(squareCabin) {  // with로 코드 단순화
       println("\nSquare Cabin\n============")
       println("Capacity: ${capacity}")
       println("Material: ${buildingMaterial}")
       println("Floor area: ${floorArea()}")
   }

   with(roundHut) { 
       println("\nRound Hut\n=========")
       println("Material: ${buildingMaterial}")
       println("Capacity: ${capacity}")
       println("Floor area: ${floorArea()}")
       println("Has room? ${hasRoom()}")
       getRoom()
       println("Has room? ${hasRoom()}")
       getRoom()
       println("Carpet size: ${calculateMaxCarpetSize()}")
   }

   with(roundTower) {
       println("\nRound Tower\n==========")
       println("Material: ${buildingMaterial}")
       println("Capacity: ${capacity}")
       println("Floor area: ${floorArea()}")
       println("Carpet size: ${calculateMaxCarpetSize()}")
   }
}

abstract class Dwelling(private var residents: Int) {  // 추상클래스이기 때문에 abstract 키워드 
   abstract val buildingMaterial: String
   abstract val capacity: Int

   abstract fun floorArea(): Double

   fun hasRoom(): Boolean {
       return residents < capacity
   }

   fun getRoom() {
       if (capacity > residents) {
           residents++
           println("You got a room!")
       } else {
           println("Sorry, at capacity and no rooms left.")
       }
   }

   }

class SquareCabin(residents: Int, val length: Double) : Dwelling(residents) {
   override val buildingMaterial = "Wood"
   override val capacity = 6

   override fun floorArea(): Double {
       return length * length
   }

}

open class RoundHut(  // open 키워드 
       val residents: Int, val radius: Double) : Dwelling(residents) {

   override val buildingMaterial = "Straw"
   override val capacity = 4

   override fun floorArea(): Double {
       return PI * radius * radius
   }

   fun calculateMaxCarpetSize(): Double {
       val diameter = 2 * radius
       return sqrt(diameter * diameter / 2)
   }

}

class RoundTower(
       residents: Int,
       radius: Double,
       val floors: Int = 2) : RoundHut(residents, radius) {

   override val buildingMaterial = "Stone"

   // Capacity depends on the number of floors.
   override val capacity = floors * 4

   override fun floorArea(): Double {
       return super.floorArea() * floors
   }
}
```
#### 요약
 + 하위 클래스가 상위 클래스에서 기능을 상속받는 클래스 트리인 클래스 계층 구조를 만드는 방법. 속성과 함수가 서브클래스에 상속됩니다.
 + 일부 기능을 서브클래스에서 구현하도록 남기는 abstract 클래스를 만드는 방법. 따라서 abstract 클래스는 인스턴스화할 수 없습니다.
 + abstract 클래스의 서브클래스를 만드는 방법
 + override 키워드를 사용하여 서브클래스의 속성과 함수를 재정의하는 방법
 + super 키워드를 사용하여 상위 클래스의 함수와 속성을 참조하는 방법
 + 서브클래스로 분류할 수 있도록 클래스를 open으로 만드는 방법
 + 속성을 private으로 만들어 클래스 내에서만 사용할 수 있도록 하는 방법
 + with 구문을 사용하여 동일한 객체 인스턴스에서 여러 호출을 실행하는 방법
 + kotlin.math 라이브러리에서 기능을 가져오는 방법
---
 ## Create XML layouts for Android
 
 
