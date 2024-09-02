//
//  MyOptionalChaining.swift
//  Swift_grammar
//
//  Created by m._.se0k on 9/3/24.
//

import SwiftUI

struct Student{
    let name: String
    let pet: Pet?
    
}

struct Pet{
    let name: String
    let age: Int
}

struct MyOptionalChaining: View {
    
    let leeo = Student(name: "Leeo", pet: Pet(name: "bibi", age: 10))
    
    var body: some View {
        VStack{
            Text(leeo.name)
            
            if let petName = leeo.pet?.name{    //-> 옵셔널 바인딩을 이용하여 안전하게 코드를 설계함
                Text(petName)
            }
            
            
        }
    }
}

#Preview {
    MyOptionalChaining()
}
