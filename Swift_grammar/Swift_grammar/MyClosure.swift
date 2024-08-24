//
//  MyClosure.swift
//  Swift_grammar
//
//  Created by m._.se0k on 8/24/24.
//

// 11. 이름 없는 함수 클로저
/*
 1. 클로저는 이름 없는 함수이다.
 2. 어떤한 행동을 할 때 행동을 칭하지 않고 사용하고 싶을 때 사용할 수 있다.
 */

import SwiftUI

struct MyClosure: View {
    
    let myFirstClosure: () -> Void = {print("Hi closure")}
    
//    let myFirstClosuer: (String) -> Int = { name in
//        return 3
//    }
//    //String 형태를 입력 받고 Int형을 반환한다.
    
    // "{print("Hi22")}" 클로저는 이름이 없는 함수이다. 앞의 코드가 바로 클로저이다. 입력 또한 받을 수 있으며, 반환 또한 가능하다.
    
    func sayHi() -> Void
    //함수는 코드 덩어리
    {
        print("Hi Function")
    }
    func sayHi2(action: ()->()) -> Void
    //함수는 코드 덩어리
    {
        print("Hi Function2")
    }
    
    var body: some View {
        VStack{
//            Button{
//                sayHi()
//            } label:{
//                Text("Function Button")
//            }
//            
//            Button {
//                sayHi2()
//            } label: {
//                Text("Function Button2")
//            }
        }
        Button {
            print("test")
        } label: {
            Text("Button")
        }
        Button {
            sayHi2 {
                <#code#>
            } lable:{
                Text("Button")
            }
        }
        
//        Button(action: () -> Void, label: () -> _)
        
        Button(action: {print("Hi closure")} ){
            Text("Closure Button")
        }
        Text("Test")
    }
}

#Preview {
    MyClosure()
}
