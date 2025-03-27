// Kotlin의 함수 
// fun 키워드 사용
// fun functionName(parameterName: type): returnType {
//          return
// }
// 
// Kotlin에서 파라미터로 넘겨받은 인자는 모두 val(Immutable) 이다.
// Kotlin은 파라미터를 넘겨줄 때 파라미터 이름을 직접 지정할 수 있다.

fun main(args: Array<String>){
    newFunction("mabin", age=34, weight = 76.2)
}


//argument immutable test
fun immutableArgument(n: Int){
   // n = 100    // can't be reasigned exception 
    println(n);
}

fun newFunction(name: String, age: Int = 35, weight: Double = 75.1){
    println("name : ${name}")
    println("age : ${age}")
    println("weight : ${weight}")
}

