//
//  MyMethod.swift
//  Swift_grammar
//
//  Created by m._.se0k on 9/3/24.
//

import SwiftUI

func returnLeeo() -> String { // -> 함수
    return "Leeo"
}
func returnLeeo2() ->String{
    return "Leeo2"
}
// 함수 { } 코드 블록 내에서 사용 되는 것을 의미함
// 메소드 <- enum, strcut, class 안에서 되는 함수

struct MyMethod: View {
    
    @State var name: String = "m._.se0k"
    
    var body: some View {
        VStack{
            Text(name)
            Text(returnLeeo2())
            Button{
                name = returnLeeo()
                    
            } label: {
                Text("Hitto")
            }
        }
    }
    
    func returnLeeo3() -> String{
        return "Leeo3"
    }
}


struct MyMethod_Previews: PreviewProvider{
    static var previews: some View{
        MyMethod()
        //returnLeeo()  // -> 함수
        //returnLeeo2() // -> 함수
        //returnLeeo3() // -> 메서드
        //returnLeeo4() // -> 함수
    }
    
    func returnLeeo4() -> String { //-> 구조체 내부에서의 경우 함수라고 볼 수 있음
        return "Leeo4"
    }
}

