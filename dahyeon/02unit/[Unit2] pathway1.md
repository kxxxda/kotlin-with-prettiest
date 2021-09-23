## Classes and inheritance in Kotlin
# 
### 클래스 계층 구조란
  * 상위 클래스 또는 슈퍼클래스 또는 **기본 클래스** : 하위 클래스가 하나 이상 있는 모든 클래스
     
### 기본 클래스 만들기
  - 추상 클래스   
   : 완전히 구현되지 않아서 인스턴스화할 수 없는 클래스, 일종의 '스케치'   
     <mark>__abstract__</mark> 키워드로 시작한다.  
      -> 예를 들어 Vegetable 클래스 : 각 채소에 관한 구체적인 세부정보의 결정은 서브클래스에 맡긴다.  
      -> Dwelling 클래스 : 모든 주택에 공통으로 적용되는 정보를 담고 있는 **구체적이지 않은** 집을 나타내는 기본 클래스   
>val 로 선언하면 -> 변경 불가능한 변수
  
### 서브클래스 만들기
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
즉, **abstract**클래스나 **open**키워드로 표시된 클래스에서만 상속할 수 있다.
```kotlin
open class RoundHut(residents: Int) : Dwelling(residents) {
...
}
```

>변수를 처음! 선언할 때는 val 또는 var를 앞에 붙여줘야 한다 !  
override : 상위클래스에서 정의된 것을 다시 재정의 할 때

### 계층 구조의 클래스 수정
추상 클래스에서 정의된 모든 추상 메서드는 추상 클래스의 **서브클래스에서 구현**되어야 한다.

>override 해서 함수를 재정의 할 때, 상위클래스에 있는 반복되는 코드를 방지하는 방법  
 -> super 키워드 사용 !  
```kotlin
override fun floorArea(): Double {
    return super.floorArea() * floors
}
```

### 솔루션 코드
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
### 요약
 + 일부 기능을 서브클래스에서 구현하도록 남기는 abstract 클래스
 + 따라서 abstract 클래스는 **인스턴스화**할 수 없다.
 + abstract 클래스의 서브클래스
 + override 키워드를 사용하여 서브클래스의 속성과 함수를 재정의
 + super 키워드를 사용하여 상위 클래스의 함수와 속성을 참조
 + 서브클래스로 분류할 수 있도록 클래스를 open으로 만든다
 + 속성을 private으로 만들어 클래스 내에서만 사용할 수 있도록
 + with 구문을 사용하여 동일한 객체 인스턴스에서 여러 호출을 실행
 + kotlin.math 라이브러리에서 기능을 가져온다

## Create XML layouts for Android
# 
###  XML 읽기 및 이해
 이전에 사용한 Layout Editor 대신 UI를 설명하는 **XML**을 수정해서 애플리케이션의 레이아웃을 빌드할 수 있다.  
 XML은 확장성 마크업 언어를 의미하며 텍스트 기반 문서를 사용해서 데이터를 설명하는 방법이다.  
 각 UI 요소는 XML 파일의 XML요소로 표현된다. 각 요소는 태그(<>)로 시작하고 끝난다.  
 ```kotlin
 <ConstraintLayout>
  <TextView
    text = "Hello World!">
  <TextView>
 </ConstraintLayout>
 ```
 
### XML로 레이아웃 빌드
 + 제약 조건 이름의 형식 : layout_constraint<Source>_to<Target>Of
    이때 <Source>는 현재 뷰 , <Target>은 현재 뷰가 제한되는 타겟 뷰(상위 컨테이너 또는 다른 뷰)의 가장자리를 나타낸다.  
>ConstraintLayout의 하위 요소에는 레이아웃이 정렬 방법을 알 수 있도록 제약 조건이 필요하다.
  
### 팁 옵션 추가
  
### 나머지 레이아웃 완료
+ match_parent는 ConstraintLayout의 뷰에는 사용할 수 없다. 대신 일치 제약 조건을 의미하는 0dp를 사용한다.
  
### 적절한 코딩 사례 채택
- 하드 코딩 문자열에 관한 경고  
-> 리소스 파일로 문자열을 추출하면 앱을 다른 언어로 번역하고 문자열을 재사용하기가 쉽다.  
+ Code > Reformat Code 로 들여쓰기 
  
