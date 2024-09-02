//
//  MyClass.swift
//  Swift_grammar
//
//  Created by m._.se0k on 9/2/24.
//

import SwiftUI

struct Person{
    var name: String
    let age: Int
}

class PersonClass{
    var name: String
    let age: Int
    
    init(name: String, age: Int){
        self.name = name
        self.age = age
    }
    //self -> C++에서의 this의 개념과 같음
    //init -> C++에서의 생성자의 개념과 같음
}

struct MyClass: View {
    
    //let leeo = Person(name: "Leeo", age: 22)
    @State var nickName: String = "None"
    
    var body: some View {
        VStack{
            Text(nickName)
            
            Button{
                var leeo = PersonClass(name: "Leeo", age: 23)
                var fakeLeeo = leeo // -> 구조체의 경우 값을 복사하는 형태로 진행이 되지만 클래스의 경우 참조형식으로 진행됨. 즉, 단순 값 복사가 아닌 leeo 객체의 주소값을 넘기며                   fakeLeeo가 leeo 객체의 주소를 가리키는 형태로 진행 되기에 예상한 Leeo2가 아닌 Leeo3가 출력이 되는 것. (C++과는 다른 개념이니 헷갈리지 X)
                
                leeo.name = "Leeo2"
                fakeLeeo.name = "Leeo3"
                nickName = leeo.name
            } label:{
                Text("Hit")
            }
            
        }
       
    }
}

#Preview {
    MyClass()
}
