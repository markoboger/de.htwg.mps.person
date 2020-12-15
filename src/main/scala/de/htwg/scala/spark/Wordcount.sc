

val list = List("In Reactive Systems we take a closer look at technologies for BigData","Spark is a BigData technology","BigData")
val words = list.flatMap(line => line.split(" "))
val keyData = words.map(word => (word,1))
val groupedData = keyData.groupBy(_._1)
val result = groupedData.mapValues(list=>{
  list.map(_._2).sum
})
result.foreach(println)

