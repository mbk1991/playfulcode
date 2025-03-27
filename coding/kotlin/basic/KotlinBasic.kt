/*
 * Kotlin은 Class 밖에도 변수 선언이 가능하다. 전역 변수
*/
var topLevelVar = 10;


/*
 * Kotlin은 Java와 다르게 코든 코드를 Class안에 두지 않아도 된다.
 * 함수형 프로그래밍도 가능한 것.
 * */
fun main(){
    testFor(10)
}


/*
 * 변수의 선언
 * val: Read-only variables
 * var: Mutable variables
 * Kotlin은 Class 밖에도 변수 선언이 가능하다.
 *
 * 데이터 타입
 * Char / 1개 문자 / 'a'
 * String / 여러개의 문자 / "string"
 * Boolean / true, false
 * Byte / 1byte signed 정수
 * Short / 2byte signed 정수
 * Int / 4byte signed 정수
 * Long / 8byte signed 정수/ 123124124L
 * Float / 4byte signed 실수 / 3.141592F
 * Double / 8byte signed 실수
 *
 * 타입 추론
 * Kotlin은 리터럴로 타입 추론이 가능하여 변수 선언 시 타입을 기재하지 않아도됨
 * */
fun variable(){
    val numberVal = 5
    val stringVal = "stringVal"
 
     val PI: Double = 3.141592


    var numberVar = 10
    // numberVal = 10  // Exception
    numberVar = 20

    val v1: Int = 1
    val v2: Int
    v2 = 2

    println("v1+v2 = ${v1+v2}")
    println("topLevelVar in variable() = ${topLevelVar}")
}


fun ifTest(isOk: Boolean){
    if(isOk){
        println("isOk : ${isOk}")
    }else{
        println("isOk : ${isOk}")
    }

    var result = if (isOk) "isOk is True" else "isOk is False"


    var t: String
    var result2 = if (isOk){
        t = "ttttt"
        t
    }else{
        t = "sssss"
        t
    }
    println("t ${t}")

}


fun whenTest(s: String){
    when(s){
        "A" ->{
            println("A")
        }
        "B" ->{
            println("B")
        }
        else ->{
            println("etc")
        }
    }
}

fun whenTest2(n: Int){
    when(n){
        in 0..9 ->{
            println("0~9")
        }
        in 10..19 ->{
            println("10~19")
        }
        in 20..29 ->{
            println("20~29")
        }
        else ->{
            println("etc")
        }
    }
}

fun whenTest3(n: Int){
    var value = n
    when{
        value == 1 ->{
            println("value = 1")
        }
        value < 0 ->{
            println("value는 음수")
        }
    }

}

// String 배열은 따로 없고 제네릭으로 사용 (객체 배열은 다르게 다룬다)
fun testArray(){
    var intArray = IntArray(10)
    var longArray = LongArray(10)
    var charArray = CharArray(10)
    var shortArray = ShortArray(10)
    var doubleArray = DoubleArray(10)
    var floatArray = FloatArray(10)
    var byteArray = ByteArray(10)
    var booleanArray = BooleanArray(10)
    var stringArray2 = Array(10,{i->""})
}


// List, Set, Map
fun testCollection(){
    //list.set(), list.get(), list.set(), list.size
    var list = mutableListOf("MON", "TUE", "WED", "THU" ,"FRI","SAT","SUN")
    var list2 = mutableListOf<String>()

    //set.add(), set.remove()
    var set1 = mutableSetOf<String>()

    //map.put(), map.remove(), map.get()
    var map1 = mutableMapOf<String, String>()
}

fun testFor(n: Int){


    var stringArray = arrayOf("a","b","c","d","e","f")
    for(idx in 0 until stringArray.size){
        println(stringArray[idx])
    }



    for (idx in 0 .. n){
        println("idx ${idx}")
    }

}








