//
//  Varible3.swift
//  test
//
//  Created by m._.se0k on 8/22/24.
//

// 3.연산자란?

import SwiftUI

struct Varible3: View {
    
    //대입연산자
    let name = "m._.se0k"   //let 키워드는 상수 표현이다.
    var age = 22            //var 키워드는 변수 표현이다.
    var anyNumber = 6
    var anyNumber2 = 8
    
    var body: some View {
        VStack{
            //사칙연산자
            Text("\(age) + \(anyNumber) = \(age + anyNumber)")
            Text("\(age) - \(anyNumber) = \(age - anyNumber)")
            Text("\(age) * \(anyNumber) = \(age * anyNumber)")
            Text("\(age) / \(anyNumber) = \(age / anyNumber)")
            Text("\(age) % \(anyNumber) = \(age % anyNumber)")
            
            //비교연산자
            Text("\(anyNumber < anyNumber2)".description)
            Text("\(anyNumber > anyNumber2)".description)
            Text("\(anyNumber <= anyNumber2)".description)
            Text("\(anyNumber >= anyNumber2)".description)
            Text("\(anyNumber == anyNumber2)".description)
            Text("\(anyNumber != anyNumber2)".description)
        }
        
    }
}

#Preview {
    Varible3()
}