### 요약
+ XML(확장성 마크업 언어)은 텍스트를 구성하는 방법이며 태그, 요소, 속성으로 구성
+ XML을 사용하여 Android 앱의 레이아웃을 정의
+ EditText를 사용하여 사용자가 텍스트를 입력하거나 수정
+ EditText에는 사용자에게 입력란에 예상되는 내용을 알려주는 힌트가 있다.
+ android:inputType 속성을 지정하여 사용자가 EditText 입력란에 입력할 수 있는 텍스트 유형을 제한
+ RadioGroup으로 그룹화된 RadioButtons를 사용하여 배타적인 옵션 목록을 만듭니다.
+ RadioGroup은 세로 또는 가로로 될 수 있고 개발자는 처음에 선택해야 하는 RadioButton을 지정할 수 있다.
+ Switch를 사용하여 사용자는 두 옵션 간에 전환이 가능
+ 별도의 TextView를 사용하지 않고 Switch에 라벨을 추가할 수 있다.
+ ConstraintLayout의 각 하위 요소에는 세로 및 가로 제약 조건이 있어야 한다.
+ 'start' 및 'end' 제약 조건을 사용하여 왼쪽에서 오른쪽(LTR) 및 오른쪽에서 왼쪽(RTL) 방향 언어를 모두 처리
+ 제약 조건 속성의 이름은 layout_constraint<Source>_to<Target>Of 형식
+ View의 너비를 포함되는 ConstraintLayout의 너비와 같게 하려면 시작과 끝을 상위 요소의 시작과 끝으로 제한하고 너비를 0dp로 설정합니다.
---
## Calculate the tip

### 시작 앱 개요
>Gradle은 Android 스튜디오에서 사용하는 자동화된 빌드 시스템이다. 개발자가 코드를 변경하거나 리소스를 추가하거나 그 외의 방식으로 앱을 변경할 때마다 Gradle이 변경된 사항을 파악해서 앱을 다시 빌드하는데 필요한 조취를 취한다.
  
### 뷰 결합
이전에 사용한 findViewById()는 앱에 뷰가 더 추가되고 UI가 복잡해짐에 따라 사용하는 것이 번거롭다.  
-> 뷰 결합 사용   
우선 build.gradle의 android 섹션에 아래의 코드를 추가한다.
```kotlin
buildFeatures {
    viewBinding = true
}
```
MainActivity.kt는 아래와 같이 
```kotlin
class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)  // Views에 액세스하는 데 사용할 binding 객체 초기화
        setContentView(binding.root)  // 앱의 뷰 계층 구조 루트인 binding.root를 지정
    }
}
 ```
 이제 앱에서 View에 대한 참조가 필요한 경우 binding 객체에서 뷰 참조를 가져올 수 있다.
>MainActivity 클래스의 onCreate() 메서드 : 앱이 시작되고 MainActivity가 초기화될 때 가장 먼저 호출되는 것 중 하나
### 적절한 코딩 사례 채택
Analyze > Inspect Code ... 선택
>코드의 줄 수가 적을수록, 변수가 적을수록 더 간결하고 읽기 쉬운 코드가 된다.
  
### 요약
+ 뷰 결합을 사용하면 앱의 UI 요소와 상호작용하는 코드를 더 쉽게 작성할 수 있다.
+ Kotlin의 Double 데이터 유형은 십진수를 저장할 수 있다.
+ RadioGroup의 checkRadioButtonId 속성을 사용하여 선택된 RadioButton을 확인
+ NumberFormat.getCurrencyInstance()를 사용하여 숫자를 통화 형식으로 지정하는 데 이용할 형식 지정 클래스를 가져올 수 있다.
+ %s와 같은 문자열 매개변수를 사용하여 다른 언어로 쉽게 변환할 수 있는 동적 문자열을 만들 수 있다.
+ 테스트가 중요!
+ Android 스튜디오에서 Logcat을 사용하여 앱 비정상 종료와 같은 문제를 해결할 수 있다.
+ 스택 트레이스는 호출된 메서드 목록을 보여 준다. 이는 코드가 예외를 생성하는 경우에 유용할 수 있다.
+ Null은 '값 없음'을 의미
+ 일부 코드는 null 값을 처리할 수 없으므로 주의해서 사용해야 한다.
+ 추천을 확인할 수 있는 Analyze > Inspect Code를 사용하여 코드 개선
