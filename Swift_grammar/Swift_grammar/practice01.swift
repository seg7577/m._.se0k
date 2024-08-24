//
//  practice01.swift
//  Swift_ grammar
//
//  Created by m._.se0k on 8/23/24.
//

import SwiftUI

struct practice01: View {
    @State var menu: String? = "오늘 뭐 먹지"
    let menus:[Menu] = [.apple, .banana, .sushi, .pho]
    
    enum Menu: String{
        case apple = "사과"
        case banana = "바나나"
        case sushi = "스시"
        case pho = "쌀국수"
    }
    
    var body: some View {
        VStack{
            if menu == "사과" || menu == "스시"{
                Text("너무 맛있는 \(menu!)")
            } else{
                Text("왕머리")
            }
            Button{
                menu = menus.randomElement()?.rawValue
            }label:{
                Text("눌러요!")
            }
        }
    }
}

#Preview {
    practice01()
}
