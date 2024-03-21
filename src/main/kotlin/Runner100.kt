class Runner100(nameV:String) {
    var bestResults:Array<Int>
    init{
        require(nameV.isNotBlank())
        require(nameV.isNotEmpty())
        bestResults=Array(10){0}
    }
    fun worstResult():Int?{
        var worst:Int
        worst=bestResults[0]
        for(i in 0 until bestResults.size){
            if(worst<bestResults[i]&&bestResults[i]!=0){
                worst=bestResults[i]
            }
        }
        if(worst==0){
            return null
        }
        else{
            return worst
        }

    }
    fun addResult(value:Int){
        check(value>0){"invalid num"}
        for(i in bestResults){
            val worst = worstResult()
            if(i==0||value<worst!!.toInt()){
                bestResults[i]=value
                break
            }
        }
    }fun bestResult():Int?{
        var best:Int
        best = Int.MAX_VALUE
        for(i in 0 until bestResults.size){
            if(best<bestResults[i]&&bestResults[i]!=0){
                best=bestResults[i]
            }
        }
        if(best==Int.MAX_VALUE){
            return null
        }
        else{
            return best
        }

    }
    fun modifyResult(position:Int,result:Int){
        check(position in 0 until bestResults.size)
        check(result>0)
        bestResults[position]=result
    }
    //- Sostituire tutti i risultati con quelli passati come parametro
    fun substituteArray(array:Array<Int>){
        check(array.size==bestResults.size)
        for(i in bestResults.indices){
            bestResults[i]=array[i]
        }
    }
    //Calcolare il risultato medio (la media dei valori dei miei results. Non conteggio i null o gli zero perchè non sono risultati)
    fun calculateAverage():Double{
        var sum=0
        var times=0
        for(i in bestResults){
            if(i!=0){
                sum+=i
                times++
            }
        }
        return (times/sum).toDouble()
    }
    //- Calcolare l'array degli scarti dalla media
    // (creo un array in cui per ogni risultato calcolare la differenza tra il valore medio ed il valore di results all'i-sima posizione)
    //esempio: results [2,4,6,0,0,0,0,0,0,0]
    //media = 4
    //scarti --> [2, 0, -2, 0, 0, 0, 0, 0, 0, 0]
    //i valori null o zero non li considero mai perchè non rappresentano dei risultati
    fun trashArray():Array<Int>{
        var trashArray=bestResults
        var average =calculateAverage().toInt()
        for(i in trashArray.indices){
            if(trashArray[i]!=0){
                trashArray[i]=trashArray[i]-average
            }
        }
        return trashArray
    }
}