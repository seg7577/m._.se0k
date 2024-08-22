//
//  Variable4.swift
//  test
//
//  Created by m._.se0k on 8/22/24.
//

/* 4. 여러 개의 변수를 모아서 쓰는 콜렉션 타입 */
import SwiftUI

struct Variable4: View {
    
    let name: [String] = ["m._.se0k", "jinyeonge_", "_okdongja_"]//Array
    let engKrDictionary: [String:String] = ["Apple":"사과", "Banana":"바나나", "Coconut":"코코넛"]//Dictionary key:value 관계를 가짐
    let houseAnimals: Set = ["🐶", "🐈", "🐺"]//Set 집합 : 합집합, 교집합 등으로 사용 가능함
    let farmAnimals: Set = ["🐶", "🐈", "🐮", "🐳"]
    
    var body: some View {
        //Array, Dictionary, Set
        Text("\(name[0])")
        Text("\(name[1])")
        Text("\(name[2])")
        
        Text("\(engKrDictionary["Apple"]!)")
        Text("\(engKrDictionary["Banana"]!)")
        Text("\(engKrDictionary["Coconut"]!)")
        
        Text("\(houseAnimals.intersection(farmAnimals).description)")
    }
}

#Preview {
    Variable4()
}
