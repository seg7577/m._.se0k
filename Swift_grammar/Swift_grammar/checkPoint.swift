//
//  checkPoint.swift
//  Swift_grammar
//
//  Created by m._.se0k on 9/4/24.
//

import SwiftUI

// optional, optional chaining, binding, closure, struct


struct Friend{
    let name: String
    let pet: Pet?
}

enum Pet{
    case cat(String)
    case dog(String)
}

struct checkPoint: View {
    
    
    var pepe: Friend = Friend(name: "pepe", pet: Pet.dog("coco"))
    var mimi: Friend = Friend(name: "mimi", pet: Pet.cat"pepe")
    
    @State var pet: String = "제 절친의 애완동물은요"
    
    var body: some View {
        VStack{
            Text(pet)
            Button {
                if let petName = mimi.pet{
                    pet = petName
                } else{
                    pet = "애완동물이 없습니다."
                }
                
                
//                if mimi.pet == "" {
//                    pet = "애완동물이 없습니다."
//                } else{
//                    pet = mimi.pet
//                }
                
            } label: {
                Text("눌러주세요")
            }
        }
        
    }
}

#Preview {
    checkPoint()
}
